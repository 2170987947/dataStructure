package java0319;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/19 12:40
 */
public class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + "" + left + right;
    }
}
