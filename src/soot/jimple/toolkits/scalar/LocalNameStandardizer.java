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






package soot.jimple.toolkits.scalar;

import soot.*;
import soot.jimple.toolkits.typing.*;
import soot.util.*;
import java.util.*;

public class LocalNameStandardizer extends BodyTransformer
{
    private static LocalNameStandardizer instance = new LocalNameStandardizer();
    private LocalNameStandardizer() {}

    public static LocalNameStandardizer v() { return instance; }

    /* supported option: only-stack-names */
    protected void internalTransform(Body body, String phaseName, Map options)
    {
        boolean onlyStackName = options.containsKey("only-stack-names") &&
            options.get("only-stack-names").equals("true");

        // Change the names to the standard forms now.
        {
            int objectCount = 0;
            int intCount = 0;
            int longCount = 0;
            int floatCount = 0;
            int doubleCount = 0;
            int addressCount = 0;
            int errorCount = 0;
            int nullCount = 0;

            Iterator localIt = body.getLocals().iterator();

            while(localIt.hasNext())
            {
                Local l = (Local) localIt.next();
                String prefix = "";
                
                if(l.getName().startsWith("$"))
                    prefix = "$";
                else 
                {
                    if (onlyStackName)
                        continue;
                }
                    
                if(l.getType().equals(IntType.v()))
                    l.setName(prefix + "i" + intCount++);
                else if(l.getType().equals(LongType.v()))
                    l.setName(prefix + "l" + longCount++);
                else if(l.getType().equals(DoubleType.v()))
                    l.setName(prefix + "d" + doubleCount++);
                else if(l.getType().equals(FloatType.v()))
                    l.setName(prefix + "f" + floatCount++);
                else if(l.getType().equals(StmtAddressType.v()))
                    l.setName(prefix + "a" + addressCount++);
                else if(l.getType().equals(ErroneousType.v()) ||
                    l.getType().equals(UnknownType.v()))
                {
                    l.setName(prefix + "e" + errorCount++);
                }
                else if(l.getType().equals(NullType.v()))
                    l.setName(prefix + "n" + nullCount++);
                else
                    l.setName(prefix + "r" + objectCount++);
            }
        }
    }
}


