package java0321;


/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/21 22:26
 */
public class Test {
    public static void main(String[] args) {
//        TreeNode a = new TreeNode('A');
//        TreeNode b = new TreeNode('B');
//        TreeNode c = new TreeNode('C');
//        TreeNode d = new TreeNode('D');
//        TreeNode e = new TreeNode('E');
//        TreeNode root = a;
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.preOrderByLoop(root);
//        binaryTree.inOrderByLoop(root);
//        binaryTree.postOrderByLoop(root);
        BinaryTree.i = 0;
        TreeNode root = binaryTree.buildTreeUsePre("ABD##E##C##");
//        binaryTree.preOrderByLoop(root);
//        binaryTree.inOrderByLoop(root);
//        binaryTree.postOrderByLoop(root);
        System.out.println(binaryTree.levelOrder(root));
    }
}
