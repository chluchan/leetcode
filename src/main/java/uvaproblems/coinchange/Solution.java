package uvaproblems.coinchange;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Integer.MAX_VALUE;
import static java.util.stream.Collectors.toList;

// https://leetcode.com/problems/coin-change/
public class Solution {
   public int coinChange(int[] coins, int amount) {
      List<Integer> sortedCoins = IntStream.of(coins).boxed().sorted((c1, c2) -> c2 - c1).collect(toList());
      return coinChange(sortedCoins, amount, 0);
   }

   private int coinChange(List<Integer> coins, int amount, int n) {
      if (amount == 0) {
         return 0;
      }

      int minPositiveCoins = MAX_VALUE;
      for (int i=n; i < coins.size(); i++) {
         int minUsingThisCoin = calcMinUsingThisCoin(coins, amount, i, coins.get(i), minPositiveCoins);
         minPositiveCoins = nonNegativeMin(minUsingThisCoin, minPositiveCoins);
      }

      return minPositiveCoins == MAX_VALUE ? -1 : minPositiveCoins;
   }

   private int calcMinUsingThisCoin(List<Integer> coins, int amount, int i, int coin, int currentMin) {
      int minUsingThisCoin = -1;
      for (int factor = Math.min(amount / coin, currentMin - 1); factor > 0; factor--) {
         int minAfterThisCoin = coinChange(coins, amount - (coin * factor), i + 1);
         if (minAfterThisCoin != -1) {
            minUsingThisCoin = nonNegativeMin(minUsingThisCoin, factor + minAfterThisCoin);
         }
      }

      return minUsingThisCoin;
   }

   private int nonNegativeMin(int a, int b) {
      if (a == -1) {
         return b;
      }

      if (b == -1) {
         return a;
      }

      return Math.min(a, b);
   }
}
