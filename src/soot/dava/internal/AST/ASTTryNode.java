package soot.dava.internal.AST;

import soot.*;
import java.util.*;
import soot.jimple.*;
import soot.dava.internal.SET.*;
import soot.dava.toolkits.base.AST.*;

public class ASTTryNode extends ASTLabeledNode
{
    private List tryBody, catchList;
    private Map exceptionMap, paramMap;
    private container tryBodyContainer;

    public class container
    {
	public Object o;

	public container( Object o)
	{
	    this.o = o;
	}
    }

    public ASTTryNode( SETNodeLabel label, List tryBody, List catchList, Map exceptionMap, Map paramMap)
    {
	super( label);

	this.tryBody = tryBody;
	tryBodyContainer = new container( tryBody);

	this.catchList = new ArrayList();
	Iterator cit = catchList.iterator();
	while (cit.hasNext())
	    this.catchList.add( new container( cit.next()));
	
	this.exceptionMap = new HashMap();
	cit = this.catchList.iterator();
	while (cit.hasNext()) {
	    container c = (container) cit.next();
	    this.exceptionMap.put( c, exceptionMap.get( c.o));
	}

	this.paramMap = new HashMap();
	cit = this.catchList.iterator();
	while (cit.hasNext()) {
	    container c = (container) cit.next();
	    this.paramMap.put( c, paramMap.get( c.o));
	}
	
	subBodies.add( tryBodyContainer);
	cit = this.catchList.iterator();
	while (cit.hasNext())
	    subBodies.add( cit.next());
    }

    protected void perform_AnalysisOnSubBodies( ASTAnalysis a)
    {
	if (a instanceof TryContentsFinder) {
	    TryContentsFinder tcf = (TryContentsFinder) a;

	    Iterator sbit = subBodies.iterator();
	    while (sbit.hasNext()) {
		container subBody = (container) sbit.next();

		Iterator it = ((List) subBody.o).iterator();
		while (it.hasNext()) {
		    ASTNode n = (ASTNode) it.next();
		    
		    n.perform_Analysis( a);
		    tcf.v().add_ExceptionSet( subBody, tcf.v().get_ExceptionSet( n));
		}
	    }

	    a.analyseASTNode( this);
	}
	else 
	    super.perform_AnalysisOnSubBodies( a);
    }

    public boolean isEmpty()
    {
	return tryBody.isEmpty();
    }

    public List get_TryBody()
    {
	return tryBody;
    }

    public container get_TryBodyContainer()
    {
	return tryBodyContainer;
    }

    public List get_CatchList()
    {
	return catchList;
    }

    public Map get_ExceptionMap()
    {
	return exceptionMap;
    }

    public Set get_ExceptionSet()
    {
	HashSet s = new HashSet();

	Iterator it = catchList.iterator();
	while (it.hasNext())
	    s.add( exceptionMap.get( it.next()));

	return s;
    }

    public Object clone()
    {
	ArrayList newCatchList = new ArrayList();
	Iterator it = catchList.iterator();
	while (it.hasNext())
	    newCatchList.add( ((container) it.next()).o);

	return new ASTTryNode( get_Label(), tryBody, newCatchList, exceptionMap, paramMap);
    }

    public String toString( Map stmtToName, String indentation)
    {
	StringBuffer b = new StringBuffer();
	
	b.append( label_toString( indentation));

	b.append( indentation);
	b.append( "try");
	b.append( NEWLINE);
	
	b.append( indentation);
	b.append( "{");
	b.append( NEWLINE);

	b.append( body_toString( stmtToName, indentation + TAB, tryBody));

	b.append( indentation);
	b.append( "}");
	b.append( NEWLINE);

	Iterator cit = catchList.iterator();
	while (cit.hasNext()) {
	    container catchBody = (container) cit.next();

	    b.append( indentation);
	    b.append( "catch (");
	    b.append( ((SootClass) exceptionMap.get( catchBody)).getName());
	    b.append( " ");
	    b.append( ((Local) paramMap.get( catchBody)).getName());
	    b.append( ")");
	    b.append( NEWLINE);

	    b.append( indentation);
	    b.append( "{");
	    b.append( NEWLINE);

	    b.append( body_toString( stmtToName, indentation + TAB, (List) catchBody.o));

	    b.append( indentation);
	    b.append( "}");
	    b.append( NEWLINE);
	}

	return b.toString();
    }
}