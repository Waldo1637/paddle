package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import soot.jimple.parser.analysis.*;

public final class X1PCaseStmt extends XPCaseStmt
{
    private XPCaseStmt _xPCaseStmt_;
    private PCaseStmt _pCaseStmt_;

    public X1PCaseStmt()
    {
    }

    public X1PCaseStmt(
        XPCaseStmt _xPCaseStmt_,
        PCaseStmt _pCaseStmt_)
    {
        setXPCaseStmt(_xPCaseStmt_);
        setPCaseStmt(_pCaseStmt_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public XPCaseStmt getXPCaseStmt()
    {
        return _xPCaseStmt_;
    }

    public void setXPCaseStmt(XPCaseStmt node)
    {
        if(_xPCaseStmt_ != null)
        {
            _xPCaseStmt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _xPCaseStmt_ = node;
    }

    public PCaseStmt getPCaseStmt()
    {
        return _pCaseStmt_;
    }

    public void setPCaseStmt(PCaseStmt node)
    {
        if(_pCaseStmt_ != null)
        {
            _pCaseStmt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pCaseStmt_ = node;
    }

    void removeChild(Node child)
    {
        if(_xPCaseStmt_ == child)
        {
            _xPCaseStmt_ = null;
        }

        if(_pCaseStmt_ == child)
        {
            _pCaseStmt_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_xPCaseStmt_) +
            toString(_pCaseStmt_);
    }
}