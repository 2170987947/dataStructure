package java0329_BinarySearchTree;


/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/29 7:43
 */
public class BinarySearchTree {
    public TreeNode root = null;

    public Integer put(int key, int value) {
        if (root == null) {
            root = new TreeNode(key, value);
            return null;
        }
        Integer result = null;
        TreeNode cur = root;
        TreeNode pre = null;
        int cmp = 0;
        while (cur != null) {
            cmp = cmp(key, cur.key);
            if (cmp < 0) {
                // key 小于 当前节点的 key
                pre = cur;
                cur = cur.left;
            } else if (cmp > 0) {
                // key 大于 当前节点的 key
                pre = cur;
                cur = cur.right;
            } else {
                // 找到了
                result = cur.value;
                // 修改原来 value 的值
                cur.value = value;
            }
        }
        // 没有找到，添加新节点
        if (cmp < 0) {
            pre.left = new TreeNode(key, value);
        } else {
            pre.right = new TreeNode(key, value);
        }
        return result;
    }

    private int cmp(int key, int key1) {
        return key - key1;
    }

    public Integer get(int key) {
        if (root == null) {
            return null;
        }
        Integer result = null;
        TreeNode cur = root;
        while (cur != null) {
            int cmp = cmp(key, cur.key);
            if (cmp < 0) {
                cur = cur.left;
            } else if (cmp > 0) {
                cur = cur.right;
            } else {
                return cur.value;
            }
        }
        return result;
    }

    public Integer remove(int key) {
        if (root == null) {
            return null;
        }
        Integer result = null;
        TreeNode cur = root;
        // 记录要删除结点的父节点
        TreeNode pre = null;
        while (cur != null) {
            int cmp = cmp(key, cur.key);
            if (cmp < 0) {
                pre = cur;
                cur = cur.left;
            } else if (cmp > 0) {
                pre = cur;
                cur = cur.right;
            } else {
                removeInternal(pre, cur);
                result = cur.value;
                break;
            }
        }
        // 返回被删除结点的 value 值
        return result;
    }

    private void removeInternal(TreeNode pre, TreeNode cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == pre.left) {
                pre.left = cur.right;
            } else {
                pre.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == pre.left) {
                pre.left = cur.left;
            } else {
                pre.right = cur.left;
            }
        } else {
            // 找右子树的最小值，将该值与要删除结点的值进行交换，最后删除该结点
            TreeNode parent = cur;
            TreeNode child = cur.right;
            while (child.left != null) {
                parent = child;
                child = child.left;
            }
            // 替换值
            pre.value = child.value;
            // 删除结点
            if (child == parent.right) {
                parent.right = child.right;
            } else {
                parent.left = child.right;
            }
        }
    }
}
