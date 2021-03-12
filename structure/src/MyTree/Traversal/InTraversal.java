package MyTree.Traversal;

import MyTree.TreeShowMethods.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/6 1:58
 */
public class InTraversal {
    public void inTraversal1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        // 当前节点
        TreeNode cur = root;
        TreeNode pre = null;
        System.out.print("中序遍历(非递归): ");
        while (!stack.isEmpty() || cur != null) {
            // 如果 cur 不为空, 将其压栈.
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // cur 当前为空(说明刚压入栈的栈顶元素没有左节点)
            // 就弹出栈顶元素并输出
            // 并将 cur 指向栈顶元素的右节点
            TreeNode top = stack.peek();
            if (top.right == null) {
                pre  = stack.pop();
                System.out.print(top.val);
            } else if (top.right == pre) {
                pre = stack.pop();
            } else {
                System.out.print(top.val);
                cur = top.right;
            }
        }
        System.out.println();
    }
}
