package leetcode.longestconsecutive

import spock.lang.Specification

class LongestConsecutiveTest extends Specification {
   def "Given an unsorted array of integers, find the length of the longest consecutive elements sequence."() {
      Solution solution = new Solution()

      expect:
      solution.longestConsecutive(nums as int[]) == result

      where:
      nums                                | result
      []                                  | 0
      [4]                                 | 1
      [2, 4]                              | 1
      [100, 2, 3]                         | 2
      [100, 3, 2]                         | 2
      [100, 3, 2, 4]                      | 3
      [100, 3, 2, 1]                      | 3
      [100, 3, 1, 2]                      | 3
      [100, 3, 1, 2, 8, 7, 5, 4, 6]       | 8
      [1,2,0,1]                           | 3
   }
}
