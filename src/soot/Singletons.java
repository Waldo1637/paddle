/* Soot - a J*va Optimization Framework
 * Copyright (C) 2003 Ondrej Lhotak
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
import soot.baf.*;
import soot.baf.internal.*;
import soot.baf.toolkits.base.*;
import soot.coffi.*;
import soot.dava.*;
import soot.dava.internal.asg.*;
import soot.dava.internal.AST.*;
import soot.dava.internal.javaRep.*;
import soot.dava.internal.SET.*;
import soot.dava.toolkits.base.AST.*;
import soot.dava.toolkits.base.DavaMonitor.*;
import soot.dava.toolkits.base.finders.*;
import soot.dava.toolkits.base.misc.*;
import soot.grimp.*;
import soot.grimp.internal.*;
import soot.grimp.toolkits.base.*;
import soot.gui.*;
import soot.jimple.*;
import soot.jimple.internal.*;
import soot.jimple.parser.*;
import soot.jimple.parser.analysis.*;
import soot.jimple.parser.lexer.*;
import soot.jimple.parser.node.*;
import soot.jimple.parser.parser.*;
import soot.jimple.spark.*;
import soot.jimple.spark.builder.*;
import soot.jimple.spark.callgraph.*;
import soot.jimple.spark.internal.*;
import soot.jimple.spark.pag.*;
import soot.jimple.spark.sets.*;
import soot.jimple.spark.solver.*;
import soot.jimple.toolkits.annotation.arraycheck.*;
import soot.jimple.toolkits.annotation.nullcheck.*;
import soot.jimple.toolkits.annotation.profiling.*;
import soot.jimple.toolkits.annotation.tags.*;
import soot.jimple.toolkits.base.*;
import soot.jimple.toolkits.graph.*;
import soot.jimple.toolkits.invoke.*;
import soot.jimple.toolkits.pointer.*;
import soot.jimple.toolkits.pointer.nativemethods.*;
import soot.jimple.toolkits.pointer.representations.*;
import soot.jimple.toolkits.pointer.util.*;
import soot.jimple.toolkits.scalar.*;
import soot.jimple.toolkits.scalar.pre.*;
import soot.jimple.toolkits.typing.*;
import soot.jimple.toolkits.typing.integer.*;
import soot.options.*;
import soot.tagkit.*;
import soot.toolkits.graph.*;
import soot.toolkits.scalar.*;
import soot.util.*;
import soot.util.queue.*;

/** A class to group together all the global variables in Soot. */
public class Singletons {
    public final class Global {
        private Global() {}
    }
    private Global g = new Global();

    private AbruptEdgeFinder instanceAbruptEdgeFinder;
    public AbruptEdgeFinder AbruptEdgeFinder() {
        if( instanceAbruptEdgeFinder == null ) instanceAbruptEdgeFinder = new AbruptEdgeFinder( g );
        return instanceAbruptEdgeFinder;
    }

    private Aggregator instanceAggregator;
    public Aggregator Aggregator() {
        if( instanceAggregator == null ) instanceAggregator = new Aggregator( g );
        return instanceAggregator;
    }

    private ArrayBoundsChecker instanceArrayBoundsChecker;
    public ArrayBoundsChecker ArrayBoundsChecker() {
        if( instanceArrayBoundsChecker == null ) instanceArrayBoundsChecker = new ArrayBoundsChecker( g );
        return instanceArrayBoundsChecker;
    }

    private ArrayElement instanceArrayElement;
    public ArrayElement ArrayElement() {
        if( instanceArrayElement == null ) instanceArrayElement = new ArrayElement( g );
        return instanceArrayElement;
    }

    private ArrayNullTagAggregator instanceArrayNullTagAggregator;
    public ArrayNullTagAggregator ArrayNullTagAggregator() {
        if( instanceArrayNullTagAggregator == null ) instanceArrayNullTagAggregator = new ArrayNullTagAggregator( g );
        return instanceArrayNullTagAggregator;
    }

    private ASTWalker instanceASTWalker;
    public ASTWalker ASTWalker() {
        if( instanceASTWalker == null ) instanceASTWalker = new ASTWalker( g );
        return instanceASTWalker;
    }

    private BafInputRep instanceBafInputRep;
    public BafInputRep BafInputRep() {
        if( instanceBafInputRep == null ) instanceBafInputRep = new BafInputRep( g );
        return instanceBafInputRep;
    }

    private Baf instanceBaf;
    public Baf Baf() {
        if( instanceBaf == null ) instanceBaf = new Baf( g );
        return instanceBaf;
    }

    private BooleanType instanceBooleanType;
    public BooleanType BooleanType() {
        if( instanceBooleanType == null ) instanceBooleanType = new BooleanType( g );
        return instanceBooleanType;
    }

    private BusyCodeMotion instanceBusyCodeMotion;
    public BusyCodeMotion BusyCodeMotion() {
        if( instanceBusyCodeMotion == null ) instanceBusyCodeMotion = new BusyCodeMotion( g );
        return instanceBusyCodeMotion;
    }

