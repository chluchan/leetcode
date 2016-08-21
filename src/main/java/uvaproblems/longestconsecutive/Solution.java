package uvaproblems.longestconsecutive;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.empty;

// https://leetcode.com/problems/longest-consecutive-sequence
public class Solution {
   static class Streak {
      int min;
      int max;
      Optional<Streak> join = empty();

      Streak(int num) {
         min = num;
         max = num;
      }

      int length() {
         return max - min + join.map(Streak::length).orElse(1);
      }
   }

   public int longestConsecutive(int[] nums) {
      if (nums.length == 0) {
         return 0;
      }

      Map<Integer, Streak> streaks = new HashMap<>();
      HashSet<Streak> viableMaxes = new HashSet<>();
      for (int num : nums) {
         if (streaks.containsKey(num)) {
            continue;
         }

         Streak lowStreak = streaks.get(num - 1);
         Streak highStreak = streaks.get(num + 1);

         if (lowStreak != null) {
            lowStreak.max = num;
            streaks.put(num, lowStreak);
         }

         if (highStreak != null) {
            highStreak.min = num;
            streaks.put(num, highStreak);
         }

         if (lowStreak == null && highStreak == null) {
            Streak newStreak = new Streak(num);
            viableMaxes.add(newStreak);
            streaks.put(num, newStreak);
         }

         if (lowStreak != null && highStreak != null) {
            lowStreak.join = Optional.of(highStreak);
            viableMaxes.remove(highStreak);
         }
      }

      Streak max = new Streak(0);
      for (Streak streak : viableMaxes) {
         if (streak.length() > max.length()) {
            max = streak;
         }
      }

      return max.length();
   }
}
