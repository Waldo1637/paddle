/* Soot - a J*va Optimization Framework
 * Copyright (C) 1997-1999 Raja Vallee-Rai
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

/*
 * Modified by the Sable Research Group and others 1997-1999.  
 * See the 'credits' file distributed with Soot for the complete list of
 * contributors.  (Soot is distributed at http://www.sable.mcgill.ca/soot)
 */


package soot.jimple;

import soot.*;
import soot.toolkits.scalar.*;
import soot.jimple.toolkits.scalar.*;
import soot.jimple.toolkits.typing.*;
import soot.jimple.toolkits.base.*;
import soot.util.*;
import java.util.*;
import soot.baf.*;
import java.io.*;

public class JimpleBody extends StmtBody
{
    /**
        Construct an empty JimpleBody 
     **/
     
    JimpleBody(SootMethod m)
    {
        super(m);
    }

    /** Clones the current body, making deep copies of the contents. */

    public Object clone()
    {
        Body b = new JimpleBody(getMethod());
        b.importBodyContentsFrom(this);
        return b;
    }

    /**
        Constructs a JimpleBody from the given Body.
     */

    JimpleBody(Body body, Map options)
    {
        super(body.getMethod());

        boolean noSplitting = Options.getBoolean(options, "no-splitting");
        boolean noTyping = Options.getBoolean(options, "no-typing");
        boolean aggregateAllLocals = Options.getBoolean(options, "aggregate-all-locals");
        boolean noAggregating = Options.getBoolean(options, "no-aggregating");
        boolean useOriginalNames = Options.getBoolean(options, "use-original-names");
        boolean usePacking = Options.getBoolean(options, "pack-locals");
        boolean noNopElimination = Options.getBoolean(options, "no-nop-elimination");
        
        ClassFileBody fileBody;

        if(useOriginalNames)
            soot.coffi.Util.setFaithfulNaming(true);
            
        if(body instanceof ClassFileBody)
            fileBody = (ClassFileBody) body;
        else
            throw new RuntimeException("Can only construct JimpleBody's directly from ClassFileBody's (for now)");

        soot.coffi.ClassFile coffiClass = fileBody.coffiClass;
        soot.coffi.method_info coffiMethod = fileBody.coffiMethod;

        /*
            I need to set these to null to free Coffi structures.
        fileBody.coffiClass = null;
        bafBody.coffiMethod = null;

        */
        if(Main.isVerbose)
            System.out.println("[" + getMethod().getName() + "] Constructing JimpleBody...");

        if(getMethod().isAbstract() || getMethod().isNative() || getMethod().isPhantom())
            return;
            
        if(Main.isProfilingOptimization)
            Main.conversionTimer.start();

        if (coffiMethod == null)
            System.out.println(body.getMethod());
        if(coffiMethod.instructions == null)
        {
            if(Main.isVerbose)
                System.out.println("[" + getMethod().getName() +
                    "]     Parsing Coffi instructions...");

             coffiClass.parseMethod(coffiMethod);
        }
                
        if(coffiMethod.cfg == null)
        {
            if(Main.isVerbose)
                System.out.println("[" + getMethod().getName() +
                    "]     Building Coffi CFG...");

             new soot.coffi.CFG(coffiMethod);

         }

         if(Main.isVerbose)
             System.out.println("[" + getMethod().getName() +
                    "]     Producing naive Jimple...");
                    
         Scene.v().setPhantomRefs(true);
         coffiMethod.cfg.jimplify(coffiClass.constant_pool,
             coffiClass.this_class, this);
         Scene.v().setPhantomRefs(false);

         coffiMethod.instructions = null;
         coffiMethod.cfg = null;
            // don't need these structures anymore.

        // Jimple.printStmtList_debug(this, System.out);

        if(!noSplitting)
        {
            if(Main.isProfilingOptimization)
                Main.splitTimer.start();

            LocalSplitter.v().transform(this, "jb.ls");

            if(!noTyping)
            {
                if(Main.isProfilingOptimization)
                    Main.assignTimer.start();

                // Jimple.printStmtListBody_debug(this, System.out);
                //System.out.println("before typing");
                //printTo(new PrintWriter(System.out, true));
                TypeAssigner.v().transform(this, "jb.tr");

                //System.out.println("after typing");
                //printTo(new PrintWriter(System.out, true));
                
                if(typingFailed())
                {
                    patchForTyping();
                    
                    TypeAssigner.v().transform(this, "jb.trp");
                    
                    if(typingFailed())
                        throw new RuntimeException("type inference failed!");
                        
                }
            }
        }
        
        //printTo(new PrintWriter(System.out, true));
        
        if(aggregateAllLocals)
        {
            Aggregator.v().transform(this, "jb.a");
            UnusedLocalEliminator.v().transform(this, "jb.ule");
        }
        else if(!noAggregating)
        {
            Aggregator.v().transform(this, "jb.asv", "only-stack-vars");
            UnusedLocalEliminator.v().transform(this, "jb.ule");
        }

        if(!useOriginalNames)
            LocalNameStandardizer.v().transform(this, "jb.lns");
        else
        {   
            LocalPacker.v().transform(this, "jb.ulp", "unsplit-original-locals");
            LocalNameStandardizer.v().transform(this, "jb.lns", "only-stack-names");
        }
        
        //printDebugTo(new PrintWriter(System.out, true));
        
        if(usePacking)
        {
            LocalPacker.v().transform(this, "jb.lp");
        }


        if(!noNopElimination)
            NopEliminator.v().transform(this, "jb.ne");
                    
        if(soot.Main.isProfilingOptimization)
            soot.Main.stmtCount += getUnits().size();
    }

