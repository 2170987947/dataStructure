package MyTree.Traversal;

import MyTree.TreeShowMethods.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/8 13:02
 */
public class LevelOrderTraversal {
    public Deque<TreeNode> queue = new LinkedList<>();
    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print("层序遍历: ");
        this.queue.add(root);
        while (!this.queue.isEmpty()) {
            TreeNode node = this.queue.remove();
            System.out.print(node.val);
            if (node.left != null) {
                this.queue.add(node.left);
            }
            if (node.right != null) {
                this.queue.add(node.right);
            }
        }
    }
}
