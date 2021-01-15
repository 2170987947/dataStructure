/**
 * @author FMM
 * @version 7.0
 * @date 2021/1/14 10:06
 */
public class MyLinkedList {
    //表示链表头结点
    public Node head;

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
        Node node1 = this.head;
//        if (node1 == null) {
//            node1 = node;
//            this.head = node1;
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
        if (!checkIndex(index)) {
            return;
        }
        //第一个元素 : 头插
        if (index == 0) {
            addFirst(data);
            return;
        }
        //最后一个元素 : 尾插
        if (index == this.getLength()) {
            addEnd(data);
            return;
        }
        //中间元素 : 1.先找到插入点前一个元素结点. 2.再进行插入
        Node node = new Node(data);
        //保存前一个节点
        Node pre = searchPre(index);
        node.next = pre.next;
        pre.next = node;
//        Node node = new Node(data);
//        if (index == 0) {
//            node.next = this.head;
//            this.head = node;
//            return;
//        }
        //找到插入点前一个元素
//        Node cur = this.head;
//        int count = 0;
//        while (count < index - 1 && cur.next != null) {
//            cur = cur.next;
//            count++;
//            System.out.println(cur.data);
//        }
//        //同时满足采用尾插法
//        if (count == index - 1 && cur.next == null) {
//            addEnd(data);
//            return;
//        }
//        if (count == index - 1) {
//            node.next = cur.next;
//            cur.next = node;
//        }
//        if (count < index - 1) {
//            System.out.println("插入位置有误");
//        }

    }
    //删除第一次出现关键字 key 的结点
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        //前驱节点为 null :
        // 1. 头结点的前驱结点为 null
        // 2. 关键字 key 不存在的结点前驱结点为 null
        if (searchPreNode(key) == null) {
            //删除头结点
            if (this.head.data == key) {
                this.head = this.head.next;
            } else {
                System.out.println("不存在该关键字 key = " + key);
            }
            return;
        }
        //前驱节点不为 null
        Node pre = searchPreNode(key);
        pre.next = pre.next.next;
    }
    //检查 index 位置是否为插入有效位置
    public boolean checkIndex(int index) {
        if (index < 0 || index > this.getLength()) {
            System.out.println("改单链表目前长度为 : " + this.getLength() + ", 插入位置 index = " + index + "有误!");
            return false;
        }
        return true;
    }
    //找关键字 key 对应节点的前驱结点
    public Node searchPreNode(int key) {
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //找 index 结点的前驱结点
    public Node searchPre(int index) {
        Node cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;

    }
    //计算单链表长度
    public int getLength() {
        if (this.head == null) {
            return 0;
        }
        int count = 0;
        Node node1 = this.head;
        while (node1 != null) {
            node1 = node1.next;
            count++;
        }
        return count;
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
