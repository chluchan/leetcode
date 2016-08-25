package leetcode.rotatedarraysearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class Solution {
   public int search(int[] nums, int target) {
      if (nums.length == 0) {
         return -1;
      }

      int pivot = findPivot(nums);

      return findNumber(nums, target, pivot);
   }

   private int findNumber(int[] nums, int target, int pivot) {
      int start = 0;
      int end = nums.length - 1;
      while (end - start > 1) {
         int mid = (start + end) / 2;
         int pivotedMin = getPivotedIndex(nums, pivot, mid);
         if (nums[pivotedMin] == target) {
            return pivotedMin;
         } else if (nums[pivotedMin] < target) {
            start = mid;
         } else {
            end = mid;
         }
      }

      int resultingStartIndex = getPivotedIndex(nums, pivot, start);
      int resultingEndIndex = getPivotedIndex(nums, pivot, end);

      if (nums[resultingStartIndex] == target)
         return resultingStartIndex;
      else if (nums[resultingEndIndex] == target)
         return resultingEndIndex;
      else
         return -1;
   }

   private int findPivot(int[] nums) {
      int start = 0;
      int end = nums.length - 1;
      while (end - start > 1) {
         int mid = (start + end) / 2;
         if (nums[mid] > nums[end]) {
            start = mid;
         } else {
            end = mid;
         }
      }

      if (start == end) {
         return end;
      } else if (nums[end] < nums[start]) {
         return end;
      } else {
         return 0;
      }
   }

   private int getPivotedIndex(int[] nums, int pivot, int index) {
      return (index + pivot) % nums.length;
   }
}
