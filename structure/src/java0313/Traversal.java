package java0313;

import MyTree.TreeShowMethods.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/13 9:13
 */
public class Traversal {
    // 递归
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
    // 非递归
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
    // 递归
    public static List<Character> preOrder3(TreeNode root) {
        List<Character> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        // 1. 先序
        result.add(root.val);
        result.addAll(preOrder3(root.left));
        // 2. 中序
//        result.add(root.val);
        result.addAll(preOrder3(root.right));
        //3 . 后序
//        result.add(root.val);
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        root.left.left = new TreeNode('D');
        root.left.right = new TreeNode('E');
        root.left.right.right = new TreeNode('F');
//        Traversal traversal = new Traversal();
//        traversal.preOrder(root);
//        System.out.println();
//        Traversal.preOrder1(root);
        TreeOperation treeOperation = new TreeOperation();
//        System.out.println(treeOperation.levelOrder(root));
//        System.out.println(treeOperation.levelOrder1(root));
//        System.out.println(treeOperation.isCompleteTree(root));
        System.out.println(treeOperation.lowestCommonAncestor(root, root.right, root.left.left).val);
        System.out.println(treeOperation.bulidTreeUsePreOrder("ABD##E##C##"));
    }
}
