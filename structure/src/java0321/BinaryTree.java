package java0321;


import java0318_Tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/21 22:27
 */
public class BinaryTree {
    // 1. 先序遍历
    public void preOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            System.out.print(top.val);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
        System.out.println();
    }
    // 2. 中序遍历
    public void inOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val);
            cur = top.right;
        }
        System.out.println();
    }
    // 3. 后序遍历
    public void postOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null) {
                System.out.print(top.val);
                pre = stack.pop();
            } else if (top.right == pre) {
                System.out.print(top.val);
                pre = stack.pop();
            } else {
                cur = top.right;
            }
        }
        System.out.println();
    }
    // 4. 用先序遍历结果构建二叉树
    static int i = 0;
    public TreeNode buildTreeUsePre(String s) {
        TreeNode root = null;
        if (s == null) {
            return null;
        }
        if (s.charAt(i) != '#') {
            root = new TreeNode(s.charAt(i));
            i++;
            root.left = buildTreeUsePre(s);
            root.right = buildTreeUsePre(s);
        } else {
            i++;
        }
        return root;
    }
    // 5. 层级遍历
    public List<List<Character>> levelOrder(TreeNode root) {
        List<List<Character>> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        class NL {
            TreeNode node;
            int level;

            public NL(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }
        Deque<NL> queue = new LinkedList<>();
        queue.add(new NL(root, 0));
        while (!queue.isEmpty()) {
            NL nl = queue.remove();
            TreeNode node = nl.node;
            int level = nl.level;
            if (level == lists.size()) {
                lists.add(new LinkedList<>());
            }
            lists.get(level).add(node.val);
            if (node.left != null) {
                queue.add(new NL(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new NL(node.right, level + 1));
            }
        }
        return lists;
    }
    // 6. 最近的公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return root;
        }
        if (left == null) {
            return lowestCommonAncestor(right, p, q);
        }
        if (right == null) {
            return lowestCommonAncestor(left, p, q);
        }
        return null;
    }
    // 7. 将二叉搜索树转换成有序双向链表
    TreeNode head = null;
    TreeNode tail = null;
    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        Convert(root.left);
        add(root);
        Convert(root.right);
        return head;
    }
    private void add(TreeNode node) {
        if (tail == null) {
            head = tail = node;
        } else {
            tail.right = node;
            node.left = tail;
            tail = node;
        }
    }
    // 8.  从前序与中序遍历序列构造二叉树
    public TreeNode buildTree(char[] preorder, char[] inorder) {
        List<Character> pre = arrayToList(preorder);
        List<Character> in = arrayToList(inorder);
        return bulidTreeUsePreIn(pre, in);
    }

    private TreeNode bulidTreeUsePreIn(List<Character> pre, List<Character> in) {
        TreeNode root = null;
        if (pre == null) {
            return null;
        }
        if (!pre.isEmpty()) {
            root = new TreeNode(pre.get(0));
            int index = in.indexOf(pre.get(0));
            root.left = bulidTreeUsePreIn(pre.subList(1, 1 + index), in.subList(0, index));
            root.right = bulidTreeUsePreIn(pre.subList(1 + index, pre.size()), in.subList(index + 1, in.size()));
        }
        return root;
    }

    private List<Character> arrayToList(char[] preorder) {
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < preorder.length; i++) {
            list.add(preorder[i]);
        }
        return list;
    }

}
