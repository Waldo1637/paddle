package ca.mcgill.sable.soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class ABooleanBaseTypeNoName extends PBaseTypeNoName
{
    private TBoolean _boolean_;

    public ABooleanBaseTypeNoName()
    {
    }

    public ABooleanBaseTypeNoName(
        TBoolean _boolean_)
    {
        setBoolean(_boolean_);

    }
    public Object clone()
    {
        return new ABooleanBaseTypeNoName(
            (TBoolean) cloneNode(_boolean_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABooleanBaseTypeNoName(this);
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