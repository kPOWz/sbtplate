package dp

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.funspec._
import org.scalatest.matchers.should.Matchers


// https://www.scalatest.org/release_notes/3.2.0
// Note that we also slightly renamed some of the traits and classes when we moved them in 3.1.0.
// We prefixed “Any” to the names of the main style traits and classes whose test bodies have a result type of Any. For example,
// org.scalatest.FunSuite was renamed to org.scalatest.funsuite.AnyFunSuite in 3.1.0.
class BddHelloTest extends AnyFunSpec with Matchers with TypeCheckedTripleEquals {
  describe("Hello::assertions") {

    // Note: testing impl detail, would not compose or test this way IRL
    it("should set name via constructor") {
      val p = new Person("Barney Rubble")
      assert(p.name == "Barney Rubble")
    }

    // Note: testing impl detail, would not compose or test this way IRL
    it("should allow a Person's name to be changed") {
      val p = new Person("Chad Johnson")
      p.name = "Ochocinco"
      assert(p.name == "Ochocinco")
    }

    it("should not allow a Case Class Thing's name to be changed") {
      val t = new Thing(name = "KpowZ")
      assertDoesNotCompile("p.name = \"Ochocinco\"")
    }

    it("should handle really large integers") (pending)

    it("should do wonderful things with Scalactic due to `TypeCheckedTripleEquals` Trait") {
      Some(3) should === (Some(3))
      assertDoesNotCompile("Some(3) should === (3)")

      Some(2) === Some(2)
      assertDoesNotCompile("Some(2) === 2")
    }

  }
}