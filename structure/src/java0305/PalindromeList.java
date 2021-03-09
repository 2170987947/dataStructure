package java0305;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/5 19:58
 */
public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        // write code here
        if (A == null || A.next == null) {
            return true;
        }
        ListNode temp = A;
        ListNode newHead = new ListNode(0);
        ListNode Tail = newHead;
        while (temp != null) {
            Tail.next = new ListNode(temp.val);
            Tail = Tail.next;
        }
        newHead = newHead.next;
        ListNode B = null;
        ListNode pre = null;
        ListNode cur = newHead;

        while (cur != null) {
            ListNode next = cur;
            if (next == null) {
                B = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode cur1 = A;
        ListNode cur2 = B;
        while (cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }
}