    private ByteType instanceByteType;
    public ByteType ByteType() {
        if( instanceByteType == null ) instanceByteType = new ByteType( g );
        return instanceByteType;
    }

    private CastCheckEliminatorDumper instanceCastCheckEliminatorDumper;
    public CastCheckEliminatorDumper CastCheckEliminatorDumper() {
        if( instanceCastCheckEliminatorDumper == null ) instanceCastCheckEliminatorDumper = new CastCheckEliminatorDumper( g );
        return instanceCastCheckEliminatorDumper;
    }

    private CharType instanceCharType;
    public CharType CharType() {
        if( instanceCharType == null ) instanceCharType = new CharType( g );
        return instanceCharType;
    }

    private ClassFieldAnalysis instanceClassFieldAnalysis;
    public ClassFieldAnalysis ClassFieldAnalysis() {
        if( instanceClassFieldAnalysis == null ) instanceClassFieldAnalysis = new ClassFieldAnalysis( g );
        return instanceClassFieldAnalysis;
    }

    private ClassInputRep instanceClassInputRep;
    public ClassInputRep ClassInputRep() {
        if( instanceClassInputRep == null ) instanceClassInputRep = new ClassInputRep( g );
        return instanceClassInputRep;
    }

    private CommonSubexpressionEliminator instanceCommonSubexpressionEliminator;
    public CommonSubexpressionEliminator CommonSubexpressionEliminator() {
        if( instanceCommonSubexpressionEliminator == null ) instanceCommonSubexpressionEliminator = new CommonSubexpressionEliminator( g );
        return instanceCommonSubexpressionEliminator;
    }

    private ConditionalBranchFolder instanceConditionalBranchFolder;
    public ConditionalBranchFolder ConditionalBranchFolder() {
        if( instanceConditionalBranchFolder == null ) instanceConditionalBranchFolder = new ConditionalBranchFolder( g );
        return instanceConditionalBranchFolder;
    }

    private ConstantPropagatorAndFolder instanceConstantPropagatorAndFolder;
    public ConstantPropagatorAndFolder ConstantPropagatorAndFolder() {
        if( instanceConstantPropagatorAndFolder == null ) instanceConstantPropagatorAndFolder = new ConstantPropagatorAndFolder( g );
        return instanceConstantPropagatorAndFolder;
    }

    private ConstructorFolder instanceConstructorFolder;
    public ConstructorFolder ConstructorFolder() {
        if( instanceConstructorFolder == null ) instanceConstructorFolder = new ConstructorFolder( g );
        return instanceConstructorFolder;
    }

    private CopyPropagator instanceCopyPropagator;
    public CopyPropagator CopyPropagator() {
        if( instanceCopyPropagator == null ) instanceCopyPropagator = new CopyPropagator( g );
        return instanceCopyPropagator;
    }

    private CriticalEdgeRemover instanceCriticalEdgeRemover;
    public CriticalEdgeRemover CriticalEdgeRemover() {
        if( instanceCriticalEdgeRemover == null ) instanceCriticalEdgeRemover = new CriticalEdgeRemover( g );
        return instanceCriticalEdgeRemover;
    }

    private CycleFinder instanceCycleFinder;
    public CycleFinder CycleFinder() {
        if( instanceCycleFinder == null ) instanceCycleFinder = new CycleFinder( g );
        return instanceCycleFinder;
    }

    private Dava instanceDava;
    public Dava Dava() {
        if( instanceDava == null ) instanceDava = new Dava( g );
        return instanceDava;
    }

    private DavaLocalPrinter instanceDavaLocalPrinter;
    public DavaLocalPrinter DavaLocalPrinter() {
        if( instanceDavaLocalPrinter == null ) instanceDavaLocalPrinter = new DavaLocalPrinter( g );
        return instanceDavaLocalPrinter;
    }

    private DavaStmtPrinter instanceDavaStmtPrinter;
    public DavaStmtPrinter DavaStmtPrinter() {
        if( instanceDavaStmtPrinter == null ) instanceDavaStmtPrinter = new DavaStmtPrinter( g );
        return instanceDavaStmtPrinter;
    }

    private DeadAssignmentEliminator instanceDeadAssignmentEliminator;
    public DeadAssignmentEliminator DeadAssignmentEliminator() {
        if( instanceDeadAssignmentEliminator == null ) instanceDeadAssignmentEliminator = new DeadAssignmentEliminator( g );
        return instanceDeadAssignmentEliminator;
    }

    private DefaultLocalPrinter instanceDefaultLocalPrinter;
    public DefaultLocalPrinter DefaultLocalPrinter() {
        if( instanceDefaultLocalPrinter == null ) instanceDefaultLocalPrinter = new DefaultLocalPrinter( g );
        return instanceDefaultLocalPrinter;
    }

    private DefaultStmtPrinter instanceDefaultStmtPrinter;
    public DefaultStmtPrinter DefaultStmtPrinter() {
        if( instanceDefaultStmtPrinter == null ) instanceDefaultStmtPrinter = new DefaultStmtPrinter( g );
        return instanceDefaultStmtPrinter;
    }

