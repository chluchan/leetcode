package uvaproblems.treeequal;

// https://leetcode.com/problems/same-tree/
public class Solution {
   public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      public TreeNode(int x) {
         val = x;
      }

      public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }

   public boolean isSameTree(TreeNode t1, TreeNode t2) {
      if (t1 != null && t2 == null || t1 == null && t2 != null) {
         return false;
      }

      if (t1 == null && t2 == null) {
         return true;
      }

      return (t1.val == t2.val) && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
   }
}
