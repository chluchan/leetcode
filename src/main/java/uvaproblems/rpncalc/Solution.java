package uvaproblems.rpncalc;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation
public class Solution {
   public int evalRPN(String[] tokens) {
      if (tokens.length == 0) {
         return 0;
      }

      Stack<Integer> stack = new Stack<>();

      for (int i = 0; i < tokens.length; i++) {
         if (tokens[i].equals("+")) {
            stack.push(stack.pop() + stack.pop());
         }
         else if (tokens[i].equals("-")) {
            stack.push(- stack.pop() + stack.pop());
         }
         else if (tokens[i].equals("*")) {
            stack.push(stack.pop() * stack.pop());
         }
         else if (tokens[i].equals("/")) {
            Integer v1 = stack.pop();
            Integer v2 = stack.pop();
            stack.push(v2 / v1);
         }
         else {
            stack.push(Integer.valueOf(tokens[i]));
         }
      }

      return stack.pop();
   }
}