    private DependenceTagAggregator instanceDependenceTagAggregator;
    public DependenceTagAggregator DependenceTagAggregator() {
        if( instanceDependenceTagAggregator == null ) instanceDependenceTagAggregator = new DependenceTagAggregator( g );
        return instanceDependenceTagAggregator;
    }

    private Double2ndHalfType instanceDouble2ndHalfType;
    public Double2ndHalfType Double2ndHalfType() {
        if( instanceDouble2ndHalfType == null ) instanceDouble2ndHalfType = new Double2ndHalfType( g );
        return instanceDouble2ndHalfType;
    }

    private DoubleType instanceDoubleType;
    public DoubleType DoubleType() {
        if( instanceDoubleType == null ) instanceDoubleType = new DoubleType( g );
        return instanceDoubleType;
    }

    private DoubleWordType instanceDoubleWordType;
    public DoubleWordType DoubleWordType() {
        if( instanceDoubleWordType == null ) instanceDoubleWordType = new DoubleWordType( g );
        return instanceDoubleWordType;
    }

    private DumbPointerAnalysis instanceDumbPointerAnalysis;
    public DumbPointerAnalysis DumbPointerAnalysis() {
        if( instanceDumbPointerAnalysis == null ) instanceDumbPointerAnalysis = new DumbPointerAnalysis( g );
        return instanceDumbPointerAnalysis;
    }

    private EmptyPointsToSet instanceEmptyPointsToSet;
    public EmptyPointsToSet EmptyPointsToSet() {
        if( instanceEmptyPointsToSet == null ) instanceEmptyPointsToSet = new EmptyPointsToSet( g );
        return instanceEmptyPointsToSet;
    }

    private ErroneousType instanceErroneousType;
    public ErroneousType ErroneousType() {
        if( instanceErroneousType == null ) instanceErroneousType = new ErroneousType( g );
        return instanceErroneousType;
    }

    private ExceptionFinder instanceExceptionFinder;
    public ExceptionFinder ExceptionFinder() {
        if( instanceExceptionFinder == null ) instanceExceptionFinder = new ExceptionFinder( g );
        return instanceExceptionFinder;
    }

    private FieldRWTagger instanceFieldRWTagger;
    public FieldRWTagger FieldRWTagger() {
        if( instanceFieldRWTagger == null ) instanceFieldRWTagger = new FieldRWTagger( g );
        return instanceFieldRWTagger;
    }

    private FloatType instanceFloatType;
    public FloatType FloatType() {
        if( instanceFloatType == null ) instanceFloatType = new FloatType( g );
        return instanceFloatType;
    }

    private FullObjectSet instanceFullObjectSet;
    public FullObjectSet FullObjectSet() {
        if( instanceFullObjectSet == null ) instanceFullObjectSet = new FullObjectSet( g );
        return instanceFullObjectSet;
    }

    private Grimp instanceGrimp;
    public Grimp Grimp() {
        if( instanceGrimp == null ) instanceGrimp = new Grimp( g );
        return instanceGrimp;
    }

    private IfFinder instanceIfFinder;
    public IfFinder IfFinder() {
        if( instanceIfFinder == null ) instanceIfFinder = new IfFinder( g );
        return instanceIfFinder;
    }

    private ImplicitMethodInvocation instanceImplicitMethodInvocation;
    public ImplicitMethodInvocation ImplicitMethodInvocation() {
        if( instanceImplicitMethodInvocation == null ) instanceImplicitMethodInvocation = new ImplicitMethodInvocation( g );
        return instanceImplicitMethodInvocation;
    }

    private IntType instanceIntType;
    public IntType IntType() {
        if( instanceIntType == null ) instanceIntType = new IntType( g );
        return instanceIntType;
    }

    private InvokeGraphBuilder instanceInvokeGraphBuilder;
    public InvokeGraphBuilder InvokeGraphBuilder() {
        if( instanceInvokeGraphBuilder == null ) instanceInvokeGraphBuilder = new InvokeGraphBuilder( g );
        return instanceInvokeGraphBuilder;
    }

    private JavaIoFileDescriptorNative instanceJavaIoFileDescriptorNative;
    public JavaIoFileDescriptorNative JavaIoFileDescriptorNative() {
        if( instanceJavaIoFileDescriptorNative == null ) instanceJavaIoFileDescriptorNative = new JavaIoFileDescriptorNative( g );
        return instanceJavaIoFileDescriptorNative;
    }

    private JavaIoFileInputStreamNative instanceJavaIoFileInputStreamNative;
    public JavaIoFileInputStreamNative JavaIoFileInputStreamNative() {
        if( instanceJavaIoFileInputStreamNative == null ) instanceJavaIoFileInputStreamNative = new JavaIoFileInputStreamNative( g );
        return instanceJavaIoFileInputStreamNative;
    }

