package leetcode.rainwater

import spock.lang.Specification

class SolutionTest extends Specification {
   Solution solution = new Solution()

   def "Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining."() {
      expect:
      solution.trap(heights as int[]) == water

      where:
      heights      | water
      []           | 0
      [1]          | 0
      [1, 2]       | 0
      [2, 1, 2]    | 1
      [6, 2, 1, 3] | 3
   }
}
