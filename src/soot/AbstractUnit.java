/* Soot - a J*va Optimization Framework
 * Copyright (C) 1997-1999 Raja Vallee-Rai
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

/*
 * Modified by the Sable Research Group and others 1997-1999.  
 * See the 'credits' file distributed with Soot for the complete list of
 * contributors.  (Soot is distributed at http://www.sable.mcgill.ca/soot)
 */





package soot;

import soot.*;
import soot.util.*;
import java.util.*;

public abstract class AbstractUnit implements Unit
{
    static Map allMapToUnnamed = Collections.unmodifiableMap(new AllMapTo("<unnamed>"));
    
    /**
     * The list of boxes is dynamically updated as the structure changes.
     * Note that they are returned in usual evaluation order.
     * (this is important for aggregation)
     */

    public abstract Object clone();
    public List getUseBoxes()
    {
        return emptyList;
    }

    /**
     * The list of boxes is dynamically updated as the structure changes.
     */

    public List getDefBoxes()
    {
        return emptyList;
    }


    /**
     * The list of boxes is dynamically updated as the structure changes.
     */

    public List getUnitBoxes()
    {
        return emptyList;
    }

    static final public List emptyList = Collections.unmodifiableList(new ArrayList());

    List boxesPointingToThis = new ArrayList();
    List valueBoxes = null;

    public List getBoxesPointingToThis()
    {
        return boxesPointingToThis;
    }

    public List getUseAndDefBoxes()
    {
        valueBoxes = new ArrayList();

        valueBoxes.addAll(getUseBoxes());
        valueBoxes.addAll(getDefBoxes());

        valueBoxes = Collections.unmodifiableList(valueBoxes);

        return valueBoxes;
    }

    public void apply(Switch sw)
    {
    }

    public String toBriefString()
    {
        return toString(true, allMapToUnnamed, "");
    }
    
    public String toBriefString(Map stmtToName)
    {
        return toString(true, stmtToName, "");
    }
    
    public String toBriefString(String indentation)
    {
        return toString(true, allMapToUnnamed, indentation);
    }
    
    public String toBriefString(Map stmtToName, String indentation)
    {
        return toString(true, stmtToName, indentation);
    }
    
    public String toString()
    {
        return toString(false, allMapToUnnamed, "");
    }
    
    public String toString(Map stmtToName)
    {
        return toString(false, stmtToName, "");
    }
    
    public String toString(String indentation)
    {
        return toString(false, allMapToUnnamed, indentation);
    }
    
    public String toString(Map stmtToName, String indentation)
    {
        return toString(false, stmtToName, indentation);
    }
    
    abstract protected String toString(boolean isBrief, Map stmtToName, String indentation);

    static class AllMapTo extends AbstractMap
    {
        Object dest;
        
        public AllMapTo(Object dest)
        {
            this.dest = dest;
        }
        
        public Object get(Object key)
        {
            return dest;
        }
        
        public Set entrySet()
        {
            throw new UnsupportedOperationException();
        }
    }

    

    public void redirectJumpsToThisTo(Unit newLocation)
    {
        List boxesPointing = this.getBoxesPointingToThis();

        Object[] boxes = boxesPointing.toArray();
        // important to change this to an array to have a static copy
        
        for(int i = 0; i < boxes.length; i++)
        {
            UnitBox box = (UnitBox) boxes[i];

            if(box.getUnit() != this)
                throw new RuntimeException("Something weird's happening");

            box.setUnit(newLocation);
        }

    }


    
}
