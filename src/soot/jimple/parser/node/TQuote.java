package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import soot.jimple.parser.analysis.*;

public final class TQuote extends Token
{
    public TQuote()
    {
        super.setText("\'");
    }

    public TQuote(int line, int pos)
    {
        super.setText("\'");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TQuote(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTQuote(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TQuote text.");
    }
}