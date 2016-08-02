package uvaproblems.fibonaccifreeze

import spock.lang.Specification

class MainTest extends Specification {
   static Map<Integer, Long> fibs = Main.generateFibs(5000)

   def "values should adhere to fn=fn-1 + fn-2"() {
      expect:
      fibs[0] == 0
      fibs[1] == 1
      fibs[2] == 1
      fibs[7] == 13
      fibs[11] == 89
   }

   def "values should not overflow"() {
      expect:
      fibs.entrySet().find { it.value < 0 } == null
   }
}
