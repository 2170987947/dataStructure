package java0313;

import MyTree.TreeShowMethods.TreeNode;

import java.util.*;


/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/13 11:14
 */
public class TreeOperation {
    // 1. 判断两棵树树是否相同
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }
    // 2. 判断两个树是否互为镜像
    public static boolean isMirrorTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val &&
                isMirrorTree(p.left, q.right) &&
                isMirrorTree(p.right, q.left);
    }
    // 3. 判断一个树是否对称
    public static boolean isSymmertryTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirrorTree(root.left, root.right);
    }
    // 4. 判断一棵树是否为另一棵树的子树
    public static boolean isSubtree(TreeNode p, TreeNode q) {
        if (p == null) {
            return false;
        }
        return isSameTree(p, q) ||
                isSubtree(p.left, q) ||
                isSubtree(p.right, q);
    }
    // 5. 树的最大深度
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
    // 6. 判断树是否为平衡树
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftMaxdepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        int sub = leftMaxdepth - rightMaxDepth;
        if (!(sub == -1 || sub == 0 || sub == 1)) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    // 7. 用先序构建二叉树
    static int i = 0;
    public static TreeNode bulidTreeUsePreOrder(String s) {
        TreeNode root = null;
        if (s.charAt(i) != '#') {
            root = new TreeNode(s.charAt(i));
            i++;
            root.left = bulidTreeUsePreOrder(s);
            root.right = bulidTreeUsePreOrder(s);
        } else {
            i++;
        }
        return root;
    }
    // 8. 二叉树的分层遍历
    static class NL{
        TreeNode node;
        int rank;

        public NL(TreeNode node, int rank) {
            this.node = node;
            this.rank = rank;
        }
    }
    // 9 叶子节点的个数
    public static int getLeafSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }
    // 10. 节点的个数
    public static int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getLeafSize(root.left) + getLeafSize(root.right);
    }
    // 11. 第 k 层结点个数
    public static int getLevelSize(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getLevelSize(root.left, k - 1) + getLevelSize(root.right, k - 1);
    }
    // 12. 树的高度
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getLeafSize(root.right));
    }
    // 13. 寻找 toFind 结点
    public static boolean find(TreeNode root, TreeNode toFind) {
        if (root == null) {
            return false;
        }
        if (root == toFind) {
            return true;
        }
        if (find(root.left, toFind)) {
            return true;
        }
        return find(root.right, toFind);
    }
    // 14. 判断一颗树是否为完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        List<Character> listResult = new LinkedList<>();
        list.add(root);
        listResult.add(root.val);
        while (!list.isEmpty()) {
            TreeNode cur = list.remove(0);
            if (cur.left != null) {
                listResult.add(cur.left.val);
                list.add(cur.left);
            } else {
                listResult.add('#');
            }
            if (cur.right != null) {
                listResult.add(cur.right.val);
                list.add(cur.right);
            } else {
                listResult.add('#');
            }
        }
        while (!listResult.isEmpty()) {
            if (listResult.get(0) != '#') {
                listResult.remove(0);
            } else {
                break;
            }
        }
        while (!listResult.isEmpty()) {
            if (listResult.remove(0) != '#') {
                return false;
            }
        }
        return true;
    }
    public boolean isCompleteTree2(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            if (queue.remove() == null) {
                break;
            }
            queue.add(root.left);
            queue.add(root.right);
        }
        while (!queue.isEmpty()) {
            if (queue.remove() != null) {
                return false;
            }
        }
        return true;
    }
    // 13. 层序遍历
    public List<Character> levelOrder1(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        List<Character> listResult = new LinkedList<>();
        while (!list.isEmpty()) {
            TreeNode cur = list.remove(0);
            listResult.add(cur.val);
            if (cur.left != null) {
                list.add(cur.left);
            }
            if (cur.right != null) {
                list.add(cur.right);
            }
        }
        return listResult;
    }
    // 14. 树的层级遍历
    public List<List<Character>>  levelOrder(TreeNode root) {
        List<List<Character>> lists = new LinkedList<>();
        Deque<NL> queue = new LinkedList<>();
        queue.add(new NL(root, 0));
        while (!queue.isEmpty()) {
            NL nl = queue.remove();
            TreeNode cur = nl.node;
            int rank = nl.rank;
            if (lists.size() == rank) {
                lists.add(new ArrayList<>());
            }
            if (cur.left != null) {
                queue.add(new NL(cur.left, rank + 1));
            }
            if (cur.right != null) {
                queue.add(new NL(cur.right, rank + 1));
            }
            lists.get(rank).add(cur.val);
        }
        return lists;
    }
    // 15. 找到两个结点最近的祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (right != null) {
            return lowestCommonAncestor(root.right, p ,q);
        }
        if (left != null) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return null;
    }
    // 16. 二叉搜索树
    public TreeNode searchTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode newRoot = null;
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (newRoot == null) {
                newRoot = cur;
                pre = cur;
            } else {
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }
            cur = cur.right;
        }
        return newRoot;
    }
}