    private JavaIoFileOutputStreamNative instanceJavaIoFileOutputStreamNative;
    public JavaIoFileOutputStreamNative JavaIoFileOutputStreamNative() {
        if( instanceJavaIoFileOutputStreamNative == null ) instanceJavaIoFileOutputStreamNative = new JavaIoFileOutputStreamNative( g );
        return instanceJavaIoFileOutputStreamNative;
    }

    private JavaIoFileSystemNative instanceJavaIoFileSystemNative;
    public JavaIoFileSystemNative JavaIoFileSystemNative() {
        if( instanceJavaIoFileSystemNative == null ) instanceJavaIoFileSystemNative = new JavaIoFileSystemNative( g );
        return instanceJavaIoFileSystemNative;
    }

    private JavaIoObjectInputStreamNative instanceJavaIoObjectInputStreamNative;
    public JavaIoObjectInputStreamNative JavaIoObjectInputStreamNative() {
        if( instanceJavaIoObjectInputStreamNative == null ) instanceJavaIoObjectInputStreamNative = new JavaIoObjectInputStreamNative( g );
        return instanceJavaIoObjectInputStreamNative;
    }

    private JavaIoObjectOutputStreamNative instanceJavaIoObjectOutputStreamNative;
    public JavaIoObjectOutputStreamNative JavaIoObjectOutputStreamNative() {
        if( instanceJavaIoObjectOutputStreamNative == null ) instanceJavaIoObjectOutputStreamNative = new JavaIoObjectOutputStreamNative( g );
        return instanceJavaIoObjectOutputStreamNative;
    }

    private JavaIoObjectStreamClassNative instanceJavaIoObjectStreamClassNative;
    public JavaIoObjectStreamClassNative JavaIoObjectStreamClassNative() {
        if( instanceJavaIoObjectStreamClassNative == null ) instanceJavaIoObjectStreamClassNative = new JavaIoObjectStreamClassNative( g );
        return instanceJavaIoObjectStreamClassNative;
    }

    private JavaLangClassLoaderNative instanceJavaLangClassLoaderNative;
    public JavaLangClassLoaderNative JavaLangClassLoaderNative() {
        if( instanceJavaLangClassLoaderNative == null ) instanceJavaLangClassLoaderNative = new JavaLangClassLoaderNative( g );
        return instanceJavaLangClassLoaderNative;
    }

    private JavaLangClassLoaderNativeLibraryNative instanceJavaLangClassLoaderNativeLibraryNative;
    public JavaLangClassLoaderNativeLibraryNative JavaLangClassLoaderNativeLibraryNative() {
        if( instanceJavaLangClassLoaderNativeLibraryNative == null ) instanceJavaLangClassLoaderNativeLibraryNative = new JavaLangClassLoaderNativeLibraryNative( g );
        return instanceJavaLangClassLoaderNativeLibraryNative;
    }

    private JavaLangClassNative instanceJavaLangClassNative;
    public JavaLangClassNative JavaLangClassNative() {
        if( instanceJavaLangClassNative == null ) instanceJavaLangClassNative = new JavaLangClassNative( g );
        return instanceJavaLangClassNative;
    }

    private JavaLangDoubleNative instanceJavaLangDoubleNative;
    public JavaLangDoubleNative JavaLangDoubleNative() {
        if( instanceJavaLangDoubleNative == null ) instanceJavaLangDoubleNative = new JavaLangDoubleNative( g );
        return instanceJavaLangDoubleNative;
    }

    private JavaLangFloatNative instanceJavaLangFloatNative;
    public JavaLangFloatNative JavaLangFloatNative() {
        if( instanceJavaLangFloatNative == null ) instanceJavaLangFloatNative = new JavaLangFloatNative( g );
        return instanceJavaLangFloatNative;
    }

    private JavaLangObjectNative instanceJavaLangObjectNative;
    public JavaLangObjectNative JavaLangObjectNative() {
        if( instanceJavaLangObjectNative == null ) instanceJavaLangObjectNative = new JavaLangObjectNative( g );
        return instanceJavaLangObjectNative;
    }

    private JavaLangPackageNative instanceJavaLangPackageNative;
    public JavaLangPackageNative JavaLangPackageNative() {
        if( instanceJavaLangPackageNative == null ) instanceJavaLangPackageNative = new JavaLangPackageNative( g );
        return instanceJavaLangPackageNative;
    }

    private JavaLangReflectArrayNative instanceJavaLangReflectArrayNative;
    public JavaLangReflectArrayNative JavaLangReflectArrayNative() {
        if( instanceJavaLangReflectArrayNative == null ) instanceJavaLangReflectArrayNative = new JavaLangReflectArrayNative( g );
        return instanceJavaLangReflectArrayNative;
    }

    private JavaLangReflectConstructorNative instanceJavaLangReflectConstructorNative;
    public JavaLangReflectConstructorNative JavaLangReflectConstructorNative() {
        if( instanceJavaLangReflectConstructorNative == null ) instanceJavaLangReflectConstructorNative = new JavaLangReflectConstructorNative( g );
        return instanceJavaLangReflectConstructorNative;
    }

