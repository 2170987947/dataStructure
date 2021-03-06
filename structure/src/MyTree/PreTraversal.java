package MyTree;

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
        this.stack.push(root);
        while (!this.stack.isEmpty()) {
            TreeNode node = this.stack.pop();
            System.out.print(node.var);
            if (node.right != null) {
                this.stack.push(node.right);
            }
            if (node.left != null) {
                this.stack.push(node.left);
            }
        }

    }
}
