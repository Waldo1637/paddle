package ca.mcgill.sable.soot.jimple.parser.node;

import java.util.*;
import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class TCmpeq extends Token
{
    public TCmpeq()
    {
        super.setText("==");
    }

    public TCmpeq(int line, int pos)
    {
        super.setText("==");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TCmpeq(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCmpeq(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TCmpeq text.");
    }
}