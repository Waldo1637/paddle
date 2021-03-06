/* Soot - a J*va Optimization Framework
 * Copyright (C) 2005 Ondrej Lhotak
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

package soot.jimple.paddle;
import soot.jimple.paddle.queue.*;
import java.util.*;
import soot.*;

/** Assigns a target context to virtual call edges depending on the source
 * context.
 * @author Ondrej Lhotak
 */
public class TradUniqKObjSensVirtualContextManager extends AbsVirtualContextManager
{ 
    TradUniqKObjSensVirtualContextManager( Rvarc_var_objc_obj_srcm_stmt_kind_tgtm in, Qsrcc_srcm_stmt_kind_tgtc_tgtm out, Qobjc_obj_varc_var thisOut, NodeFactory gnf, int k ) {
        super( in, out, thisOut, gnf );
        this.k = k;
    }
    private int k;
    public boolean update() {
        boolean change = false;
        for( Iterator tIt = in.iterator(); tIt.hasNext(); ) {
            final Rvarc_var_objc_obj_srcm_stmt_kind_tgtm.Tuple t = (Rvarc_var_objc_obj_srcm_stmt_kind_tgtm.Tuple) tIt.next();
            ContextString cs = (ContextString) t.varc();
            if( cs == null ) cs = new ContextString(k);
            ContextString newCs = cs;
foundit:
            {
                for( int i = 0; i < k; i++ ) {
                    if( cs.get(i) == t.obj() ) break foundit;
                }
                newCs = cs.push(t.obj());
            }
            out.add( t.varc(),
                    t.srcm(),
                    t.stmt(),
                    t.kind(),
                    newCs,
                    t.tgtm() );
            if( thisOut != null ) {
                thisOut.add( t.objc(), t.obj(), newCs,
                        (VarNode) new MethodNodeFactory(t.tgtm(), gnf).caseThis() );
            }
            change = true;
        }
        return change;
    }
}
