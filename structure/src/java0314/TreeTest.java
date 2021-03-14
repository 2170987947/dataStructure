package java0314;

import MyTree.TreeShowMethods.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/14 9:27
 */
public class TreeTest {
    // 将数组成链表
    public List<Character> arrayToList(char[] arr) {
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
    // 1. 根据前序和中序构建二叉树
    public TreeNode buildTreeUsePreIn(List<Character> preorder, List<Character> inorder) {
        TreeNode root = null;
        if (!preorder.isEmpty()) {
            int index = inorder.indexOf(preorder.get(0));
            root = new TreeNode(preorder.get(0));
            TreeNode left = buildTreeUsePreIn(preorder.subList(1, 1 + index), inorder.subList(0, index));
            TreeNode right = buildTreeUsePreIn(preorder.subList(1 + index, preorder.size()), inorder.subList(index + 1, inorder.size()));
            root.left = left;
            root.right = right;
        }
        return root;
    }
    // 2. 根据中序和后序构建二叉树
    public TreeNode buildTreeUseInPost(List<Character> inorder, List<Character> postorder) {
        TreeNode root = null;
        if (!postorder.isEmpty()) {
            int index = inorder.indexOf(postorder.get(postorder.size() - 1));
            root = new TreeNode(postorder.get(postorder.size() - 1));
            root.left = buildTreeUseInPost(inorder.subList(0, index), postorder.subList(0, index));
            root.right = buildTreeUseInPost(inorder.subList(index + 1, inorder.size()), postorder.subList(index, postorder.size() - 1));
        }
        return root;
    }
    // 3. 根据二叉树创建字符串
    public String createStringUseTree(TreeNode root) {
        StringBuilder s = new StringBuilder();
        if (root == null) {
            return "";
        }
        s.append(root.val);
        if (root.left == null && root.right == null) {
            return s.toString();
        } else if (root.left != null && root.right == null) {
            s.append('(');
            s.append(createStringUseTree(root.left));
            s.append(')');
        } else {
            s.append('(');
            s.append(createStringUseTree(root.left));
            s.append(')');
            s.append('(');
            s.append(createStringUseTree(root.right));
            s.append(')');
        }
        return s.toString();
    }
    
}
