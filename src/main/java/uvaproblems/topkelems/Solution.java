package uvaproblems.topkelems;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

// https://leetcode.com/problems/top-k-frequent-elements
public class Solution {
   static class NumCount implements Comparable<NumCount> {
      int num;
      int count;

      public NumCount(int num, int count) {
         this.num = num;
         this.count = count;
      }

      public int getNum() {
         return num;
      }

      @Override
      public int compareTo(NumCount nc) {
         int countDiff = nc.count - count;
         if (countDiff == 0) {
            return num - nc.num;
         }
         return countDiff;
      }
   }

   public List<Integer> topKFrequent(int[] nums, int k) {
      if (nums.length == 0 || k == 0) {
         return emptyList();
      }

      Map<Integer, NumCount> mapItOut = countWords(nums);

      return getTopKWords(k, mapItOut).stream()
                                      .map(NumCount::getNum)
                                      .collect(toList());
   }

   private Map<Integer, NumCount> countWords(int[] nums) {
      return IntStream.of(nums).boxed()
                  .collect(toMap(num -> num, num -> new NumCount(num, 1), (v1, v2) -> {
                     v1.count += v2.count;
                     return v1;
                  }));
   }

   private TreeSet<NumCount> getTopKWords(int k, Map<Integer, NumCount> mapItOut) {
      TreeSet<NumCount> treeSet = new TreeSet<>();
      for (NumCount entry : mapItOut.values()) {
         if (treeSet.size() >= k) {
            NumCount lowest = treeSet.last();
            if (entry.count > lowest.count) {
               treeSet.add(entry);
               treeSet.remove(lowest);
            }
         }
         else {
            treeSet.add(entry);
         }
      }
      return treeSet;
   }
}
