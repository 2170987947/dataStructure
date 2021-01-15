/**
 * @author FMM
 * @version 7.0
 * @date 2021/1/14 10:14
 */
public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addIndex(0,100);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addEnd(5);
        myLinkedList.addEnd(6);
        //-1, 6 是非法插入
        myLinkedList.addIndex(-1,10);
        myLinkedList.addIndex(6,14);
        //头插
        myLinkedList.addIndex(0,11);
        //尾插
        myLinkedList.addIndex(6,12);
        //中间插
        myLinkedList.addIndex(5,13);

        myLinkedList.display();
    }
}
