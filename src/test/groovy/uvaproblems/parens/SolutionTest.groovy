package uvaproblems.parens

import spock.lang.Specification

class SolutionTest extends Specification {
   def "returns the longest well-formed param string"() {
      given:
      Solution solution = new Solution()

      expect:
      solution.longestValidParentheses(str) == result

      where:
      str     | result
      ''      | 0
      ')'     | 0
      '('     | 0
      '()'    | 2
      '())'   | 2
   }
}
