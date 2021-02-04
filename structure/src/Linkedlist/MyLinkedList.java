package Linkedlist;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/1/14 10:06
 */
public class MyLinkedList {
    // 表示链表头结点
    public Node head;

    // 1. 头插法
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
//        System.out.println("头插成功");
      }

      // 2. 尾插法
    public void addEnd(int data) {
        Node node = new Node(data);
        //判断链表是不是第一次插入
//        Linkedlist.Node node1 = this.head;
//        if (node1 == null) {
//            node1 = node;
//            this.head = node1;
//            return;
//        }
        if (this.head == null) {
            this.head = node;
//            System.out.println("尾插成功");
            return;
        }
        //找最后一个节点
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
//        System.out.println("尾插成功");
    }

    // 3. 任意位置插入, 第一个数据结点下标为 0
    public void addIndex(int index ,int data) {
        if (!checkIndex(index)) {
            return;
        }
        //方法一: 调用函数
        //第一个元素 : 头插
        if (index == 0) {
//            System.out.print("任意插,调用");
            addFirst(data);
            return;
        }
        //最后一个元素 : 尾插
        if (index == this.getLength()) {
//            System.out.print("任意插,调用");
            addEnd(data);
            return;
        }
        //中间元素 : 1.先找到插入点前一个元素结点. 2.再进行插入
        Node node = new Node(data);
        //保存前一个节点
        Node pre = searchPre(index);
        node.next = pre.next;
        pre.next = node;
//        System.out.println("任意插,插入成功");

        //方法二: 不调用函数直接写
//        Linkedlist.Node node = new Linkedlist.Node(data);
//        if (index == 0) {
//            node.next = this.head;
//            this.head = node;
//            System.out.println("插入成功");
//            return;
//        }
//        //找到插入点前一个元素
//        Linkedlist.Node cur = this.head;
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

    // 4. 查找是否包含关键字 key 的结点
    public boolean contains(int key) {
        if (this.head == null) {
//            System.out.println("不存在该关键字 key = " + key);
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
//                System.out.println("不存在该关键字 key = " + key);
                return false;
            }
        }
        return true;
    }

    // 5. 删除第一次出现关键字 key 的结点
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        // 方法一: 使用 contains 函数

        if (!contains(key)) {
            return;
        }else if (this.head.data == key) {
            this.head = this.head.next;
//            System.out.println("删除成功");
        }else {
            searchPreNode(key).next = searchPreNode(key).next.next;
//            System.out.println("删除成功");
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
//        Linkedlist.Node pre = searchPreNode(key);
//        pre.next = pre.next.next;
//        System.out.println("删除成功");
    }

    // 6. 删除所有值为 key 的结点
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
//        Linkedlist.Node cur = this.head;
//        while (cur.next != null) {
//            while (cur.next.data == key) {
//                cur.next = cur.next.next;
//            }
//            cur = cur.next;
//        }
        //方法二: 只遍历一次单链表把所有值为 key 的结点删除
        Node pre = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                pre.next = pre.next.next;
                cur = pre.next;
            }else {
                pre = cur;
                cur = cur.next;
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
//                Linkedlist.Node pre = searchPreNode(key);
//                pre.next = pre.next.next;
//            }
//        }
    }

    // 7. 反转: 采用头插法
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

    // 8. 返回中间结点: 只遍历一次单链表
    // eg: 1, 2, 3  =====>  2
    // eg: 1, 2, 3, 4 =====> 3
    public Node middleList() {
        // slow 一次走一步
        Node slow = this.head;
        // fast 一次走两步
        Node fast = this.head;
        // 第一个条件是针对头指针为空指针,也就是说链表为空
        // 条件顺序不能交换: 否则会出现空指针异常
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 9. 输入一个链表,输出该链表中倒数第 K 个结点
    // 只遍历单链表一次: 即不能求长度
    public Node findKthRe(int k) {
        if (k <= 0) {
            return null;
        }
        //方法一:
        Node slow = this.head;
        Node fast = this.head;
        int fastCount = 0;
        while (fast != null && fast.next != null && fastCount < k - 1) {
            fast = fast.next;
            fastCount++;
        }
        // k 超越单链表长度
        if (fastCount < k - 1) {
            return null;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
        //方法二:
//        this.reverseList();
//        return searchPre(k);
        //方法三:
//        return searchPre(this.getLength() - k + 1);
    }

    // 10. 编写一个代码,将小于 x 的元素放在 x 左边,大于等于 x 的放在右边
    public Node partition(int x) {
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;
        while (cur != null) {
            if (cur.data < x) {
                //尾插
                if (bs == null) {
                    //第一次插入
                    bs = cur;
                    be = cur;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                //尾插
                if (as == null) {
                    // 第一次插入
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if (bs == null) {
            this.head = as;
        }else if (as == null) {
            be.next = null;
            this.head = bs;
        }else {
            be.next = as;
            ae.next = null;
            this.head = bs;
        }
        return this.head;
    }

    // 11. 遍历单链表一次,删除相同的结点
    // eg: 1 2 2 2 12 12 17------> 1 17
    public Node deleteDuplication() {
        Node newHeadListNode = new Node(0);
        Node cur = this.head;
        // 链表中已存在的最后一个节点.
        Node temp = newHeadListNode;
        // 方法一
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            }
            else {
                temp.next = cur;
                temp = cur;
                cur = cur.next;
            }
        }
        temp.next = null;
        // 方法二
//        while (cur != null) {
//            while (cur.next != null && cur.data == cur.next.data) {
//                // 相等往后继续
//                cur = cur.next;
//
//                // 相等的元素超过两个
//                while (cur.next != null && cur.data == cur.next.data) {
//                    cur = cur.next;
//                }
//                // 链表结束并且链表最后的两个元素相同
//                if (cur.next == null ) {
//                    temp.next = null;
//                    this.head = newHeadListNode.next;
//                    return this.head;
//                }
//                cur = cur.next;
//            }
//            temp.next = cur;
//            temp = cur;
//            cur = cur.next;
//        }
        this.head = newHeadListNode.next;
        return  this.head;

    }

    // 12. 判断链表是否为回文序列
    public boolean isPalindromeSequence() {
        if (this.head == null) {
            return false;
        }
        // 方法一
//        int left = 1;
//        int right = getLength();
//        while (left < right && findKthRe(right).data == findKthRe(left).data) {
//            left++;
//            right--;
//        }
//        if (left == right) {
//            return true;
//        }
//        return false;

        // 方法二
        // 1. 找中间结点
        Node middleNode = middleList();
        // 2. 中间结点后的节点反转
        Node pre = null;
        Node cur = middleNode;
        Node next = middleNode.next;
        Node newHead = null;
        while (cur != null) {
            next = cur.next;
            if (next == null) {
                newHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 3. 比较相等
        while (newHead != null) {
            if (newHead.data != this.head.data) {
                return false;
            }
            newHead = newHead.next;
        }
        return true;
    }

    // 13. 合并两个有序列表
    public Node Merge(Node node1, Node node2) {

        while (node1 != null && node2 != null) {

            while (node1 != null) {
                node1 = node1.next;
            }
            while (node2 != null) {
                node2 = node2.next;
            }
        }
        return this.head;
    }

    // 14. 检查 index 位置是否为插入有效位置
    public boolean checkIndex(int index) {
        if (index < 0 || index > this.getLength()) {
            System.out.println("该单链表目前长度为 : " + this.getLength() + ", 插入位置 index = " + index + "有误!");
            return false;
        }
        return true;
    }

    // 15. 找关键字 key 对应节点的前驱结点
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

    // 16. 找 index 结点的前驱结点
    public Node searchPre(int index) {
        Node cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;

    }

    // 17. 计算单链表长度
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

    // 18. 清空单链表
    public void clear() {
        this.head = null;
        //内存泄漏
    }

    // 19. 打印
    public void display() {
        if (this.head == null) {
            System.out.println("单链表无节点");
            return;
        }
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
