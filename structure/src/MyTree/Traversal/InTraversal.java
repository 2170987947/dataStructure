package MyTree.Traversal;

import MyTree.TreeShowMethods.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/6 1:58
 */
public class InTraversal {
    public void inTraversal1(TreeNode root) {
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return;
        }
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.var);
                cur = cur.right;
            }
        }
    }
}
