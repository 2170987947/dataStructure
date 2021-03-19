package java0319;

import java.util.LinkedList;
import java.util.List;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/19 12:40
 */
public class TreeTest {

    // 1. 根据先序遍历结果构建二叉树
    static int i = 0;
    public TreeNode buildTreeUsePre(String s) {
        TreeNode root = null;
        if (s == null) {
            return root;
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
    // 2. 先序和中序遍历二叉树
    public TreeNode buildTreeUsePreIn(List<Character> pre, List<Character> in) {
        TreeNode root = null;
        if (pre == null) {
            return null;
        }
        int index = in.indexOf(pre.get(0));
        root = new TreeNode(pre.get(0));
        root.left = buildTreeUsePreIn(pre.subList(1, 1 + index), in.subList(0, index));
        root.right = buildTreeUsePreIn(pre.subList(1 + index, pre.size()), in.subList(index + 1, in.size()));
        return root;
    }
    // 3. 层级遍历
    List<List<Character>> lists;
    public List<List<Character>> levelOrder(TreeNode root) {
        lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        lists = fun1(root, 0);
        return lists;
    }

    public List<List<Character>> fun1(TreeNode root, int level) {
        if (root == null) {
            return lists;
        }
        if (lists.size() == level) {
            lists.add(new LinkedList<>());
        }
        lists.get(level).add(root.val);
        fun1(root.left, level + 1);
        fun1(root.right, level + 1);
        return lists;
    }
}
