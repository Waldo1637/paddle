package ca.mcgill.sable.soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class ACmpgBinop extends PBinop
{
    private TCmpg _cmpg_;

    public ACmpgBinop()
    {
    }

    public ACmpgBinop(
        TCmpg _cmpg_)
    {
        setCmpg(_cmpg_);

    }
    public Object clone()
    {
        return new ACmpgBinop(
            (TCmpg) cloneNode(_cmpg_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACmpgBinop(this);
    }

    public TCmpg getCmpg()
    {
        return _cmpg_;
    }

    public void setCmpg(TCmpg node)
    {
        if(_cmpg_ != null)
        {
            _cmpg_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _cmpg_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_cmpg_);
    }

    void removeChild(Node child)
    {
        if(_cmpg_ == child)
        {
            _cmpg_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_cmpg_ == oldChild)
        {
            setCmpg((TCmpg) newChild);
            return;
        }

    }
}