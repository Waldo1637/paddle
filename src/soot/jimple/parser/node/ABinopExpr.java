package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import soot.jimple.parser.analysis.*;

public final class ABinopExpr extends PBinopExpr
{
    private PImmediate _left_;
    private PBinop _binop_;
    private PImmediate _right_;

    public ABinopExpr()
    {
    }

    public ABinopExpr(
        PImmediate _left_,
        PBinop _binop_,
        PImmediate _right_)
    {
        setLeft(_left_);

        setBinop(_binop_);

        setRight(_right_);

    }
    public Object clone()
    {
        return new ABinopExpr(
            (PImmediate) cloneNode(_left_),
            (PBinop) cloneNode(_binop_),
            (PImmediate) cloneNode(_right_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABinopExpr(this);
    }

    public PImmediate getLeft()
    {
        return _left_;
    }

    public void setLeft(PImmediate node)
    {
        if(_left_ != null)
        {
            _left_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _left_ = node;
    }

    public PBinop getBinop()
    {
        return _binop_;
    }

    public void setBinop(PBinop node)
    {
        if(_binop_ != null)
        {
            _binop_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _binop_ = node;
    }

    public PImmediate getRight()
    {
        return _right_;
    }

    public void setRight(PImmediate node)
    {
        if(_right_ != null)
        {
            _right_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _right_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_left_)
            + toString(_binop_)
            + toString(_right_);
    }

    void removeChild(Node child)
    {
        if(_left_ == child)
        {
            _left_ = null;
            return;
        }

        if(_binop_ == child)
        {
            _binop_ = null;
            return;
        }

        if(_right_ == child)
        {
            _right_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_left_ == oldChild)
        {
            setLeft((PImmediate) newChild);
            return;
        }

        if(_binop_ == oldChild)
        {
            setBinop((PBinop) newChild);
            return;
        }

        if(_right_ == oldChild)
        {
            setRight((PImmediate) newChild);
            return;
        }

    }
}