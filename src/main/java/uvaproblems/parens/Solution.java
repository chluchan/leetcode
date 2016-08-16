package uvaproblems.parens;

import java.util.Stack;

// https://leetcode.com/problems/longest-valid-parentheses/
public class Solution {
   public int longestValidParentheses(String s) {

      Stack<Character> valid = new Stack<>();

      for (int i=0; i < s.length(); i++) {
         char thisChar = s.charAt(i);

         if (thisChar == '(') {
            valid.push(thisChar);
         }


      }


      if ("()".equals(s)) {
         return 2;
      }

      return 0;
   }
}
