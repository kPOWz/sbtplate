package dp

import org.scalatest._
import funsuite._
import org.scalatest.matchers.should.Matchers

import java.time.Instant

// https://www.scalatest.org/release_notes/3.2.0
// Note that we also slightly renamed some of the traits and classes when we moved them in 3.1.0.
// We prefixed “Any” to the names of the main style traits and classes whose test bodies have a result type of Any. For example,
// org.scalatest.FunSuite was renamed to org.scalatest.funsuite.AnyFunSuite in 3.1.0.
class HelloTest extends AnyFunSuite with Matchers {

  // Define tests with 'test', a test name string in parentheses,
  // and test body in curly braces
  test("An empty Set should have size 0") {
    assert(Set.empty.size == 0)
  }

  // To ignore a test, change 'test' to 'ignore'
  ignore("Invoking head on an empty Set should produce NoSuchElementException") {
    intercept[NoSuchElementException] {
      Set.empty.head
    }
  }

  // Define a pending test by using (pending) for the body
  test("An empty Set's isEmpty method should return false") (pending)

  // Tag a test by placing a tag object after the test name
  import tagobjects.Slow
  test("An empty Set's nonEmpty method should return true", Slow) {
    assert(!Set.empty.nonEmpty)
  }

  test("basic assert") {
    val (a, b, c, d) = (1, 2, 3, 4)

    assert(a == b || c >= d) // Error message: 1 did not equal 2, and 3 was not greater than or equal to 4

    assertResult(2) { c + d } // Error message: Expected 2, but got 7
  }

  test("basic matchers") {
    val result = "hai"
    result should have length 3

    Array(1, 2) should equal (Array(1, 2)) // Arrays are compared structurally,
    Array(1, 2) should be (Array(1, 2))    // by calling left.deep == right.deep
    Array(1, 2) should === (Array(1, 2))

    val greeting = "Hi"
    greeting should equal ("hi") // Both fail with error message: "[H]i" did not equal "[h]i"
    greeting should === ("hi")
  }

  test("Hello world"){
    val string = "Hello world"
    string should startWith ("Hello")               // starts with the given substring

    string should endWith ("world")                 // ends with the given substring

    string should include ("lo wor")                 // includes the given substring
  }

  test("App entry point") {
    val res =  Hello.executionStart
    val approximateExpected = Instant.now.toEpochMilli

    val s = Hello
    s shouldBe a [App]

    print("(Drift was: " + res + ":" + approximateExpected +")")
    res should === (approximateExpected +- 100)
  }

  test("the name is set correctly in constructor") {
    val p = new Person("Barney Rubble")
    assert(p.name == "Barney Rubble")
  }

  // test 2
  test("a Person's name can be changed") {
    val p = new Person("Chad Johnson")
    p.name = "Ochocinco"
    assert(p.name == "Ochocinco")
  }

}