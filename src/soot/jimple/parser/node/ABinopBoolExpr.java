package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import soot.jimple.parser.analysis.*;

public final class ABinopBoolExpr extends PBoolExpr
{
    private PBinopExpr _binopExpr_;

    public ABinopBoolExpr()
    {
    }

    public ABinopBoolExpr(
        PBinopExpr _binopExpr_)
    {
        setBinopExpr(_binopExpr_);

    }
    public Object clone()
    {
        return new ABinopBoolExpr(
            (PBinopExpr) cloneNode(_binopExpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABinopBoolExpr(this);
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