package java0304;

import java.util.LinkedList;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/4 11:39
 */

public class Partition {
    public static ListNode partition(ListNode pHead, int x) {
//        if (pHead == null) {
//            return null;
//        }
//        if (pHead.next == null) {
//            return null;
//        }
       ListNode smallHead = new ListNode(0);
       ListNode smallTail = smallHead;
       ListNode bigHead = new ListNode(0);
       ListNode bigTail = bigHead;
       for (ListNode cur = pHead; cur != null; cur = cur.next) {
           if (cur.val < x) {
               smallTail.next = new ListNode(cur.val);
               smallTail = smallTail.next;
           } else {
               bigTail.next = new ListNode(cur.val);
               bigTail = bigTail.next;
           }
       }
       smallTail.next = bigHead.next;
       return smallHead.next;
    }

    public static void main(String[] args) {
        ListNode listHead = new ListNode(3);
        ListNode list = listHead;
        list.next = new ListNode(3);
        list = listHead.next;
        list.next = new ListNode(3);
//        while (listHead != null) {
//            System.out.print(listHead.val + "  ");
//            listHead = listHead.next;
//        }
        ListNode listNode = partition(listHead, 3);
        System.out.println();
        while (listNode != null) {
            System.out.print(listNode.val + "  ");
            listNode = listNode.next;
        }
    }
}
