/**
 * @author FMM
 * @version 7.0
 * @date 2021/1/14 10:06
 */
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class MyLinkedList {
    //表示链表头结点
    public Node head;
    public int usedSize;

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
//        if (this.head == null) {
//            this.head = node;
//        } else {
//            node.next = this.head;
//            this.head = node;
//        }
        node.next = this.head;
        this.head = node;
      }

      //尾插法
    public void addEnd(int data) {
        Node node = new Node(data);
        //判断链表是不是第一次插入
//        Node node1 = this.head;
//        if (node1 == null) {
//            node1 = node;
//            return;
//        }
        if (this.head == null) {
            this.head = node;
            return;
        }
        //找最后一个节点
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //插入到某个位置
    public void addIndex(int index ,int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node node = new Node(data);
//        if (index == 0) {
//            node.next = this.head;
//            this.head = node;
//            return;
//        }
        //找到插入点前一个元素
        Node cur = this.head;
        int count = 0;
        while (count < index - 1 && cur.next != null) {
            cur = cur.next;
            count++;
            System.out.println(cur.data);
        }
        //同时满足采用尾插法
        if (count == index - 1 && cur.next == null) {
            addEnd(data);
            return;
        }
        if (count == index - 1) {
            node.next = cur.next;
            cur.next = node;
        }
        if (count < index - 1) {
            System.out.println("插入位置有误");
        }

    }
     //打印
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
