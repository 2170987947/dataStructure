package java0304;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/4 21:15
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1 = getLength(headA);
        int length2 = getLength(headB);
        ListNode l1 = headA;
        ListNode l2 = headB;
        if (length1 > length2) {
            int steps = length1 - length2;
            for (int i = 0; i < steps; i++) {
                l1 = l1.next;
            }
        } else {
            int steps = length2 - length1;
            for (int i = 0; i < steps; i++) {
                l2 = l2.next;
            }
        }
        while (l1 != null && l2 != null) {
            if (l1 == l2) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }
    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