    /** Temporary patch to get the typing algorithm working.
      */
      
    private void patchForTyping()
    {
        int localCount = 0;
        Local newObjectLocal = null;
        
        CopyPropagator.v().transform(this, "jb.pft.cp");
        DeadAssignmentEliminator.v().transform(this, "jb.pft.dae");
        UnusedLocalEliminator.v().transform(this, "jb.pft.ule");
     
        List unitList = new ArrayList(); 
        unitList.addAll(getUnits());

        Iterator it = unitList.iterator();
        for (; it.hasNext(); )
          {
            Stmt s = (Stmt)it.next();
                    
            if(s instanceof AssignStmt)
            {
                AssignStmt as = (AssignStmt) s;
                
                if(as.getRightOp() instanceof NewExpr &&
                   as.getLeftOp() instanceof Local)
                {
                    // Add new local
                        Local tmpLocal = Jimple.v().newLocal("tmp" + localCount, 
                            UnknownType.v());
                        getLocals().add(tmpLocal);
                            
                        localCount++;
                    
                    // Change left hand side of new
                        newObjectLocal = (Local) as.getLeftOp();
                        as.setLeftOp(tmpLocal);
                    
                    // Find matching special invoke
                    {
                        Iterator matchIt = getUnits().iterator(getUnits().getSuccOf(s));
                        boolean foundMatch = false;
                               
                        while(matchIt.hasNext())
                        {   
                            Stmt r = (Stmt) matchIt.next();
                            
                            if(r instanceof InvokeStmt)
                            {
                               InvokeExpr expr = (InvokeExpr) ((InvokeStmt) r).getInvokeExpr();
                                
                                if(expr instanceof SpecialInvokeExpr &&
                                    ((SpecialInvokeExpr) expr).getBase() == newObjectLocal)
                                {
                                    // Set base of special invoke
                                        ((SpecialInvokeExpr) expr).setBase(tmpLocal);
                                    
                                    // Add copy newObjectLocal = tmpLocal
                                    getUnits().insertAfter(Jimple.v().newAssignStmt(newObjectLocal,
                                        tmpLocal), r);
                                 
                                    foundMatch = true;
                                    break;       
                                }
                            }
                        }
                        
                        if(!foundMatch)
                            throw new RuntimeException("unable to patch code"); 
                    }
                }
            }
        }
    }
    
