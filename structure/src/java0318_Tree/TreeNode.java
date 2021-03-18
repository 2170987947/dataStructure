package java0318_Tree;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/18 10:50
 */
public class TreeNode {
    char var;
    TreeNode left;
    TreeNode right;
    int level;

    public TreeNode(char var) {
        this.var = var;
    }
    public TreeNode(char var, int level) {
        this.var = var;
        this.level = level;
    }

    @Override
    public String toString() {
        return var + "" + left + "" + right;
    }
}
