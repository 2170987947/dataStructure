package java0314;

import MyTree.TreeShowMethods.TreeNode;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/14 10:58
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode('1');
        root.left = new TreeNode('2');
        root.right = new TreeNode('3');
        root.left.left = new TreeNode('4');
//        root.left.right = new TreeNode('E');
//        root.left.right.right = new TreeNode('F');
        TreeTest treeTest = new TreeTest();
        System.out.println(treeTest.createStringUseTree(root));
    }
}
