package MyTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/7 2:30
 */
public class Test {
    Deque<Character> outStack = new LinkedList<>();

    public void print() {
        System.out.println(this.outStack);
    }
    public static void main(String[] args) {
        Deque<Character> innerStack = new LinkedList<>();
        Test test = new Test();
        test.print();
        System.out.println(innerStack);
    }

}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
