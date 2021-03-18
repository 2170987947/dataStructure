package java0317_BST;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/18 10:35
 */
public class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(char var) {
        this.val = var;
    }

    @Override
    public String toString() {
        return val + "" + right;
    }
}
