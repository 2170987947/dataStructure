package java0305;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/5 18:24
 */
public class Partition {
    public static ListNode partition(ListNode pHead, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(0);
        ListNode bigTail = bigHead;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.val < x) {
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
            cur = cur.next;
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}
