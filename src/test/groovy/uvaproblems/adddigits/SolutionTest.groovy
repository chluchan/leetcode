package uvaproblems.adddigits

import spock.lang.Specification

class SolutionTest extends Specification {
   def "repeatedly sums the digits"() {
      given:
      Solution solution = new Solution()

      expect:
      solution.addDigits(number) == expectedSum

      where:
      number | expectedSum
      0      | 0
      1      | 1
      5      | 5
      9      | 9
      21     | 3
      213    | 6
      1111   | 4
      38     | 2
   }
}
