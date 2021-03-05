package java0304;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/4 20:14
 */
public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        ListNode listNode = new ListNode(0);
        ListNode tail = listNode;
        for (ListNode cur = A; cur != null; cur = cur.next) {
            tail.next = new ListNode(cur.val);
            tail = tail.next;
        }
        ListNode B = listNode.next;
        ListNode pre = null;
        ListNode cur = B;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                B = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode cur2 = B;
        ListNode cur1 = A;
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
