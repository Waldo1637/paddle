package ca.mcgill.sable.soot.jimple.parser.node;

import java.util.*;
import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class AUnopBoolExpr extends PBoolExpr
{
    private PUnopExpr _unopExpr_;

    public AUnopBoolExpr()
    {
    }

    public AUnopBoolExpr(
        PUnopExpr _unopExpr_)
    {
        setUnopExpr(_unopExpr_);

    }
    public Object clone()
    {
        return new AUnopBoolExpr(
            (PUnopExpr) cloneNode(_unopExpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAUnopBoolExpr(this);
    }

    public PUnopExpr getUnopExpr()
    {
        return _unopExpr_;
    }

    public void setUnopExpr(PUnopExpr node)
    {
        if(_unopExpr_ != null)
        {
            _unopExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _unopExpr_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_unopExpr_);
    }

    void removeChild(Node child)
    {
        if(_unopExpr_ == child)
        {
            _unopExpr_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_unopExpr_ == oldChild)
        {
            setUnopExpr((PUnopExpr) newChild);
            return;
        }

    }
}