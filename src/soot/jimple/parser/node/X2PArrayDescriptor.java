package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import soot.jimple.parser.analysis.*;

public final class X2PArrayDescriptor extends XPArrayDescriptor
{
    private PArrayDescriptor _pArrayDescriptor_;

    public X2PArrayDescriptor()
    {
    }

    public X2PArrayDescriptor(
        PArrayDescriptor _pArrayDescriptor_)
    {
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
            toString(_pArrayDescriptor_);
    }
}