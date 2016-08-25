package leetcode.rainwater;

// https://leetcode.com/problems/trapping-rain-water/
public class Solution {
   public int trap(int[] heights) {
      if (heights.length == 0) {
         return 0;
      }

      int[] boundingHeightsLeft = computeBoundedHeightsFromLeft(heights);
      int[] boundingHeightsRight = computeBoundingHeightsFromRight(heights);
      return computeGroundWater(heights, boundingHeightsLeft, boundingHeightsRight);
   }

   private int computeGroundWater(int[] heights, int[] boundingHeightsLeft, int[] boundingHeightsRight) {
      int water = 0;
      for (int i=0; i < heights.length; i++) {
         int waterHeight = Math.min(boundingHeightsLeft[i], boundingHeightsRight[i]);
         water += waterHeight - heights[i];
      }
      return water;
   }

   private int[] computeBoundingHeightsFromRight(int[] heights) {
      int[] boundingHeightsRight = new int[heights.length];
      boundingHeightsRight[heights.length - 1] = heights[heights.length - 1];
      for (int i=heights.length-2; i >= 0; i--) {
         boundingHeightsRight[i] = Math.max(boundingHeightsRight[i+1], heights[i]);
      }
      return boundingHeightsRight;
   }

   private int[] computeBoundedHeightsFromLeft(int[] heights) {
      int[] boundingHeightsLeft = new int[heights.length];
      boundingHeightsLeft[0] = heights[0];
      for (int i=1; i < heights.length; i++) {
         boundingHeightsLeft[i] = Math.max(boundingHeightsLeft[i-1], heights[i]);
      }
      return boundingHeightsLeft;
   }
}
