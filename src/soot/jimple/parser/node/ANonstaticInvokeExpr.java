package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import soot.jimple.parser.analysis.*;

public final class ANonstaticInvokeExpr extends PInvokeExpr
{
    private PNonstaticInvoke _nonstaticInvoke_;
    private PLocalName _localName_;
    private TDot _dot_;
    private PMethodSignature _methodSignature_;
    private TLParen _lParen_;
    private PArgList _argList_;
    private TRParen _rParen_;

    public ANonstaticInvokeExpr()
    {
    }

    public ANonstaticInvokeExpr(
        PNonstaticInvoke _nonstaticInvoke_,
        PLocalName _localName_,
        TDot _dot_,
        PMethodSignature _methodSignature_,
        TLParen _lParen_,
        PArgList _argList_,
        TRParen _rParen_)
    {
        setNonstaticInvoke(_nonstaticInvoke_);

        setLocalName(_localName_);

        setDot(_dot_);

        setMethodSignature(_methodSignature_);

        setLParen(_lParen_);

        setArgList(_argList_);

        setRParen(_rParen_);

    }
    public Object clone()
    {
        return new ANonstaticInvokeExpr(
            (PNonstaticInvoke) cloneNode(_nonstaticInvoke_),
            (PLocalName) cloneNode(_localName_),
            (TDot) cloneNode(_dot_),
            (PMethodSignature) cloneNode(_methodSignature_),
            (TLParen) cloneNode(_lParen_),
            (PArgList) cloneNode(_argList_),
            (TRParen) cloneNode(_rParen_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANonstaticInvokeExpr(this);
    }

    public PNonstaticInvoke getNonstaticInvoke()
    {
        return _nonstaticInvoke_;
    }

    public void setNonstaticInvoke(PNonstaticInvoke node)
    {
        if(_nonstaticInvoke_ != null)
        {
            _nonstaticInvoke_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _nonstaticInvoke_ = node;
    }

    public PLocalName getLocalName()
    {
        return _localName_;
    }

    public void setLocalName(PLocalName node)
    {
        if(_localName_ != null)
        {
            _localName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _localName_ = node;
    }

    public TDot getDot()
    {
        return _dot_;
    }

    public void setDot(TDot node)
    {
        if(_dot_ != null)
        {
            _dot_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _dot_ = node;
    }

    public PMethodSignature getMethodSignature()
    {
        return _methodSignature_;
    }

    public void setMethodSignature(PMethodSignature node)
    {
        if(_methodSignature_ != null)
        {
            _methodSignature_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _methodSignature_ = node;
    }

    public TLParen getLParen()
    {
        return _lParen_;
    }

    public void setLParen(TLParen node)
    {
        if(_lParen_ != null)
        {
            _lParen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _lParen_ = node;
    }

    public PArgList getArgList()
    {
        return _argList_;
    }

    public void setArgList(PArgList node)
    {
        if(_argList_ != null)
        {
            _argList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _argList_ = node;
    }

    public TRParen getRParen()
    {
        return _rParen_;
    }

    public void setRParen(TRParen node)
    {
        if(_rParen_ != null)
        {
            _rParen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _rParen_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_nonstaticInvoke_)
            + toString(_localName_)
            + toString(_dot_)
            + toString(_methodSignature_)
            + toString(_lParen_)
            + toString(_argList_)
            + toString(_rParen_);
    }

    void removeChild(Node child)
    {
        if(_nonstaticInvoke_ == child)
        {
            _nonstaticInvoke_ = null;
            return;
        }

        if(_localName_ == child)
        {
            _localName_ = null;
            return;
        }

        if(_dot_ == child)
        {
            _dot_ = null;
            return;
        }

        if(_methodSignature_ == child)
        {
            _methodSignature_ = null;
            return;
        }

        if(_lParen_ == child)
        {
            _lParen_ = null;
            return;
        }

        if(_argList_ == child)
        {
            _argList_ = null;
            return;
        }

        if(_rParen_ == child)
        {
            _rParen_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_nonstaticInvoke_ == oldChild)
        {
            setNonstaticInvoke((PNonstaticInvoke) newChild);
            return;
        }

        if(_localName_ == oldChild)
        {
            setLocalName((PLocalName) newChild);
            return;
        }

        if(_dot_ == oldChild)
        {
            setDot((TDot) newChild);
            return;
        }

        if(_methodSignature_ == oldChild)
        {
            setMethodSignature((PMethodSignature) newChild);
            return;
        }

        if(_lParen_ == oldChild)
        {
            setLParen((TLParen) newChild);
            return;
        }

        if(_argList_ == oldChild)
        {
            setArgList((PArgList) newChild);
            return;
        }

        if(_rParen_ == oldChild)
        {
            setRParen((TRParen) newChild);
            return;
        }

    }
}