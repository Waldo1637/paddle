package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import soot.jimple.parser.analysis.*;

public final class AShlBinop extends PBinop
{
    private TShl _shl_;

    public AShlBinop()
    {
    }

    public AShlBinop(
        TShl _shl_)
    {
        setShl(_shl_);

    }
    public Object clone()
    {
        return new AShlBinop(
            (TShl) cloneNode(_shl_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAShlBinop(this);
    }

    public TShl getShl()
    {
        return _shl_;
    }

    public void setShl(TShl node)
    {
        if(_shl_ != null)
        {
            _shl_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _shl_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_shl_);
    }

    void removeChild(Node child)
    {
        if(_shl_ == child)
        {
            _shl_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_shl_ == oldChild)
        {
            setShl((TShl) newChild);
            return;
        }

    }
}