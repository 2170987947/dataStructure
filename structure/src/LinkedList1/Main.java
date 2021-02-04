package LinkedList1;


/**
 * @author FMM
 * @version 7.0
 * @date 2021/1/29 0:54
 */
public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(2,5);
        myLinkedList.add(4);
        myLinkedList.display();
        myLinkedList.remove(0);
        myLinkedList.display();
        myLinkedList.remove(Integer.valueOf(4));
        myLinkedList.display();
        myLinkedList.removeAll(5);
        myLinkedList.display();
//        System.out.println(myLinkedList.set(-1,9));
//        myLinkedList.display();
//        myLinkedList.removeAll(4);
//        System.out.println(myLinkedList.get(-1));
//        System.out.println(myLinkedList.indexOf(4));
//        System.out.println(myLinkedList.contains(5));
//        myLinkedList.reverse();
//        myLinkedList.findKthRe(1);
//        System.out.println(myLinkedList.findKthRe(3).data);
//        System.out.println(myLinkedList.middleNode().data);
//        myLinkedList.isPalindromeSequence();
//        myLinkedList.display();
    }
}
