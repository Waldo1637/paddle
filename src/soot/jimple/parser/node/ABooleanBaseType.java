package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import soot.jimple.parser.analysis.*;

public final class ABooleanBaseType extends PBaseType
{
    private TBoolean _boolean_;

    public ABooleanBaseType()
    {
    }

    public ABooleanBaseType(
        TBoolean _boolean_)
    {
        setBoolean(_boolean_);

    }
    public Object clone()
    {
        return new ABooleanBaseType(
            (TBoolean) cloneNode(_boolean_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABooleanBaseType(this);
    }

    public TBoolean getBoolean()
    {
        return _boolean_;
    }

    public void setBoolean(TBoolean node)
    {
        if(_boolean_ != null)
        {
            _boolean_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _boolean_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_boolean_);
    }

    void removeChild(Node child)
    {
        if(_boolean_ == child)
        {
            _boolean_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_boolean_ == oldChild)
        {
            setBoolean((TBoolean) newChild);
            return;
        }

    }
}