package ca.mcgill.sable.soot.jimple.parser.node;

import java.util.*;
import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class AOrBinop extends PBinop
{
    private TOr _or_;

    public AOrBinop()
    {
    }

    public AOrBinop(
        TOr _or_)
    {
        setOr(_or_);

    }
    public Object clone()
    {
        return new AOrBinop(
            (TOr) cloneNode(_or_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOrBinop(this);
    }

    public TOr getOr()
    {
        return _or_;
    }

    public void setOr(TOr node)
    {
        if(_or_ != null)
        {
            _or_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _or_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_or_);
    }

    void removeChild(Node child)
    {
        if(_or_ == child)
        {
            _or_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_or_ == oldChild)
        {
            setOr((TOr) newChild);
            return;
        }

    }
}