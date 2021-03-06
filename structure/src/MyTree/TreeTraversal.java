package MyTree;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/5 15:32
 */
public class TreeTraversal {
    public static void preTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.var);
            preTraversal(root.left);
            preTraversal(root.right);
        } else {
            // 空树
        }
    }
    public static void inTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inTraversal(root.left);
        System.out.print(root.var);
        inTraversal(root.right);
    }
    public static void postTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postTraversal(root.left);
        preTraversal(root.right);
        System.out.print(root.var);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        root.left.left = new TreeNode('D');
        root.left.right = new TreeNode('E');
        System.out.print("先序遍历: ");
        preTraversal(root);
        System.out.println();
        System.out.print("中序遍历: ");
        inTraversal(root);
        System.out.println();
        System.out.print("后序遍历: ");
        postTraversal(root);
        System.out.println();
        PreTraversal preTraversal = new PreTraversal();
        System.out.print("先序遍历: ");
        preTraversal.preTraversal1(root);
        System.out.println();
        InTraversal inTraversal = new InTraversal();
        System.out.print("中序遍历: ");
        inTraversal.inTraversal1(root);
        System.out.println();
        PostTraversal postTraversal = new PostTraversal();
        System.out.print("后序遍历: ");
        postTraversal.postTraversal1(root);
        System.out.println();
    }
}