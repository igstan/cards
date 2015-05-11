package cards
package test

class MainTest extends FunSuite with Matchers {
  val log = logger("MainTest")

  test("tests setup") {
    log.info("Logging infrastructure is working.")
    true should be(true)
  }
}
