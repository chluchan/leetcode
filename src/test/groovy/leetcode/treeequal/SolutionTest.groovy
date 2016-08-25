package leetcode.treeequal

import spock.lang.Specification
import leetcode.treeequal.Solution.TreeNode

class SolutionTest extends Specification {
   Solution solution = new Solution()

   def "determines if two trees are structurely equal"() {
      expect:
      solution.isSameTree(tree1, tree2) == areEqual

      where:
      tree1               | tree2             || areEqual
      null                | null              || true
      new TreeNode(1)     | null              || false
      null                | new TreeNode(1)   || false
      new TreeNode(1)     | new TreeNode(1)   || true
      new TreeNode(2)     | new TreeNode(1)   || false
      tn(1, tn(1), null)  | tn(1)             || false
      tn(1, tn(1), tn(2)) | tn(1, tn(1), tn(3)) || false
      tn(1, tn(1, tn(3), null), tn(2)) | tn(1, tn(1, tn(3), null), tn(2)) || true
      tn(1, tn(1, tn(3), tn(1)), tn(2)) | tn(1, tn(1, tn(3), null), tn(2)) || false
   }

   private TreeNode tn(value) {
      return new TreeNode(value)
   }

   private TreeNode tn(value, left, right) {
      return new TreeNode(value, left, right)
   }
}
