package MyTree;

import MyTree.TreeShowMethods.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/7 2:30
 */
public class TreeMehods {
    static int size = 0;
    static int leafCount = 0;
    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        size++;
        System.out.println(root.var);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    // 中序遍历
    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafCount++;
        }
        inOrderTraversal(root.left);
        System.out.println(root.var);
        inOrderTraversal(root.right);
    }
    // 后序遍历
    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.var);
    }
    // 遍历思路求结点个数
    public int getSize1(TreeNode root) {
        size = 0;
        preOrderTraversal(root);
        return size;
    }
    // 子树思路求结点个数
    public int getSize2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftTreeCount = getSize2(root.left);
            int rightTreeCout = getSize2(root.right);
            return leftTreeCount + rightTreeCout + 1;
        }
    }
    // 遍历思路求叶子结点的个数
    public int getLeafSize1(TreeNode root) {
        leafCount = 0;
        inOrderTraversal(root);
        return leafCount;
    }
    // 子树思路求叶子结点的个数
    public int getLeafSize2(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            int leftTreeLeafCount = getLeafSize2(root.left);
            int rigtTreehLeafCount = getLeafSize2(root.right);
            return leftTreeLeafCount + rigtTreehLeafCount;
        }
    }
    // 求树第 k 层的几点个数
    public int getKLevelSize(TreeNode root, int k) {
        if (root == null) {
            return 0;
        } else if (k == 1) {
            return 1;
        } else {
            int leftKLevelCount = getKLevelSize(root.left, k - 1);
            int rightKLevelCount = getKLevelSize(root.right, k - 1);
            return leftKLevelCount + rightKLevelCount;
        }
    }
    // 求树的高度
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeightTree = getHeight(root.left);
            int rightHeightTree = getHeight(root.right);
            return max(leftHeightTree, rightHeightTree) + 1;
        }
    }
    public int max(int a, int b) {
        return a > b ? a : b;
    }
    // 查找 val 所在的节点是否存在
    public boolean find1(TreeNode root, int val) {
        if (root == null) {
            return false;
        } else {
            if (root.var == val) {
                return true;
            } else {
                boolean treeNode = find1(root.left, val);
                if (treeNode) {
                    return true;
                } else {
                    treeNode = find1(root.right, val);
                    if (treeNode) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    // 查找 val 所在的结点是否存在
    public boolean find2(TreeNode root, int var) {
        if (root == null) {
            return false;
        }
        if (root.var == var) {
            return true;
        }
        boolean result = find2(root.left, var);
        if (result) {
            return true;
        }
        return find1(root.right, var);
    }

    // 查找 val 所在的结点
    public TreeNode find3(TreeNode root, int var) {
        if (root == null) {
            return null;
        } else {
            if (root.var == var) {
                return root;
            } else {
                TreeNode treeNode = find3(root.left, var);
                if (treeNode != null) {
                    return treeNode;
                } else {
                    return find3(root.right, var);
                }
            }
        }
    }

    // 查找 val 所在的结点
    public TreeNode find4(TreeNode root, int var) {
        if (root == null) {
            return null;
        }
        if (root.var == var) {
            return root;
        }
        TreeNode treeNode = find3(root.left, var);
        if (treeNode != null) {
            return treeNode;
        }
        return find3(root.right, var);
    }

    // 查找 node 结点是否存在
    public boolean find5(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (node == root) {
            return true;
        }
        boolean resultLeft = find5(root.left, node);
        if (resultLeft) {
            return true;
        }
        return find5(root.right, node);
    }

    // 二叉树的层序遍历
    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();
            System.out.println(treeNode.var);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }

    // 判断二叉树是否为完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isCompleteTree(root.left) == isCompleteTree(root.right);
    }
}
