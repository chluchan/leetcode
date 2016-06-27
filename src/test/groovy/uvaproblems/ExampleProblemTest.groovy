package uvaproblems

import spock.lang.Specification

import static uvaproblems.ExampleProblem.doubleIt

class ExampleProblemTest extends Specification {
   def "doubles a number"() {
      expect:
      doubleIt(5) == 10
   }
}