    private JavaLangReflectFieldNative instanceJavaLangReflectFieldNative;
    public JavaLangReflectFieldNative JavaLangReflectFieldNative() {
        if( instanceJavaLangReflectFieldNative == null ) instanceJavaLangReflectFieldNative = new JavaLangReflectFieldNative( g );
        return instanceJavaLangReflectFieldNative;
    }

    private JavaLangReflectMethodNative instanceJavaLangReflectMethodNative;
    public JavaLangReflectMethodNative JavaLangReflectMethodNative() {
        if( instanceJavaLangReflectMethodNative == null ) instanceJavaLangReflectMethodNative = new JavaLangReflectMethodNative( g );
        return instanceJavaLangReflectMethodNative;
    }

    private JavaLangReflectProxyNative instanceJavaLangReflectProxyNative;
    public JavaLangReflectProxyNative JavaLangReflectProxyNative() {
        if( instanceJavaLangReflectProxyNative == null ) instanceJavaLangReflectProxyNative = new JavaLangReflectProxyNative( g );
        return instanceJavaLangReflectProxyNative;
    }

    private JavaLangRuntimeNative instanceJavaLangRuntimeNative;
    public JavaLangRuntimeNative JavaLangRuntimeNative() {
        if( instanceJavaLangRuntimeNative == null ) instanceJavaLangRuntimeNative = new JavaLangRuntimeNative( g );
        return instanceJavaLangRuntimeNative;
    }

    private JavaLangSecurityManagerNative instanceJavaLangSecurityManagerNative;
    public JavaLangSecurityManagerNative JavaLangSecurityManagerNative() {
        if( instanceJavaLangSecurityManagerNative == null ) instanceJavaLangSecurityManagerNative = new JavaLangSecurityManagerNative( g );
        return instanceJavaLangSecurityManagerNative;
    }

    private JavaLangShutdownNative instanceJavaLangShutdownNative;
    public JavaLangShutdownNative JavaLangShutdownNative() {
        if( instanceJavaLangShutdownNative == null ) instanceJavaLangShutdownNative = new JavaLangShutdownNative( g );
        return instanceJavaLangShutdownNative;
    }

    private JavaLangStrictMathNative instanceJavaLangStrictMathNative;
    public JavaLangStrictMathNative JavaLangStrictMathNative() {
        if( instanceJavaLangStrictMathNative == null ) instanceJavaLangStrictMathNative = new JavaLangStrictMathNative( g );
        return instanceJavaLangStrictMathNative;
    }

    private JavaLangStringNative instanceJavaLangStringNative;
    public JavaLangStringNative JavaLangStringNative() {
        if( instanceJavaLangStringNative == null ) instanceJavaLangStringNative = new JavaLangStringNative( g );
        return instanceJavaLangStringNative;
    }

    private JavaLangSystemNative instanceJavaLangSystemNative;
    public JavaLangSystemNative JavaLangSystemNative() {
        if( instanceJavaLangSystemNative == null ) instanceJavaLangSystemNative = new JavaLangSystemNative( g );
        return instanceJavaLangSystemNative;
    }

    private JavaLangThreadNative instanceJavaLangThreadNative;
    public JavaLangThreadNative JavaLangThreadNative() {
        if( instanceJavaLangThreadNative == null ) instanceJavaLangThreadNative = new JavaLangThreadNative( g );
        return instanceJavaLangThreadNative;
    }

    private JavaLangThrowableNative instanceJavaLangThrowableNative;
    public JavaLangThrowableNative JavaLangThrowableNative() {
        if( instanceJavaLangThrowableNative == null ) instanceJavaLangThrowableNative = new JavaLangThrowableNative( g );
        return instanceJavaLangThrowableNative;
    }

    private JavaNetInetAddressImplNative instanceJavaNetInetAddressImplNative;
    public JavaNetInetAddressImplNative JavaNetInetAddressImplNative() {
        if( instanceJavaNetInetAddressImplNative == null ) instanceJavaNetInetAddressImplNative = new JavaNetInetAddressImplNative( g );
        return instanceJavaNetInetAddressImplNative;
    }

    private JavaNetInetAddressNative instanceJavaNetInetAddressNative;
    public JavaNetInetAddressNative JavaNetInetAddressNative() {
        if( instanceJavaNetInetAddressNative == null ) instanceJavaNetInetAddressNative = new JavaNetInetAddressNative( g );
        return instanceJavaNetInetAddressNative;
    }

    private JavaSecurityAccessControllerNative instanceJavaSecurityAccessControllerNative;
    public JavaSecurityAccessControllerNative JavaSecurityAccessControllerNative() {
        if( instanceJavaSecurityAccessControllerNative == null ) instanceJavaSecurityAccessControllerNative = new JavaSecurityAccessControllerNative( g );
        return instanceJavaSecurityAccessControllerNative;
    }

