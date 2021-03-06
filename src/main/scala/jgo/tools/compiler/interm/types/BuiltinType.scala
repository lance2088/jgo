package jgo.tools.compiler
package interm
package types

/**
 * A fundamental type -- one that cannot be seen as the composition
 * of other types.  It is a forgone conclusion that such a type is
 * an under-type.
 * 
 * NB:  These types are ''not'' the types declared in the universe block.
 * The types declared in universe scope are ''aliases to these types''.
 * 
 * To avoid confusion between what the spec calls "built-in types" (namely
 * those declared in the universe block) and what I call "built-in types"
 * (types that extend `BuiltinType`), I may rename this trait to
 * `FundamentalType`.  Low priority.
 */
sealed trait BuiltinType extends UnderType with ConstableType

sealed trait PrimitiveType extends BuiltinType {
  val semantics = Primitive
}

sealed trait AddableType  extends BuiltinType
sealed trait NumericType  extends PrimitiveType with AddableType
sealed trait ComplexType  extends NumericType
sealed trait RealType     extends NumericType
sealed trait FloatingType extends RealType
sealed trait IntegralType extends RealType
sealed trait UnsignedType extends IntegralType

case object BoolType extends PrimitiveType  { val name = "bool" }

case object Uint8  extends UnsignedType { val name = "byte/uint8" }
case object Uint16 extends UnsignedType { val name = "uint16" }
case object Uint32 extends UnsignedType { val name = "uint32" }
case object Uint64 extends UnsignedType { val name = "uint64" }

case object Int8  extends IntegralType { val name = "int8" }
case object Int16 extends IntegralType { val name = "int16" }
case object Int32 extends IntegralType { val name = "int32" }
case object Int64 extends IntegralType { val name = "int64" }

case object Float32 extends FloatingType { val name = "float32" }
case object Float64 extends FloatingType { val name = "float64" }

case object Complex64  extends ComplexType { val name = "complex64" } //or BuiltinType?
case object Complex128 extends ComplexType { val name = "complex128" }

sealed trait BuiltinRefType extends UnderType with ConstableType {
  val semantics = Reference
}

case object StringType extends BuiltinRefType //or Primitive...?
                          with AddableType
                          with NilableType  //Spec says not nilable...

/**
 * A placeholder type for built-in funcs (those declared in the universe block),
 * which do not have actual types.
 */
case object BuiltinFuncType extends BuiltinRefType

case object TopType     extends BuiltinRefType
case object NilType     extends BuiltinRefType
case object BottomType  extends BuiltinRefType
case object UnitType    extends BuiltinRefType
