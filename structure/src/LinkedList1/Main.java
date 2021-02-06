package LinkedList1;


/**
 * @author FMM
 * @version 7.0
 * @date 2021/1/29 0:54
 */
public class Main {
    public static void main(String[] args) {
//        MyLinkedList<Integer> myLinkedList1 = new MyLinkedList<>();
//        myLinkedList1.add(1);
//        myLinkedList1.add(3);
//        myLinkedList1.add(5);
//        MyLinkedList<Integer> myLinkedList2 = new MyLinkedList<>();
//        myLinkedList2.add(2);
//        myLinkedList2.add(4);
//        myLinkedList2.add(6);
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(3);
        myLinkedList.add(3);
        myLinkedList.add(2,8);
        myLinkedList.add(3);
        myLinkedList.add(3);
//        myLinkedList.add(2,3);
//        myLinkedList.add(1);
//        myLinkedList1.display();
//        myLinkedList2.display();
        myLinkedList.display();
        myLinkedList.deleteDuplication();
//        myLinkedList.merge(myLinkedList1, myLinkedList2);
//        myLinkedList.partition(3);
//        myLinkedList.remove(0);
        myLinkedList.display();
//        myLinkedList.remove(Integer.valueOf(4));
//        myLinkedList.display();
//        myLinkedList.removeAll(5);
//        myLinkedList.display();
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
