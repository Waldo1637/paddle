package ca.mcgill.sable.soot.jimple.parser.node;

import java.util.*;
import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class AAssignStatement extends PStatement
{
    private PVariable _variable_;
    private TEquals _equals_;
    private PExpression _expression_;
    private TSemicolon _semicolon_;

    public AAssignStatement()
    {
    }

    public AAssignStatement(
        PVariable _variable_,
        TEquals _equals_,
        PExpression _expression_,
        TSemicolon _semicolon_)
    {
        setVariable(_variable_);

        setEquals(_equals_);

        setExpression(_expression_);

        setSemicolon(_semicolon_);

    }
    public Object clone()
    {
        return new AAssignStatement(
            (PVariable) cloneNode(_variable_),
            (TEquals) cloneNode(_equals_),
            (PExpression) cloneNode(_expression_),
            (TSemicolon) cloneNode(_semicolon_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAssignStatement(this);
    }

    public PVariable getVariable()
    {
        return _variable_;
    }

    public void setVariable(PVariable node)
    {
        if(_variable_ != null)
        {
            _variable_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _variable_ = node;
    }

    public TEquals getEquals()
    {
        return _equals_;
    }

    public void setEquals(TEquals node)
    {
        if(_equals_ != null)
        {
            _equals_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _equals_ = node;
    }

    public PExpression getExpression()
    {
        return _expression_;
    }

    public void setExpression(PExpression node)
    {
        if(_expression_ != null)
        {
            _expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _expression_ = node;
    }

    public TSemicolon getSemicolon()
    {
        return _semicolon_;
    }

    public void setSemicolon(TSemicolon node)
    {
        if(_semicolon_ != null)
        {
            _semicolon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _semicolon_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_variable_)
            + toString(_equals_)
            + toString(_expression_)
            + toString(_semicolon_);
    }

    void removeChild(Node child)
    {
        if(_variable_ == child)
        {
            _variable_ = null;
            return;
        }

        if(_equals_ == child)
        {
            _equals_ = null;
            return;
        }

        if(_expression_ == child)
        {
            _expression_ = null;
            return;
        }

        if(_semicolon_ == child)
        {
            _semicolon_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_variable_ == oldChild)
        {
            setVariable((PVariable) newChild);
            return;
        }

        if(_equals_ == oldChild)
        {
            setEquals((TEquals) newChild);
            return;
        }

        if(_expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        if(_semicolon_ == oldChild)
        {
            setSemicolon((TSemicolon) newChild);
            return;
        }

    }
}