    private JavaUtilJarJarFileNative instanceJavaUtilJarJarFileNative;
    public JavaUtilJarJarFileNative JavaUtilJarJarFileNative() {
        if( instanceJavaUtilJarJarFileNative == null ) instanceJavaUtilJarJarFileNative = new JavaUtilJarJarFileNative( g );
        return instanceJavaUtilJarJarFileNative;
    }

    private JavaUtilResourceBundleNative instanceJavaUtilResourceBundleNative;
    public JavaUtilResourceBundleNative JavaUtilResourceBundleNative() {
        if( instanceJavaUtilResourceBundleNative == null ) instanceJavaUtilResourceBundleNative = new JavaUtilResourceBundleNative( g );
        return instanceJavaUtilResourceBundleNative;
    }

    private JavaUtilTimeZoneNative instanceJavaUtilTimeZoneNative;
    public JavaUtilTimeZoneNative JavaUtilTimeZoneNative() {
        if( instanceJavaUtilTimeZoneNative == null ) instanceJavaUtilTimeZoneNative = new JavaUtilTimeZoneNative( g );
        return instanceJavaUtilTimeZoneNative;
    }

    private JavaUtilZipCRC32Native instanceJavaUtilZipCRC32Native;
    public JavaUtilZipCRC32Native JavaUtilZipCRC32Native() {
        if( instanceJavaUtilZipCRC32Native == null ) instanceJavaUtilZipCRC32Native = new JavaUtilZipCRC32Native( g );
        return instanceJavaUtilZipCRC32Native;
    }

    private JavaUtilZipInflaterNative instanceJavaUtilZipInflaterNative;
    public JavaUtilZipInflaterNative JavaUtilZipInflaterNative() {
        if( instanceJavaUtilZipInflaterNative == null ) instanceJavaUtilZipInflaterNative = new JavaUtilZipInflaterNative( g );
        return instanceJavaUtilZipInflaterNative;
    }

    private JavaUtilZipZipEntryNative instanceJavaUtilZipZipEntryNative;
    public JavaUtilZipZipEntryNative JavaUtilZipZipEntryNative() {
        if( instanceJavaUtilZipZipEntryNative == null ) instanceJavaUtilZipZipEntryNative = new JavaUtilZipZipEntryNative( g );
        return instanceJavaUtilZipZipEntryNative;
    }

    private JavaUtilZipZipFileNative instanceJavaUtilZipZipFileNative;
    public JavaUtilZipZipFileNative JavaUtilZipZipFileNative() {
        if( instanceJavaUtilZipZipFileNative == null ) instanceJavaUtilZipZipFileNative = new JavaUtilZipZipFileNative( g );
        return instanceJavaUtilZipZipFileNative;
    }

    private JimpleInputRep instanceJimpleInputRep;
    public JimpleInputRep JimpleInputRep() {
        if( instanceJimpleInputRep == null ) instanceJimpleInputRep = new JimpleInputRep( g );
        return instanceJimpleInputRep;
    }

    private Jimple instanceJimple;
    public Jimple Jimple() {
        if( instanceJimple == null ) instanceJimple = new Jimple( g );
        return instanceJimple;
    }

    private LabeledBlockFinder instanceLabeledBlockFinder;
    public LabeledBlockFinder LabeledBlockFinder() {
        if( instanceLabeledBlockFinder == null ) instanceLabeledBlockFinder = new LabeledBlockFinder( g );
        return instanceLabeledBlockFinder;
    }

    private LazyCodeMotion instanceLazyCodeMotion;
    public LazyCodeMotion LazyCodeMotion() {
        if( instanceLazyCodeMotion == null ) instanceLazyCodeMotion = new LazyCodeMotion( g );
        return instanceLazyCodeMotion;
    }

    private LineNumberTagAggregator instanceLineNumberTagAggregator;
    public LineNumberTagAggregator LineNumberTagAggregator() {
        if( instanceLineNumberTagAggregator == null ) instanceLineNumberTagAggregator = new LineNumberTagAggregator( g );
        return instanceLineNumberTagAggregator;
    }

    private LoadStoreOptimizer instanceLoadStoreOptimizer;
    public LoadStoreOptimizer LoadStoreOptimizer() {
        if( instanceLoadStoreOptimizer == null ) instanceLoadStoreOptimizer = new LoadStoreOptimizer( g );
        return instanceLoadStoreOptimizer;
    }

    private LocalNameStandardizer instanceLocalNameStandardizer;
    public LocalNameStandardizer LocalNameStandardizer() {
        if( instanceLocalNameStandardizer == null ) instanceLocalNameStandardizer = new LocalNameStandardizer( g );
        return instanceLocalNameStandardizer;
    }

    private LocalPacker instanceLocalPacker;
    public LocalPacker LocalPacker() {
        if( instanceLocalPacker == null ) instanceLocalPacker = new LocalPacker( g );
        return instanceLocalPacker;
    }

    private LocalSplitter instanceLocalSplitter;
    public LocalSplitter LocalSplitter() {
        if( instanceLocalSplitter == null ) instanceLocalSplitter = new LocalSplitter( g );
        return instanceLocalSplitter;
    }

