package ca.mcgill.sable.soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class X1PArrayDescriptor extends XPArrayDescriptor
{
    private XPArrayDescriptor _xPArrayDescriptor_;
    private PArrayDescriptor _pArrayDescriptor_;

    public X1PArrayDescriptor()
    {
    }

    public X1PArrayDescriptor(
        XPArrayDescriptor _xPArrayDescriptor_,
        PArrayDescriptor _pArrayDescriptor_)
    {
        setXPArrayDescriptor(_xPArrayDescriptor_);
        setPArrayDescriptor(_pArrayDescriptor_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public XPArrayDescriptor getXPArrayDescriptor()
    {
        return _xPArrayDescriptor_;
    }

    public void setXPArrayDescriptor(XPArrayDescriptor node)
    {
        if(_xPArrayDescriptor_ != null)
        {
            _xPArrayDescriptor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _xPArrayDescriptor_ = node;
    }

    public PArrayDescriptor getPArrayDescriptor()
    {
        return _pArrayDescriptor_;
    }

    public void setPArrayDescriptor(PArrayDescriptor node)
    {
        if(_pArrayDescriptor_ != null)
        {
            _pArrayDescriptor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pArrayDescriptor_ = node;
    }

    void removeChild(Node child)
    {
        if(_xPArrayDescriptor_ == child)
        {
            _xPArrayDescriptor_ = null;
        }

        if(_pArrayDescriptor_ == child)
        {
            _pArrayDescriptor_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_xPArrayDescriptor_) +
            toString(_pArrayDescriptor_);
    }
}