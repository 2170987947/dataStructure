package MyTree.TreeShowMethods;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/8 13:13
 */
class TreeNode1 {
      int val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1() {}
      TreeNode1(int val) { this.val = val; }
      TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
