package MyTree;

import MyTree.TreeShowMethods.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
        System.out.println(root.val);
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
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }
    // 后序遍历
    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val);
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
            if (root.val == val) {
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
        if (root.val == var) {
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
            if (root.val == var) {
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
        if (root.val == var) {
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
            System.out.println(treeNode.val);
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
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            TreeNode node = queue.remove();
            if (node == null) {
                break;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        while (!queue.isEmpty()) {
            if (queue.remove().val != '#') {
                return false;
            }
        }
        return true;
    }

    // 判断一个树是否为平衡树
    // 判断两个树是否相同
    // 判断一个树是否具有对称性

    // 二叉树的分层遍历
    public List<List<Character>> levelOrder(TreeNode root) {
        class Inner{
            TreeNode node;
            int level;
            public Inner(TreeNode n, int l) {
                this.node = n;
                this.level = l;
            }
        }

        Deque<Inner> queue = new LinkedList<>();
        List<List<Character>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        queue.add(new Inner(root, 0));
        while (!queue.isEmpty()) {
            Inner inner = queue.remove();
            TreeNode node = inner.node;
            int level1 = inner.level;
            if (level1 == list.size()){
                list.add(new ArrayList<>());
            }
            list.get(level1).add(node.val);
            if (node.left != null) {
                queue.add(new Inner(node.left, level1 + 1));
            }
            if (node.right != null) {
                queue.add(new Inner(node.right, level1 + 1));
            }
        }
        return list;
    }
}
