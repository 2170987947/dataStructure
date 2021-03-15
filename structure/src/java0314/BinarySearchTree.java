package java0314;

import MyTree.TreeShowMethods.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/14 16:17
 */
// 二叉搜索树转换成双向排序链表
public class BinarySearchTree {
    TreeNode head = null;
    TreeNode tail = null;
    // 方法一:
    // 二叉搜索树中, 左子树的结点的值小于根节点的值, 右子树的节点的值大于跟的值
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        add(root);
        preOrder(root.right);
    }

    private void add(TreeNode node) {

        if (this.tail == null) {
            this.head = this.tail = node;
        } else {
            this.tail.right = node;
            node.left = this.tail;
            this.tail = node;
        }
    }
    // 方法二:
    public void BST(TreeNode root) {
        if (root == null) {
            return;
        }
        BST(root.left);
        if (this.head == null) {
            this.head = this.tail = root;
        } else {
            this.tail.right = root;
            root.left = this.tail;
            this.tail = root;
        }
        BST(root.right);
    }
    // 方法三
    public TreeNode BST2(TreeNode root) {
        TreeNode head = null;
        TreeNode tail = null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (tail == null) {
                head = tail = cur;
            } else {
                tail.right = cur;
                cur.left = tail;
                tail = cur;
            }
            cur = cur.right;
        }
        return head;
    }
}
