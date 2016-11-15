import org.scalacheck.Properties
import org.scalacheck.Prop
import org.scalacheck.Prop.BooleanOperators
import org.scalacheck.Gen.{oneOf, listOf, alphaStr, numChar}

object TestSerialize extends Properties("ScalaCheck") {
  property("working") = Prop {
    true
  }
}
