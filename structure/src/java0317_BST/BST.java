package java0317_BST;

import java0318_Tree.Tree;

import java.util.Stack;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/15 21:02
 */
public class BST {
    TreeNode root = null;
    TreeNode head = null;
    TreeNode tail = null;

//    public BST(TreeNode root) {
//        this.root = root;
//    }

    // 二叉搜索树的中序遍历是有序的
    // 1. 遍历二叉搜索树
    public void inOrder(TreeNode left) {
        if (this.root == null) {
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
    public TreeNode inOrder2() {
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
    public TreeNode insert(char val) {
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
    public boolean remove(char c) {
        // 先找到该节点
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            int cmp = compare(c, cur.val);
            if (cmp == 0) {
                removeInternal(cur, pre);
                return true;
            } else if (cmp < 0) {
                pre = cur;
                cur = cur.left;
            } else {
                pre = cur;
                cur = cur.right;
            }
        }
        return false;
    }

    private void removeInternal(TreeNode node, TreeNode pre) {
        if (node.left == null && node.right == null) {
            if (node == root) {
                root = null;
            } else if (node == pre.left) {
                pre.left = null;
            } else {
                pre.right = null;
            }
        } else if (node.left != null && node.right == null) {
            if (node == root) {
                root = root.left;
            } else if (node == pre.left) {
                pre.left = node.left;
            } else {
                pre.right = node.left;
            }
        } else if (node.left == null && node.right != null) {
            if (node == root) {
                root = node.right;
            } else if (node == pre.left) {
                pre.left = node.right;
            } else {
                pre.right = node.right;
            }
        } else {
            // 找左子树中最大的与要删除的结点的值进行替换
            TreeNode parent = node;
            TreeNode child = node.left;
            // 一直往右走找最大的
            while (child.right != null) {
                parent = child;
                child = child.right;
            }
            // 进行替换
            node.val = child.val;
            // 删除被替换的结点
            if (parent == node) {
                parent.left = child.left;
            } else {
                parent.right = child.left;
            }
        }
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
