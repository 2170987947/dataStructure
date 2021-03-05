package java0305;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/5 19:00
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                newTail.next = new ListNode(cur1.val);
                cur1 = cur1.next;
            } else {
                newTail.next = new ListNode(cur2.val);
                cur2 = cur2.next;
            }
            newTail = newTail.next;
        }
        if (cur1 != null) {
            newTail.next = cur1;
        } else {
            newTail.next = cur2;
        }
        return newHead.next;
    }
}
