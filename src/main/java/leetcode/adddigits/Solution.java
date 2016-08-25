package leetcode.adddigits;

// https://leetcode.com/problems/add-digits/
public class Solution {
   public int addDigits(int num) {
      int sumDigits = 0;
      for (; num > 9; num /= 10) {
         sumDigits += num % 10;
      }

      sumDigits += num;

      if (sumDigits > 9) {
         return addDigits(sumDigits);
      }

      return sumDigits;
   }
}
