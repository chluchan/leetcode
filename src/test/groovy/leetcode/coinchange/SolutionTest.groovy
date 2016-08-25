package leetcode.coinchange

import spock.lang.Specification

class SolutionTest extends Specification {
   def "given an amount and an array of coins, computes the min number of coins needed"() {
      given:
      Solution solution = new Solution();

      expect:
      solution.coinChange(coins as int[], amount) == minCoins

      where:
      coins                        | amount || minCoins
      []                           | 5      || -1
      []                           | 0      || 0
      [5]                          | 5      || 1
      [1, 3, 5]                    | 3      || 1
      [1, 3, 5]                    | 8      || 2
      [1, 3, 5]                    | 9      || 3
      [2, 3, 5]                    | 1      || -1
      [3, 8, 11]                   | 33     || 3
      [3, 8, 11]                   | 9      || 3
      [3, 8, 11]                   | 12     || 4
      [3, 8, 11]                   | 5      || -1
      [1, 2, 5]                    | 100    || 20
      [186, 419, 83, 408]          | 6249   || 20
      [270, 373, 487, 5, 62]       | 8121   || 21
      [227, 99, 328, 299, 42, 322] | 9847   || 31
      [271,5,343,254,112]          | 4853   || 17
   }
}
