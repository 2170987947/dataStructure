/**
 * @author FMM
 * @version 7.0
 * @date 2021/1/14 10:14
 */
public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.addEnd(5);
        myLinkedList.addEnd(6);
        myLinkedList.addEnd(7);
        myLinkedList.addIndex(0,10);
        myLinkedList.addIndex(2,11);
        myLinkedList.addIndex(8,12);
        myLinkedList.addIndex(10,13);

        myLinkedList.display();
    }
}
