package ca.mcgill.sable.soot.jimple.parser.node;

import java.util.*;
import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class ABinopExpression extends PExpression
{
    private PBinopExpr _binopExpr_;

    public ABinopExpression()
    {
    }

    public ABinopExpression(
        PBinopExpr _binopExpr_)
    {
        setBinopExpr(_binopExpr_);

    }
    public Object clone()
    {
        return new ABinopExpression(
            (PBinopExpr) cloneNode(_binopExpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABinopExpression(this);
    }

    public PBinopExpr getBinopExpr()
    {
        return _binopExpr_;
    }

    public void setBinopExpr(PBinopExpr node)
    {
        if(_binopExpr_ != null)
        {
            _binopExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _binopExpr_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_binopExpr_);
    }

    void removeChild(Node child)
    {
        if(_binopExpr_ == child)
        {
            _binopExpr_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_binopExpr_ == oldChild)
        {
            setBinopExpr((PBinopExpr) newChild);
            return;
        }

    }
}