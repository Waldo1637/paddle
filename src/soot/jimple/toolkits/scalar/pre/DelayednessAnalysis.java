package soot.jimple.toolkits.scalar.pre;

import soot.*;
import soot.jimple.*;
import soot.toolkits.scalar.*;
import soot.toolkits.graph.*;
import java.util.*;

/** An expression is <i>delayed</i> at the entrance to basic block <code>b</code> 
 * if it is anticipatable and earliest at that point and if all subsequent
 * computations of it are in block <code>b</code>. */
class DelayednessAnalysis extends ForwardFlowAnalysis
{
    BoundedFlowSet emptySet;
    FlowUniverse exprUniv;

    HashMap blockToGenerateSet;
    HashMap blockToPreserveSet;
    AnticipEarliestExprs anea;
    BlockGraph g;

    public DelayednessAnalysis(BlockGraph g, AnticipEarliestExprs anea, FlowUniverse exprUniv)
    {
        super(g);
        blockToGenerateSet = new HashMap(g.size() * 2 + 1, 0.7f);
        blockToPreserveSet = new HashMap(g.size() * 2 + 1, 0.7f);
        this.anea = anea;
        this.g = g;

        emptySet = new ArrayPackedSet(exprUniv);
        this.exprUniv = exprUniv;

        Iterator blockIt = g.iterator();
        while (blockIt.hasNext())
        {
            Block b = (Block)blockIt.next();

            BoundedFlowSet aneaSet = anea.getAnticipEarliestExprsBefore(b);
            blockToGenerateSet.put(b, aneaSet);

            BoundedFlowSet ant = LocallyAnticipatableExprs.getAntLocExprsOf(b, exprUniv);
            ant.complement(ant);
            blockToPreserveSet.put(b, ant);
        }

        doAnalysis();
    }

    protected void customizeInitialFlowGraph()
    {
        Iterator blockIt = g.getHeads().iterator();

        while (blockIt.hasNext())
        {
            Block b = (Block) blockIt.next();
            unitToAfterFlow.put(b, anea.getAnticipEarliestExprsBefore(b));
        }
    }

    protected Object newInitialFlow()
    {
        return emptySet.clone();
    }

    protected void copy(Object source, Object dest)
    {
        FlowSet sourceSet = (FlowSet) source,
            destSet = (FlowSet) dest;
        
        sourceSet.copy(destSet);
    }

    protected void merge(Object in1, Object in2, Object out)
    {
        FlowSet inSet1 = (FlowSet) in1,
            inSet2 = (FlowSet) in2;
        
        FlowSet outSet = (FlowSet) out;
        
        inSet1.intersection(inSet2, outSet);
    }

    protected void flowThrough(Object inValue, Directed b, Object outValue)
    {
        BoundedFlowSet in = (BoundedFlowSet) inValue, out = (BoundedFlowSet) outValue;

        // Add generated sets to `out'.
        in.union((FlowSet) blockToGenerateSet.get(b), out);

        // Intersect with \neg AntLoc.
        out.intersection((FlowSet) blockToPreserveSet.get(b), out);
    }
}