package leetcode.topkelems

import spock.lang.Specification

class SolutionTest extends Specification {
   Solution solution = new Solution()

   def "Given a non-empty array of integers, return the k most frequent elements"() {
      expect:
      solution.topKFrequent(nums as int[], k) == result

      where:
      nums               | k || result
      []                 | 0 || []
      [5, 5, 4, 3]       | 1 || [5]
      [5, 5, 5, 4, 4, 3] | 2 || [5, 4]
      [1, 2]             | 2 || [1, 2]
   }
}
