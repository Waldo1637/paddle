package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import soot.jimple.parser.analysis.*;

public final class TBoolean extends Token
{
    public TBoolean()
    {
        super.setText("boolean");
    }

    public TBoolean(int line, int pos)
    {
        super.setText("boolean");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TBoolean(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTBoolean(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TBoolean text.");
    }
}