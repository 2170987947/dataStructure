package LinkedList1;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(4);
        myLinkedList.add(5);
//        myLinkedList.add(4,4);
        System.out.println(myLinkedList.set(-1,9));
        myLinkedList.display();
    }
}
