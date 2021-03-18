package java0318_Tree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/18 10:48
 */
public class Tree {
    // 1. 树的高度
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    // 2. 判断是否为完全二叉树
    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (!((left - right <= 1) && (left - right >= -1))) {
            return false;
        }

        return isBalance(root.left) && isBalance(root.right);
    }
    // 3. 判断是否为完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            TreeNode cur = queue.remove();
            if (cur == null) {
                break;
            }
            queue.add(cur.left);
            queue.add(cur.right);
        }
        while (!queue.isEmpty()) {
            if (queue.remove() != null) {
                return false;
            }
        }
        return true;
    }
    // 4. 用先序构建二叉树
    static int i = 0;
    public TreeNode buildUsePreOrder(String s) {
        TreeNode root = null;
        if (s.charAt(i) != '#') {
            root = new TreeNode(s.charAt(i));
            i++;
            root.left = buildUsePreOrder(s);
            root.right = buildUsePreOrder(s);
        } else {
            i++;
        }
        return root;
    }
    // 5. 树的层级遍历
    LinkedList<LinkedList<Character>> lists;
    public LinkedList<LinkedList<Character>> levelOrder(TreeNode root) {
        lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        lists = fun1(root);
        return lists;
    }

    private LinkedList<LinkedList<Character>> fun1(TreeNode root) {
        if (root == null) {
            return lists;
        }
        if (lists.size() == root.level) {
            lists.add(new LinkedList<>());
        }
        lists.get(root.level).add(root.var);
        fun1(root.left);
        fun1(root.right);
        return lists;
    }
}
