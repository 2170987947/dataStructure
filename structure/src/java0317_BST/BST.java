package java0317_BST;

import java.util.Stack;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/15 21:02
 */
public class BST {
    TreeNode head = null;
    TreeNode tail = null;


    // 二叉搜索树的中序遍历是有序的
    // 1. 遍历二叉搜索树
    public void inOrder(TreeNode root) {
        if (root == null) {
            return ;
        }
        inOrder(root.left);
        add(root);
        inOrder(root.right);
    }
    public void add(TreeNode node) {
        if (tail == null) {
            head = tail = node;
        } else {
            tail.right = node;
            node.left = tail;
            tail = tail.right;
        }
    }
    public TreeNode inOrder2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode head = new TreeNode('0');
        TreeNode tail = head;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            tail.right = cur;
            cur.left = tail;
            tail = cur;
            cur = cur.right;
        }
        return head.right;
    }
    // 2. 插入
    public TreeNode insert(TreeNode root, char val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        int result = 0;
        while (cur != null) {
            result = cmp(root.val, val);
            if (result < 0) {
                pre = cur;
                cur = cur.left;
            } else if (result > 0) {
                pre = cur;
                cur = cur.right;
            } else {
                // 插入失败
                return root;
            }
        }
        if (result < 0) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }
        return root;
    }

    private int cmp(char val, char val1) {
        return val1 - val;
    }

    // 3. 删除
    public void remove(TreeNode root) {

    }
    // 4. 查找
    public TreeNode find(TreeNode root) {
        return null;
    }
}
