package MyTree.Traversal;

import MyTree.TreeShowMethods.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/6 2:20
 */
public class PostTraversal {
    public void postTraversal1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        // 当前正在遍历的结点
        TreeNode cur = root;
        // 刚被弹出栈的结点.
        TreeNode pre = null;
        System.out.print("后序遍历(非递归): ");
        while (!stack.isEmpty() || cur != null) {
            // 当 cur 不为空时, 将左边的结点一直压栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 当 cur 为空时, 查看栈顶元素
            TreeNode top = stack.peek();
            // 查看栈顶元素是否有右节点
            // 1. 当无右节点时, 输出该节点的值, 并将该节点从栈中弹出, 此时需要记录刚被弹出的结点
            // 2. 当有右节点并且右节点没有被遍历过, 此时就将当前节点指向其右节点.
            // 3. 当有右节点时, 并且右节点已经被遍历过, 此时将该节点弹出, 记录弹出的结点.
            if (top.right == null) {
                // 无右孩子
                System.out.print(top.val);
                pre = stack.pop();
            } else if (top .right == pre) {
                // 有右孩子并且右孩子已经被遍历过
                System.out.print(top.val);
                pre = stack.pop();
            } else {
                // 右孩子没有被遍历过.
                cur = top.right;
            }
        }
        System.out.println();
    }
}
