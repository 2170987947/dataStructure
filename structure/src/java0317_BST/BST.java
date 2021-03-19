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
            return;
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
        TreeNode head2 = new TreeNode('0');
        TreeNode tail2 = head2;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();

            // 插入到链表中
            tail2.right = cur;
            cur.left = tail2;
            tail2 = cur;

            cur = cur.right;
        }
        return head2.right;
    }
    // 2. 二叉搜索树的插入
    public TreeNode insert(TreeNode root, char val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        int cmp = 0;
        while (cur != null) {
            cmp = compare(val, cur.val);
            if (cmp < 0) {
                pre = cur;
                cur = cur.left;
            } else if (cmp > 0) {
                pre = cur;
                cur = cur.right;
            } else {
                // 插入失败
                return root;
            }
        }
        if (cmp < 0) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }
        return root;
    }

    private int compare(char val, char val1) {
        return val - val1;
    }

    // 3. 二叉搜索树的删除
    public TreeNode remove(TreeNode root, char c) {
        if (root == null) {
            return null;
        } else if (root.val == c) {
            // 要删除的结点是根节点
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null && root.right != null) {

            } else {
                TreeNode cur = root.left;
                TreeNode pre = null;
                while (cur.right != null) {
                    pre = cur;
                    cur = cur.right;
                }
                root.val = cur.val;
                pre.right = cur.left;
            }
        } else {

        }
        return null;
    }
    // 4. 查找
    public TreeNode find(TreeNode root, char c) {
        TreeNode cur = root;
        int cmp = 0;
        while (cur != null) {
            cmp = compare(c, cur.val);
            if (cmp < 0) {
                cur = cur.left;
            } else if (cmp > 0) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }
}
