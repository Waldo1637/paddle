<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" indent="no"/>
  <xsl:strip-space elements="*"/>

<!--*************************************************************************-->
<!--* ROOT TEMPLATE *********************************************************-->
<!--*************************************************************************-->

  <xsl:template match="/options">
/* Soot - a J*va Optimization Framework
 * Copyright (C) 2003 Ondrej Lhotak
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

/* THIS FILE IS AUTO-GENERATED FROM soot_options.xml. DO NOT MODIFY. */

package soot.options;
import java.util.*;

/** Soot command-line options parser.
 * @author Ondrej Lhotak
 */

public class Options extends OptionsBase {
    public Options( String[] argv ) {
        for( int i = argv.length; i > 0; i-- ) {
            pushOptions( argv[i-1] );
        }
    }
<xsl:apply-templates mode="constants" select="/options/section"/>

    public boolean parse() {
        while( hasMoreOptions() ) {
            String option = nextOption();
            if( option.charAt(0) != '-' ) {
                while(true) {
                    classes.add( option );
                    if( !hasMoreOptions() ) break;
                    option = nextOption();
                }
                return true;
            }
            while( option.charAt(0) == '-' ) {
                option = option.substring(1);
            }
            if( false );
<xsl:apply-templates mode="parse" select="/options/section"/>
            else {
                System.out.println( "Invalid option -"+option );
                return false;
            }
        }
        return true;
    }
<xsl:apply-templates mode="vars" select="/options/section"/>

    public String getUsage() {
        return ""
<xsl:apply-templates mode="usage" select="/options/section"/>
        ;
    }
}
  </xsl:template>

<!--*************************************************************************-->
<!--* PARSE TEMPLATES *******************************************************-->
<!--*************************************************************************-->

  <xsl:template mode="parse" match="section">
      <xsl:apply-templates mode="parse" select="boolean_option|multi_option|path_option|phase_option|string_option|macro_option"/>
  </xsl:template>

<!--* BOOLEAN_OPTION *******************************************************-->
  <xsl:template mode="parse" match="boolean_option">
            else if( false <!---->
    <xsl:for-each select="alias_name">
            || option.equals( "<xsl:value-of select="."/>" )<!---->
    </xsl:for-each>
            )
                <xsl:value-of select="java_name"/> = true;
  </xsl:template>

<!--* MULTI_OPTION *******************************************************-->
  <xsl:template mode="parse" match="multi_option">
            else if( false<!---->
    <xsl:for-each select="alias_name">
            || option.equals( "<xsl:value-of select="."/>" )<!---->
    </xsl:for-each>
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    <xsl:variable name="name" select="java_name"/>
                if( false );
    <xsl:for-each select="value">
                else if( false<!---->
      <xsl:for-each select="alias">
                || value.equals( "<xsl:value-of select="."/>" )<!---->
      </xsl:for-each>
                ) {
                    if( <xsl:copy-of select="$name"/> != 0
                    &#38;&#38; <xsl:copy-of select="$name"/> != <xsl:copy-of select="$name"/>_<xsl:value-of select="java_name"/> ) {
                        System.out.println( "Multiple values given for option "+option );
                        return false;
                    }
                    <xsl:copy-of select="$name"/> = <xsl:copy-of select="$name"/>_<xsl:value-of select="java_name"/>;
                }
    </xsl:for-each>
                else {
                    System.out.println( "Invalid value "+value+" given for option -"+option );
                    return false;
                }
           }
  </xsl:template>

<!--* PATH_OPTION *******************************************************-->
  <xsl:template mode="parse" match="path_option">
            else if( false<!---->
    <xsl:for-each select="alias_name">
            || option.equals( "<xsl:value-of select="."/>" )<!---->
    </xsl:for-each>
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    <xsl:variable name="name" select="java_name"/>
                if( <xsl:copy-of select="$name"/> == null )
                    <xsl:copy-of select="$name"/> = new LinkedList();

                <xsl:copy-of select="$name"/>.add( value );
            }
  </xsl:template>

<!--* PHASE_OPTION *******************************************************-->
  <xsl:template mode="parse" match="phase_option">
            else if( false<!---->
    <xsl:for-each select="alias_name">
            || option.equals( "<xsl:value-of select="."/>" )<!---->
    </xsl:for-each>
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No phase name given for option -"+option );
                    return false;
                }
                String phaseName = nextOption();
                if( !hasMoreOptions() ) {
                    System.out.println( "No phase option given for option -"+option+" "+phaseName );
                    return false;
                }
                String phaseOption = nextOption();
    <xsl:variable name="name" select="java_name"/>
                if( !setPhaseOption( phaseName, phaseOption ) )
                    return false;
            }
  </xsl:template>

<!--* STRING_OPTION *******************************************************-->
  <xsl:template mode="parse" match="string_option">
            else if( false<!---->
    <xsl:for-each select="alias_name">
            || option.equals( "<xsl:value-of select="."/>" )<!---->
    </xsl:for-each>
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    <xsl:variable name="name" select="java_name"/>
                if( <xsl:copy-of select="$name"/> == null )
                    <xsl:copy-of select="$name"/> = value;
                else {
                    System.out.println( "Duplicate values "+<xsl:copy-of select="$name"/>+" and "+value+" for option -"+option );
                    return false;
                }
            }
  </xsl:template>

<!--* MACRO_OPTION *******************************************************-->
  <xsl:template mode="parse" match="macro_option">
            else if( false<!---->
    <xsl:for-each select="alias_name">
            || option.equals( "<xsl:value-of select="."/>" )<!---->
    </xsl:for-each>
            ) {
                pushOptions( "<xsl:value-of select="expansion"/>" );
            }
  </xsl:template>

