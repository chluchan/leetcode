package leetcode.medianstream;

import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFinder {
   boolean isEmpty = true;
   int middle = 0;
   PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> a - b);
   PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);

   public void addNum(int num) {
      if (isEmpty) {
         middle = num;
         isEmpty = false;
         return;
      }

      if (num < middle) {
         leftInsert(num);
      } else {
         rightInsert(num);
      }
   }

   private void rightInsert(int num) {
      if (right.size() <= left.size()) {
         right.add(num);
      } else {
         left.add(middle);
         if (right.peek() < num) {
            middle = right.remove();
            right.add(num);
         } else {
            middle = num;
         }
      }
   }

   private void leftInsert(int num) {
      if (left.size() <= right.size()) {
         left.add(num);
      } else {
         right.add(middle);
         if (left.peek() > num) {
            middle = left.remove();
            left.add(num);
         } else {
            middle = num;
         }
      }
   }

   public double findMedian() {
      if (right.size() == left.size()) {
         return (double) middle;
      } else if (right.size() > left.size()) {
         return ((double) middle + (double) right.peek()) / 2;
      } else {
         return ((double) middle + (double) left.peek()) / 2;
      }
   }
}
