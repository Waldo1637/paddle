package ca.mcgill.sable.soot.jimple.parser.node;

import java.util.*;
import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class AMultBinop extends PBinop
{
    private TMult _mult_;

    public AMultBinop()
    {
    }

    public AMultBinop(
        TMult _mult_)
    {
        setMult(_mult_);

    }
    public Object clone()
    {
        return new AMultBinop(
            (TMult) cloneNode(_mult_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultBinop(this);
    }

    public TMult getMult()
    {
        return _mult_;
    }

    public void setMult(TMult node)
    {
        if(_mult_ != null)
        {
            _mult_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _mult_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_mult_);
    }

    void removeChild(Node child)
    {
        if(_mult_ == child)
        {
            _mult_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_mult_ == oldChild)
        {
            setMult((TMult) newChild);
            return;
        }

    }
}