// package ca.mcgill.sable.soot.virtualCalls;
package ca.mcgill.sable.soot.jimple.toolkit.invoke;

// import java.util.*;
import java.io.*;
import ca.mcgill.sable.soot.*;
import ca.mcgill.sable.soot.jimple.*;
import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.baf.*; 
import ca.mcgill.sable.soot.coffi.*;
// import ca.mcgill.sable.soot.sideEffect.*;

public class ClassHierarchyAnalysis {
  /*
 public static InvokeGraph newInvokeGraph(SootClassManager manager, String initialClass)
 {

  return ( new InvokeGraph(manager, initialClass) );

 }
 */

 public static InvokeGraph newInvokeGraph(SootClass initialClass)
 {

  return ( new InvokeGraph(initialClass) );

 }



}