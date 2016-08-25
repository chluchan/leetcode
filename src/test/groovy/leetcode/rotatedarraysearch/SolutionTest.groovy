package leetcode.rotatedarraysearch

import spock.lang.Specification

class SolutionTest extends Specification {
   Solution solution = new Solution()

   def "find an element in a sorted array that has been rotated on some pivot point"() {
      expect:
      solution.search(nums as int[], target) == index

      where:
      nums                            | target || index
      []                              | 5      || -1
      [2]                             | 5      || -1
      [2]                             | 2      || 0
      [2, 1]                          | 1      || 1
      [2, 1]                          | 2      || 0
      [4, 5, 6, 7, 8, 9, 1, 2, 3]     | 2      || 7
      [4, 5, 6, 7, 8, 9, 1, 2, 3]     | 5      || 1
      [4, 5, 6, 7, 8, 9, 1, 2, 3]     | 11     || -1
      [4, 5, 6, 7, 8, 9, 1, 2, 3]     | 0      || -1
      [1, 2, 3, 4, 5, 6, 7, 8, 9]     | 5      || 4
      [3, 4, 5, 6, 7, 8, 9, 1, 2, 3]  | 5      || 2
      [1, 3, 5]                       | 1      || 0
   }
}
