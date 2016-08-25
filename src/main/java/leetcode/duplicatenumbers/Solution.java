package leetcode.duplicatenumbers;

// https://leetcode.com/problems/find-the-duplicate-number/
public class Solution {
   public int findDuplicate(int[] nums) {
      if (nums.length <= 1) {
         return -1;
      }

      int n = nums.length - 1;

      return binarySearchForTheDuplicateNumber(nums, n);
   }

   private int binarySearchForTheDuplicateNumber(int[] nums, int n) {
      int start = 0;
      int end = n;
      while (end - start > 1) {
         int mid = (start + end) / 2;
         int numLessOrEqualToMid = 0;
         for (int num : nums) {
            if (num <= mid) {
               numLessOrEqualToMid++;
            }
         }

         if (numLessOrEqualToMid > mid) {
            end = mid;
         } else {
            start = mid;
         }
      }

      return end;
   }
}