    private Long2ndHalfType instanceLong2ndHalfType;
    public Long2ndHalfType Long2ndHalfType() {
        if( instanceLong2ndHalfType == null ) instanceLong2ndHalfType = new Long2ndHalfType( g );
        return instanceLong2ndHalfType;
    }

    private LongType instanceLongType;
    public LongType LongType() {
        if( instanceLongType == null ) instanceLongType = new LongType( g );
        return instanceLongType;
    }

    private MonitorConverter instanceMonitorConverter;
    public MonitorConverter MonitorConverter() {
        if( instanceMonitorConverter == null ) instanceMonitorConverter = new MonitorConverter( g );
        return instanceMonitorConverter;
    }

    private NopEliminator instanceNopEliminator;
    public NopEliminator NopEliminator() {
        if( instanceNopEliminator == null ) instanceNopEliminator = new NopEliminator( g );
        return instanceNopEliminator;
    }

    private NullConstant instanceNullConstant;
    public NullConstant NullConstant() {
        if( instanceNullConstant == null ) instanceNullConstant = new NullConstant( g );
        return instanceNullConstant;
    }

    private NullPointerChecker instanceNullPointerChecker;
    public NullPointerChecker NullPointerChecker() {
        if( instanceNullPointerChecker == null ) instanceNullPointerChecker = new NullPointerChecker( g );
        return instanceNullPointerChecker;
    }

    private NullType instanceNullType;
    public NullType NullType() {
        if( instanceNullType == null ) instanceNullType = new NullType( g );
        return instanceNullType;
    }

    private PackageNamer instancePackageNamer;
    public PackageNamer PackageNamer() {
        if( instancePackageNamer == null ) instancePackageNamer = new PackageNamer( g );
        return instancePackageNamer;
    }

    private PackManager instancePackManager;
    public PackManager PackManager() {
        if( instancePackManager == null ) instancePackManager = new PackManager( g );
        return instancePackManager;
    }

    private PeepholeOptimizer instancePeepholeOptimizer;
    public PeepholeOptimizer PeepholeOptimizer() {
        if( instancePeepholeOptimizer == null ) instancePeepholeOptimizer = new PeepholeOptimizer( g );
        return instancePeepholeOptimizer;
    }

    private ProfilingGenerator instanceProfilingGenerator;
    public ProfilingGenerator ProfilingGenerator() {
        if( instanceProfilingGenerator == null ) instanceProfilingGenerator = new ProfilingGenerator( g );
        return instanceProfilingGenerator;
    }

    private RectangularArrayFinder instanceRectangularArrayFinder;
    public RectangularArrayFinder RectangularArrayFinder() {
        if( instanceRectangularArrayFinder == null ) instanceRectangularArrayFinder = new RectangularArrayFinder( g );
        return instanceRectangularArrayFinder;
    }

    private RefType instanceRefType;
    public RefType RefType() {
        if( instanceRefType == null ) instanceRefType = new RefType( g );
        return instanceRefType;
    }

    private Scene instanceScene;
    public Scene Scene() {
        if( instanceScene == null ) instanceScene = new Scene( g );
        return instanceScene;
    }

    private SequenceFinder instanceSequenceFinder;
    public SequenceFinder SequenceFinder() {
        if( instanceSequenceFinder == null ) instanceSequenceFinder = new SequenceFinder( g );
        return instanceSequenceFinder;
    }

    private ShortType instanceShortType;
    public ShortType ShortType() {
        if( instanceShortType == null ) instanceShortType = new ShortType( g );
        return instanceShortType;
    }

    private SideEffectTagger instanceSideEffectTagger;
    public SideEffectTagger SideEffectTagger() {
        if( instanceSideEffectTagger == null ) instanceSideEffectTagger = new SideEffectTagger( g );
        return instanceSideEffectTagger;
    }

    private SparkTransformer instanceSparkTransformer;
    public SparkTransformer SparkTransformer() {
        if( instanceSparkTransformer == null ) instanceSparkTransformer = new SparkTransformer( g );
        return instanceSparkTransformer;
    }

    private StaticInliner instanceStaticInliner;
    public StaticInliner StaticInliner() {
        if( instanceStaticInliner == null ) instanceStaticInliner = new StaticInliner( g );
        return instanceStaticInliner;
    }

    private StaticMethodBinder instanceStaticMethodBinder;
    public StaticMethodBinder StaticMethodBinder() {
        if( instanceStaticMethodBinder == null ) instanceStaticMethodBinder = new StaticMethodBinder( g );
        return instanceStaticMethodBinder;
    }

    private StmtAddressType instanceStmtAddressType;
    public StmtAddressType StmtAddressType() {
        if( instanceStmtAddressType == null ) instanceStmtAddressType = new StmtAddressType( g );
        return instanceStmtAddressType;
    }

