package leetcode.longestconsecutive;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Solution2 {
   public int longestConsecutive(int[] nums) {
      TreeSet<Integer> treeSet = new TreeSet<>();

      HashSet<Integer> set = new HashSet();

      for(int num: nums) {
         set.add(num);
      }

      treeSet.addAll(set);

      Iterator i = treeSet.iterator();
      int previousNumber = -Integer.MAX_VALUE;
      int runningConsecCount = 1;
      int maxConsecCount = 1;

      while(i.hasNext()) {
         Integer currentNumber = (Integer)i.next();

         if(currentNumber == previousNumber + 1) {
            runningConsecCount ++;
         } else {
            runningConsecCount = 1;
         }

         if(maxConsecCount < runningConsecCount) {
            maxConsecCount = runningConsecCount;
         }

         previousNumber = currentNumber;
      }

      return maxConsecCount;
   }
}