<!--*************************************************************************-->
<!--* VARS TEMPLATES ********************************************************-->
<!--*************************************************************************-->

  <xsl:template mode="vars" match="section">
      <xsl:apply-templates mode="vars" select="boolean_option|multi_option|path_option|phase_option|string_option|macro_option"/>
  </xsl:template>

<!--* BOOLEAN_OPTION *******************************************************-->
  <xsl:template mode="vars" match="boolean_option">
    public boolean <xsl:value-of select="java_name"/>() { return <xsl:value-of select="java_name"/>; }
    private boolean <xsl:value-of select="java_name"/> = false;<!---->
  </xsl:template>

<!--* MULTI_OPTION *******************************************************-->
  <xsl:template mode="vars" match="multi_option">
    public int <xsl:value-of select="java_name"/>() {<!---->
    <xsl:variable name="name" select="java_name"/><!---->
    <xsl:for-each select="value">
      <xsl:if test="default"><!---->
        if( <xsl:value-of select="$name"/> == 0 ) return <xsl:value-of select="$name"/>_<xsl:value-of select="java_name"/>;<!---->
      </xsl:if>
    </xsl:for-each>
        return <xsl:value-of select="java_name"/>; 
    }
    private int <xsl:value-of select="java_name"/> = 0;<!---->
  </xsl:template>

<!--* PATH_OPTION *******************************************************-->
  <xsl:template mode="vars" match="path_option">
    public List <xsl:value-of select="java_name"/>() { 
        if( <xsl:value-of select="java_name"/> == null )
            return java.util.Collections.EMPTY_LIST;
        else
            return <xsl:value-of select="java_name"/>;
    }
    private List <xsl:value-of select="java_name"/> = null;<!---->
  </xsl:template>

<!--* PHASE_OPTION *******************************************************-->
  <xsl:template mode="vars" match="phase_option">
  </xsl:template>

<!--* STRING_OPTION *******************************************************-->
  <xsl:template mode="vars" match="string_option">
    public String <xsl:value-of select="java_name"/>() { return <xsl:value-of select="java_name"/>; }
    private String <xsl:value-of select="java_name"/> = null;<!---->
  </xsl:template>

<!--* MACRO_OPTION *******************************************************-->
  <xsl:template mode="vars" match="macro_option">
  </xsl:template>

<!--*************************************************************************-->
<!--* CONSTANTS TEMPLATES ***************************************************-->
<!--*************************************************************************-->

  <xsl:template mode="constants" match="section">
      <xsl:apply-templates mode="constants" select="multi_option"/>
  </xsl:template>

<!--* MULTI_OPTION *******************************************************-->
  <xsl:template mode="constants" match="multi_option">
    <xsl:variable name="name" select="java_name"/>
    <xsl:for-each select="value">
    public static final int <xsl:copy-of select="$name"/>_<xsl:value-of select="java_name"/> = <xsl:number/>;<!---->
    </xsl:for-each>
  </xsl:template>

<!--*************************************************************************-->
<!--* USAGE TEMPLATES *******************************************************-->
<!--*************************************************************************-->

  <xsl:template mode="usage" match="section">
+"\n<xsl:value-of select="section_name"/>:\n"
      <xsl:apply-templates mode="usage" select="boolean_option|multi_option|path_option|phase_option|string_option|macro_option"/>
  </xsl:template>

<!--* BOOLEAN_OPTION *******************************************************-->
  <xsl:template mode="usage" match="boolean_option">
+padOpt("<xsl:for-each select="alias_name"> -<xsl:value-of select="."/></xsl:for-each>", "<xsl:value-of select="short_desc"/>" )<!---->
  </xsl:template>

<!--* MULTI_OPTION *******************************************************-->
  <xsl:template mode="usage" match="multi_option">
+padOpt("<xsl:for-each select="alias_name"> -<xsl:value-of select="."/> ARG</xsl:for-each>", "<xsl:value-of select="short_desc"/>" )<!---->
    <xsl:for-each select="value">
+padVal("<xsl:for-each select="alias"><xsl:value-of select="string(' ')"/><xsl:value-of select="."/></xsl:for-each>", "<xsl:value-of select="value_name"/>" )<!---->
      </xsl:for-each>
  </xsl:template>

<!--* PATH_OPTION *******************************************************-->
  <xsl:template mode="usage" match="path_option">
+padOpt("<xsl:for-each select="alias_name"> -<xsl:value-of select="."/> ARG</xsl:for-each>", "<xsl:value-of select="short_desc"/>" )<!---->
  </xsl:template>

<!--* PHASE_OPTION *******************************************************-->
  <xsl:template mode="usage" match="phase_option">
+padOpt("<xsl:for-each select="alias_name"> -<xsl:value-of select="."/> PHASE-NAME PHASE-OPTIONS</xsl:for-each>", "<xsl:value-of select="short_desc"/>" )<!---->
  </xsl:template>

<!--* STRING_OPTION *******************************************************-->
  <xsl:template mode="usage" match="string_option">
+padOpt("<xsl:for-each select="alias_name"> -<xsl:value-of select="."/> ARG</xsl:for-each>", "<xsl:value-of select="short_desc"/>" )<!---->
  </xsl:template>

<!--* MACRO_OPTION *******************************************************-->
  <xsl:template mode="usage" match="macro_option">
+padOpt("<xsl:for-each select="alias_name"> -<xsl:value-of select="."/></xsl:for-each>", "<xsl:value-of select="short_desc"/>" )<!---->
  </xsl:template>

</xsl:stylesheet>