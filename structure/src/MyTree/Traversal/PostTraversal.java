package MyTree.Traversal;

import MyTree.TreeShowMethods.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/6 2:20
 */
public class PostTraversal {
    public void postTraversal1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        System.out.print("后序遍历: ");
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            System.out.print(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            // 倒置
        }
    }
}
