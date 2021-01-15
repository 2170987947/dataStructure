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
        System.out.println("头插成功");
      }

      //尾插法
    public void addEnd(int data) {
        Node node = new Node(data);
        //判断链表是不是第一次插入
//        Node node1 = this.head;
//        if (node1 == null) {
//            node1 = node;
//            this.head = node1;
//            return;
//        }
        if (this.head == null) {
            this.head = node;
            System.out.println("尾插成功");
            return;
        }
        //找最后一个节点
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        System.out.println("尾插成功");
    }

    //任意位置插入, 第一个数据结点下标为 0
    public void addIndex(int index ,int data) {
        if (!checkIndex(index)) {
            return;
        }
        //方法一: 调用函数
        //第一个元素 : 头插
        if (index == 0) {
            System.out.print("任意插,调用");
            addFirst(data);
            return;
        }
        //最后一个元素 : 尾插
        if (index == this.getLength()) {
            System.out.print("任意插,调用");
            addEnd(data);
            return;
        }
        //中间元素 : 1.先找到插入点前一个元素结点. 2.再进行插入
        Node node = new Node(data);
        //保存前一个节点
        Node pre = searchPre(index);
        node.next = pre.next;
        pre.next = node;
        System.out.println("任意插,插入成功");

        //方法二: 不调用函数直接写
//        Node node = new Node(data);
//        if (index == 0) {
//            node.next = this.head;
//            this.head = node;
//            System.out.println("插入成功");
//            return;
//        }
//        //找到插入点前一个元素
//        Node cur = this.head;
//        int count = 0;
//        while (count < index - 1 && cur.next != null) {
//            cur = cur.next;
//            count++;
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
//        System.out.println("任意插,插入成功");
    }

    //查找是否包含关键字 key 的结点
    public boolean contains(int key) {
        if (this.head == null) {
            System.out.println("不存在该关键字 key = " + key);
            return false;
        }
        // 查找关键字为 key 的结点的前驱节点
        // 1. 前驱节点为 null :①头结点的前驱结点为 null ②关键字 key 不存在的结点前驱结点为 null
        // 比较头结点的 data值 是否等于 key;
        // 相等返回 true; 否则 false;
        // 2. 前驱节点不为 null : 包含关键字为 key 的结点: 返回 true;
        if (searchPreNode(key) == null) {
            if (this.head.data == key) {
                return true;
            } else {
                System.out.println("不存在该关键字 key = " + key);
                return false;
            }
        }
        return true;
    }

    //删除第一次出现关键字 key 的结点
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        // 方法一: 使用 contains 函数

        if (!contains(key)) {
            return;
        }else if (this.head.data == key) {
            this.head = this.head.next;
            System.out.println("删除成功");
        }else {
            searchPreNode(key).next = searchPreNode(key).next.next;
            System.out.println("删除成功");
        }
        //方法二: 直接写

        //前驱节点为 null :
        // 1. 头结点的前驱结点为 null
        // 2. 关键字 key 不存在的结点前驱结点为 null
//        if (searchPreNode(key) == null) {
//            //删除头结点
//            if (this.head.data == key) {
//                this.head = this.head.next;
//                 System.out.println("删除成功");
//            } else {
//                System.out.println("不存在该关键字 key = " + key);
//            }
//            return;
//        }
//        //前驱节点不为 null
//        Node pre = searchPreNode(key);
//        pre.next = pre.next.next;
//        System.out.println("删除成功");
    }

    //删除所有值为 key 的结点
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
//        //方法一: 只遍历一次单链表把所有值为 key 的结点删除
//        //删除头结点
//        while (this.head.data == key) {
//            this.head = this.head.next;
//        }
//        //删除普通结点
//        Node cur = this.head;
//        while (cur.next != null) {
//            while (cur.next.data == key) {
//                cur.next = cur.next.next;
//            }
//            cur = cur.next;
//        }
        //方法二: 只遍历一次单链表把所有值为 key 的结点删除
        Node pre = this.head;
        Node cur1 = this.head.next;
        while (cur1 != null) {
            if (cur1.data == key) {
                pre.next = pre.next.next;
                cur1 = pre.next;
            }else {
                pre = cur1;
                cur1 = cur1.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
        //方法三: 调用函数
//        while (contains(key)) {
//            if (searchPreNode(key) == null) {
//                //删除头结点
//                this.head = this.head.next;
//                return;
//            }else {
//                Node pre = searchPreNode(key);
//                pre.next = pre.next.next;
//            }
//        }
    }

    //反转
    public Node reverseList() {
        if (this.head == null) {
            return null;
        }
        //采用头插法
        Node node1 = this.head.next;
        Node node2 = this.head;
        while (node1 != null) {
            addFirst(node1.data);
            node1 = node1.next;
        }
        node2.next = null;
        return head;
    }

    //返回中间结点
    public Node middleList() {
        if (this.head == null) {
            return  null;
        }
        Node middle = this.head;
        Node node1 = this.head;
        Node node2 = this.head.next.next;
        while (node2 != null) {

        }
        return middle;

    }
    //检查 index 位置是否为插入有效位置
    public boolean checkIndex(int index) {
        if (index < 0 || index > this.getLength()) {
            System.out.println("该单链表目前长度为 : " + this.getLength() + ", 插入位置 index = " + index + "有误!");
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

    //清空单链表
    public void clear() {
        this.head = null;
        //内存泄漏
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