    private boolean typingFailed()
    {
        // Check to see if any locals are untyped
        {
            Iterator localIt = this.getLocals().iterator();

            while(localIt.hasNext())
            {
                Local l = (Local) localIt.next();

                  if(l.getType().equals(UnknownType.v()) ||
                    l.getType().equals(ErroneousType.v()))
                {
                    return true;
                }
            }
        }
        
        return false;
    }

//      public void printDebugTo(java.io.PrintWriter out)
//      {   
//          StmtBody stmtBody = this; 
//          Chain units = stmtBody.getUnits();
//          Map stmtToName = new HashMap(units.size() * 2 + 1, 0.7f);
//          //CompleteUnitGraph stmtGraph = new CompleteUnitGraph(units);
        
//          //LocalDefs localDefs = new SimpleLocalDefs(stmtGraph);

//          System.out.println("debug output for " + getMethod().getSignature());
//          /*
//          LocalUses localUses = new LocalUses(stmtGraph, localDefs);
//  */
        
//          //LocalCopies localCopies = new SimpleLocalCopies(stmtGraph);
//          // LiveLocals liveLocals = new SimpleLiveLocals(stmtGraph);
//          //EqualLocals equalLocals = new SimpleEqualLocals(stmtGraph);
        
//          // Create statement name table
//          {
//             int labelCount = 0;

//              Iterator stmtIt = units.iterator();

//              while(stmtIt.hasNext())
//              {
//                  Stmt s = (Stmt) stmtIt.next();

//                  stmtToName.put(s, new Integer(labelCount++).toString());
//              }
//          }

//          Zonation zonation = new Zonation(this);

//          // must re-introduce iterator here.
//          for(int j = 0; j < units.size(); j++)
//          {
//              Stmt s = ((Stmt) stmtList.get(j));

//              out.print("    " + stmtToName.get(s) + ": ");

//              out.print(s.toBriefString(stmtToName, "        "));
//              out.print(";");

//              out.print(zonation.getZoneOf(s));
            
//          /*               
//              // Print info about live locals
//              {
//                  out.print(liveLocals.getLiveLocalsAfter(s));
//              } */
            
//              /*
//              // Print info about local copies
//              {
//                  out.print(localCopies.getCopiesBefore(s));
//              }
//              */
//              /*
//              // Print info about local equalities
//              {
//                  out.print(equalLocals.getCopiesAt(s));
//              }
//  */

//               /*
//               // Print info about uses
//                  if(s instanceof DefinitionStmt)
//                  {
//                      Iterator useIt = localUses.getUsesOf((DefinitionStmt) s).iterator();

//                      out.print("   (");

//                      while(useIt.hasNext())
//                      {
//                          if(k != 0)
//                              out.print(", ");

//                          out.print(stmtToName.get(useIt.next()));
//                      }

//                      out.print(")");
//                  }
//              */
//          /*
//              // Print info about defs
//              {
//                  Iterator boxIt = s.getUseBoxes().iterator();

//                  while(boxIt.hasNext())
//                  {
//                      ValueBox useBox = (ValueBox) boxIt.next();

//                      if(useBox.getValue() instanceof Local)
//                      {
//                          Iterator defIt = localDefs.getDefsOfAt((Local) useBox.getValue(), s).iterator();

//                          out.print("  " + useBox.getValue() + " = {");

//                          while(defIt.hasNext())
//                          {
//                              out.print(stmtToName.get((Stmt) defIt.next()));

//                              if(defIt.hasNext())
//                                  out.print(", ");
//                          }

//                          out.print("}");
//                      }
//                  }
//              } 
//            */
            
//              /*
//              // Print info about successors
//              {
//                  Iterator succIt = stmtGraph.getSuccsOf(s).iterator();

//                  out.print("    [");

//                  if(succIt.hasNext())
//                  {
//                      out.print(stmtToName.get(succIt.next()));

//                      while(succIt.hasNext())
//                      {
//                          Stmt stmt = (Stmt) succIt.next();

//                          out.print(", " + stmtToName.get(stmt));
//                      }
//                  }

//                  out.print("]");
//              }
//                  */
//              /*
//              // Print info about predecessors
//              {
//                  Stmt[] preds = stmtGraph.getPredsOf(s);

//                  out.print("    {");

//                  for(int k = 0; k < preds.length; k++)
//                  {
//                      if(k != 0)
//                          out.print(", ");

//                      out.print(stmtToName.get(preds[k]));
//                  }

//                  out.print("}");
//              }
//              */
//              out.println();
//          }

//          // Print out exceptions
//          {
//              Iterator trapIt = stmtBody.getTraps().iterator();

//              while(trapIt.hasNext())
//              {
//                  Trap trap = (Trap) trapIt.next();

//                  out.println(".catch " + trap.getException().getName() + " from " +
//                      stmtToName.get(trap.getBeginUnit()) + " to " + stmtToName.get(trap.getEndUnit()) +
//                      " with " + stmtToName.get(trap.getHandlerUnit()));
//              }
//          }
//      }
}
