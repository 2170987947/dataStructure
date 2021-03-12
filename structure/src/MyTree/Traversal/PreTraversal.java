package MyTree.Traversal;

import MyTree.TreeShowMethods.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/6 1:09
 */
public class PreTraversal {
    Deque<TreeNode> stack = new LinkedList<>();

    public void preTraversal1(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print("先序遍历(非递归): ");
        this.stack.push(root);
        while (!this.stack.isEmpty()) {
            TreeNode node = this.stack.pop();
            System.out.print(node.val);
            if (node.right != null) {
                this.stack.push(node.right);
            }
            if (node.left != null) {
                this.stack.push(node.left);
            }
        }
        System.out.println();
    }
}
