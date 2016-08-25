package leetcode.rpncalc

import spock.lang.Specification

class SolutionTest extends Specification {
   Solution solution = new Solution()

   def "the number remaining on the stack at the end is the solution"() {
      expect:
      solution.evalRPN(["${singleNumber}"] as String[]) == singleNumber

      where:
      singleNumber << [
         5,
         10
      ]
   }

   def "no number passed in results in a 0 result"() {
      expect:
      solution.evalRPN([] as String[]) == 0
   }

   def "adds two numbers"() {
      expect:
      solution.evalRPN(input as String[]) == expectedOutput

      where:
      input           || expectedOutput
      ['3', '2', '+'] || 5
   }

   def "supports subtract"() {
      expect:
      solution.evalRPN(input as String[]) == expectedOutput

      where:
      input           || expectedOutput
      ['2', '3', '-'] || -1
   }

   def "supports multiplication"() {
      expect:
      solution.evalRPN(input as String[]) == expectedOutput

      where:
      input           || expectedOutput
      ['3', '2', '*'] || 6
   }

   def "supports division"() {
      expect:
      solution.evalRPN(input as String[]) == expectedOutput

      where:
      input           || expectedOutput
      ['6', '3', '/'] || 2
   }

   def "adds multiple times"() {
      expect:
      solution.evalRPN(input as String[]) == expectedOutput

      where:
      input                     || expectedOutput
      ['3', '2', '+', '8', '+'] || 13
   }
}
