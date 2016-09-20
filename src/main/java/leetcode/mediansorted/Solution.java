package leetcode.mediansorted;

import java.util.List;
import java.util.stream.Stream;

import static java.lang.Math.abs;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.empty;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class Solution {
   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if (nums1.length == 1 && nums2.length == 1) {
         return ((double)nums1[0] + (double)nums2[0]) / 2.0;
      }

      List<Integer> medianValues = concat(medianValues(nums1, nums2, true), medianValues(nums2, nums1, false))
                                       .collect(toList());

      if (medianValues.size() == 1) {
         return medianValues.get(0);
      } else {
         return ((double)medianValues.get(0) + (double)medianValues.get(1)) / 2.0;
      }
   }

   private Stream<Integer> medianValues(int[] nums1, int[] nums2, boolean includeEqualityIn2) {
      if (nums1.length == 0) {
         return empty();
      }

      int startIndex = 0;
      int endIndex = nums1.length - 1;

      while(endIndex - startIndex > 1) {
         int midIndex = (startIndex + endIndex) / 2;
         int numberToTest = nums1[midIndex];
         int hypotheticalIndexInOtherArray = smallestIndexGreaterThanOrEqualToK(nums2, numberToTest, includeEqualityIn2);
         int numItemsLeft = midIndex + hypotheticalIndexInOtherArray;
         int numItemsRight = (nums1.length - midIndex - 1) + (nums2.length - hypotheticalIndexInOtherArray);

         if (numItemsLeft == numItemsRight) {
            return Stream.of(numberToTest);
         } else if (numItemsLeft < numItemsRight) {
            startIndex = midIndex;
         } else {
            endIndex = midIndex;
         }
      }

      return Stream.of(startIndex, endIndex).distinct()
                                            .filter(index -> isAMedianIndex(index, nums1, nums2, includeEqualityIn2))
                                            .map(index -> nums1[index]);
   }

   private boolean isAMedianIndex(int index, int[] thisArray, int[] otherArray, boolean includeEqualityIn2) {
      int hypotheticalIndexInOtherArray = smallestIndexGreaterThanOrEqualToK(otherArray, thisArray[index], includeEqualityIn2);
      int numItemsLeft = index + hypotheticalIndexInOtherArray;
      int numItemsRight = (thisArray.length - index - 1) + (otherArray.length - hypotheticalIndexInOtherArray);

      return abs(numItemsLeft - numItemsRight) <= 1;
   }

   private int smallestIndexGreaterThanOrEqualToK(int[] array, int k, boolean includeEquality) {
      if (array.length == 0) {
         return 0;
      }

      if (array[0] > k) {
         return 0;
      } else if (array[array.length - 1] < k) {
         return array.length;
      }

      int startIndex = 0;
      int endIndex = array.length - 1;

      while(endIndex - startIndex > 1) {
         int midIndex = (startIndex + endIndex) / 2;
         int numberToTest = array[midIndex];

         if (includeEquality && numberToTest == k) {
            return midIndex;
         } else if (numberToTest < k || (!includeEquality && numberToTest == k)) {
            startIndex = midIndex;
         } else {
            endIndex = midIndex;
         }
      }

      if (array[startIndex] > k) {
         return startIndex;
      } else {
         return endIndex;
      }
   }
}
