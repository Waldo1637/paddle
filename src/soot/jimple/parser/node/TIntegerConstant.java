package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import soot.jimple.parser.analysis.*;

public final class TIntegerConstant extends Token
{
    public TIntegerConstant(String text)
    {
        setText(text);
    }

    public TIntegerConstant(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TIntegerConstant(getText(), getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTIntegerConstant(this);
    }
}