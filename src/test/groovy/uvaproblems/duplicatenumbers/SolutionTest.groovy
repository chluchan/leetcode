package uvaproblems.duplicatenumbers

import spock.lang.Specification

class SolutionTest extends Specification {
   Solution solution = new Solution()

   def "finds the duplicate number out of n+1 numbers between 1 and n"() {
      expect:
      solution.findDuplicate(numbers as int[]) == duplicate

      where:
      numbers                                | duplicate
      []                                     | -1
      [1]                                    | -1
      [1, 1]                                 | 1
      [2, 1, 2]                              | 2
      [1, 1, 2]                              | 1
      [1, 3, 5, 6, 8, 10, 9, 7, 6, 4, 2]     | 6
      [1, 3, 10, 9, 7, 6, 4, 2, 11, 5, 6, 8] | 6
      [1, 3, 10, 9, 7, 3, 4, 2, 11, 5, 3, 8] | 3
      [5, 5, 5, 5, 5, 5, 5, 5]               | 5
      [1, 1, 1, 1]                           | 1
      [4, 4, 4, 4, 4]                        | 4
   }
}
