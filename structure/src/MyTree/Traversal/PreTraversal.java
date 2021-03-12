package MyTree.Traversal;

import MyTree.TreeShowMethods.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/6 1:09
 */
public class PreTraversal {

    public void preTraversal1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        // 记录刚被遍历过的结点
        TreeNode pre = null;
        System.out.print("先序遍历(非递归): ");
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val);
                cur = cur.left;
            }
            // 当前 cur 不为空 (说明栈顶元素无左节点)
            TreeNode top = stack.peek();
            if (top.right == null) {
                // 1. 如果栈顶元素无右节点, 弹出栈顶元素
                pre = stack.pop();
            } else if (top.right == pre) {
                // 3. 如果栈顶元素有右节点, 并且被访问过, 就弹出
                pre = stack.pop();
            } else {
                // 2. 如果栈顶元素有右节点, 将 cur 指向栈顶元素的右节点.
                cur = top.right;
            }
        }
        System.out.println();
    }
}
