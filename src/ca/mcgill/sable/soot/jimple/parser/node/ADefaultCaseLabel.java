package ca.mcgill.sable.soot.jimple.parser.node;

import java.util.*;
import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class ADefaultCaseLabel extends PCaseLabel
{
    private TDefault _default_;

    public ADefaultCaseLabel()
    {
    }

    public ADefaultCaseLabel(
        TDefault _default_)
    {
        setDefault(_default_);

    }
    public Object clone()
    {
        return new ADefaultCaseLabel(
            (TDefault) cloneNode(_default_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADefaultCaseLabel(this);
    }

    public TDefault getDefault()
    {
        return _default_;
    }

    public void setDefault(TDefault node)
    {
        if(_default_ != null)
        {
            _default_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _default_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_default_);
    }

    void removeChild(Node child)
    {
        if(_default_ == child)
        {
            _default_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_default_ == oldChild)
        {
            setDefault((TDefault) newChild);
            return;
        }

    }
}