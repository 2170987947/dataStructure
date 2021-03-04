package java0304;

import java.util.LinkedList;

public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode cur = pHead;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur != null && cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // 链表结束
                // cur 到达重复元素的最后一个
            } else {
                tail.next = new ListNode(cur.val);
                tail = tail.next;
            }
            cur = cur.next;
        }
        if (cur != null) {
            tail.next = new ListNode(cur.val);
        }
        return head.next;
    }
}
