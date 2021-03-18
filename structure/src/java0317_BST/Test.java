package java0317_BST;


/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/17 13:23
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode('D');
        root.left = new TreeNode('B');
        root.right = new TreeNode('F');
        root.left.left = new TreeNode('A');
        root.left.right = new TreeNode('C');
        BST bst = new BST();
        System.out.println(bst.inOrder2(root));
//        bst.insert(root, 'E');
//        bst.insert(root, 'E');

//        bst.inOrder(root);
    }
}
