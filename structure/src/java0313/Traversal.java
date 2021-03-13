package java0313;

import MyTree.TreeShowMethods.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/13 9:13
 */
public class Traversal {
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 1. 先序
//        System.out.print(root.val);
        preOrder(root.left);
        // 2. 中序
//        System.out.print(root.val);
        preOrder(root.right);
        // 3. 后序
        System.out.print(root.val);
    }
    public static void preOrder1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                // 1. 先序
//                System.out.print(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null) {
                // 可认为第二次或第三次经过此结点
                // 2. 中序
                // 3. 后序
                System.out.print(top.val);
                pre = stack.pop();
            } else if (top.right == pre) {
                // 第三次经过此结点
                // 3. 后序
                System.out.print(top.val);
                pre = stack.pop();
            } else {
                // 第二次经过此结点
                // 2. 中序
//                System.out.print(top.val);
                cur = top.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        root.left.left = new TreeNode('D');
        root.left.right = new TreeNode('E');
        Traversal traversal = new Traversal();
        traversal.preOrder(root);
        System.out.println();
        Traversal.preOrder1(root);
    }
}
