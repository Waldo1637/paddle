package ca.mcgill.sable.soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class AIdentNonvoidType extends PNonvoidType
{
    private TIdentifier _identifier_;
    private final LinkedList _arrayBrackets_ = new TypedLinkedList(new ArrayBrackets_Cast());

    public AIdentNonvoidType()
    {
    }

    public AIdentNonvoidType(
        TIdentifier _identifier_,
        List _arrayBrackets_)
    {
        setIdentifier(_identifier_);

        {
            Object temp[] = _arrayBrackets_.toArray();
            for(int i = 0; i < temp.length; i++)
            {
                this._arrayBrackets_.add(temp[i]);
            }
        }

    }

    public AIdentNonvoidType(
        TIdentifier _identifier_,
        XPArrayBrackets _arrayBrackets_)
    {
        setIdentifier(_identifier_);

        if(_arrayBrackets_ != null)
        {
            while(_arrayBrackets_ instanceof X1PArrayBrackets)
            {
                this._arrayBrackets_.addFirst(((X1PArrayBrackets) _arrayBrackets_).getPArrayBrackets());
                _arrayBrackets_ = ((X1PArrayBrackets) _arrayBrackets_).getXPArrayBrackets();
            }
            this._arrayBrackets_.addFirst(((X2PArrayBrackets) _arrayBrackets_).getPArrayBrackets());
        }

    }
    public Object clone()
    {
        return new AIdentNonvoidType(
            (TIdentifier) cloneNode(_identifier_),
            cloneList(_arrayBrackets_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIdentNonvoidType(this);
    }

    public TIdentifier getIdentifier()
    {
        return _identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(_identifier_ != null)
        {
            _identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _identifier_ = node;
    }

    public LinkedList getArrayBrackets()
    {
        return _arrayBrackets_;
    }

    public void setArrayBrackets(List list)
    {
        Object temp[] = list.toArray();
        for(int i = 0; i < temp.length; i++)
        {
            _arrayBrackets_.add(temp[i]);
        }
    }

    public String toString()
    {
        return ""
            + toString(_identifier_)
            + toString(_arrayBrackets_);
    }

    void removeChild(Node child)
    {
        if(_identifier_ == child)
        {
            _identifier_ = null;
            return;
        }

        if(_arrayBrackets_.remove(child))
        {
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        for(ListIterator i = _arrayBrackets_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set(newChild);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

    }

    private class ArrayBrackets_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PArrayBrackets node = (PArrayBrackets) o;

            if((node.parent() != null) &&
                (node.parent() != AIdentNonvoidType.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AIdentNonvoidType.this))
            {
                node.parent(AIdentNonvoidType.this);
            }

            return node;
        }
    }
}