    private SunMiscSignalHandlerNative instanceSunMiscSignalHandlerNative;
    public SunMiscSignalHandlerNative SunMiscSignalHandlerNative() {
        if( instanceSunMiscSignalHandlerNative == null ) instanceSunMiscSignalHandlerNative = new SunMiscSignalHandlerNative( g );
        return instanceSunMiscSignalHandlerNative;
    }

    private SunMiscSignalNative instanceSunMiscSignalNative;
    public SunMiscSignalNative SunMiscSignalNative() {
        if( instanceSunMiscSignalNative == null ) instanceSunMiscSignalNative = new SunMiscSignalNative( g );
        return instanceSunMiscSignalNative;
    }

    private SwitchFinder instanceSwitchFinder;
    public SwitchFinder SwitchFinder() {
        if( instanceSwitchFinder == null ) instanceSwitchFinder = new SwitchFinder( g );
        return instanceSwitchFinder;
    }

    private SynchronizedBlockFinder instanceSynchronizedBlockFinder;
    public SynchronizedBlockFinder SynchronizedBlockFinder() {
        if( instanceSynchronizedBlockFinder == null ) instanceSynchronizedBlockFinder = new SynchronizedBlockFinder( g );
        return instanceSynchronizedBlockFinder;
    }

    private ThrowFinder instanceThrowFinder;
    public ThrowFinder ThrowFinder() {
        if( instanceThrowFinder == null ) instanceThrowFinder = new ThrowFinder( g );
        return instanceThrowFinder;
    }

    private ThrowNullConverter instanceThrowNullConverter;
    public ThrowNullConverter ThrowNullConverter() {
        if( instanceThrowNullConverter == null ) instanceThrowNullConverter = new ThrowNullConverter( g );
        return instanceThrowNullConverter;
    }

    private Timers instanceTimers;
    public Timers Timers() {
        if( instanceTimers == null ) instanceTimers = new Timers( g );
        return instanceTimers;
    }

    private TryContentsFinder instanceTryContentsFinder;
    public TryContentsFinder TryContentsFinder() {
        if( instanceTryContentsFinder == null ) instanceTryContentsFinder = new TryContentsFinder( g );
        return instanceTryContentsFinder;
    }

    private TypeAssigner instanceTypeAssigner;
    public TypeAssigner TypeAssigner() {
        if( instanceTypeAssigner == null ) instanceTypeAssigner = new TypeAssigner( g );
        return instanceTypeAssigner;
    }

    private UnconditionalBranchFolder instanceUnconditionalBranchFolder;
    public UnconditionalBranchFolder UnconditionalBranchFolder() {
        if( instanceUnconditionalBranchFolder == null ) instanceUnconditionalBranchFolder = new UnconditionalBranchFolder( g );
        return instanceUnconditionalBranchFolder;
    }

    private UnknownType instanceUnknownType;
    public UnknownType UnknownType() {
        if( instanceUnknownType == null ) instanceUnknownType = new UnknownType( g );
        return instanceUnknownType;
    }

    private UnreachableCodeEliminator instanceUnreachableCodeEliminator;
    public UnreachableCodeEliminator UnreachableCodeEliminator() {
        if( instanceUnreachableCodeEliminator == null ) instanceUnreachableCodeEliminator = new UnreachableCodeEliminator( g );
        return instanceUnreachableCodeEliminator;
    }

    private UnusedLocalEliminator instanceUnusedLocalEliminator;
    public UnusedLocalEliminator UnusedLocalEliminator() {
        if( instanceUnusedLocalEliminator == null ) instanceUnusedLocalEliminator = new UnusedLocalEliminator( g );
        return instanceUnusedLocalEliminator;
    }

    private UnusuableType instanceUnusuableType;
    public UnusuableType UnusuableType() {
        if( instanceUnusuableType == null ) instanceUnusuableType = new UnusuableType( g );
        return instanceUnusuableType;
    }

    private UselessTryRemover instanceUselessTryRemover;
    public UselessTryRemover UselessTryRemover() {
        if( instanceUselessTryRemover == null ) instanceUselessTryRemover = new UselessTryRemover( g );
        return instanceUselessTryRemover;
    }

    private VoidType instanceVoidType;
    public VoidType VoidType() {
        if( instanceVoidType == null ) instanceVoidType = new VoidType( g );
        return instanceVoidType;
    }

    private VTATestingFramework instanceVTATestingFramework;
    public VTATestingFramework VTATestingFramework() {
        if( instanceVTATestingFramework == null ) instanceVTATestingFramework = new VTATestingFramework( g );
        return instanceVTATestingFramework;
    }

    private WordType instanceWordType;
    public WordType WordType() {
        if( instanceWordType == null ) instanceWordType = new WordType( g );
        return instanceWordType;
    }

    private XMLStmtPrinter instanceXMLStmtPrinter;
    public XMLStmtPrinter XMLStmtPrinter() {
        if( instanceXMLStmtPrinter == null ) instanceXMLStmtPrinter = new XMLStmtPrinter( g );
        return instanceXMLStmtPrinter;
    }

}