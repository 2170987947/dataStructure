package java0318_Tree;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/18 10:48
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode('D');
        root.left = new TreeNode('B');
        root.right = new TreeNode('F');
        root.left.left = new TreeNode('A');
        root.left.right = new TreeNode('C');
        root.left.left.left = new TreeNode('w');
        Tree tree = new Tree();
//        System.out.println(tree.height(root));
//        System.out.println(tree.isBalance(root));
//        System.out.println(tree.isCompleteTree(root));
        System.out.println(tree.buildUsePreOrder("ABD##E##C##"));
    }
}
