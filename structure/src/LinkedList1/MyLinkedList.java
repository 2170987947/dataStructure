package LinkedList1;


public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    // 1. 增添
    // a. 末尾增加
    public boolean add(E data) {
        // 链表没有元素时添加
        if (this.head == null) {
            this.head = new Node<>(data);
            this.tail = this.head;
            this.size++;
            return true;
        }
        // 链表中有元素
        this.tail.next = new Node<>(data);
        this.tail = this.tail.next;
        this.size++;
        return true;
    }
    // b. 指定位置增添
    public void add(int index, E data) {
        // 链表没有元素时, 在 0 下标插入元素
        if (this.head == null && index == 0) {
            this.head = new Node<>(data);
            this.tail = this.head;
            this.size++;
            return;
        }
        Node<E> node = this.head;
        int i = 0;
        // 找插入点前一个结点
        while (i < index - 1 && node != null) {
            node = node.next;
            i++;
        }
        // 找到前一个结点, 并且该节点不为空,进行插入操作
        if (i == index - 1 && node != null && node.next != null) {
            Node<E> node1 = new Node<>(data);
            node1.next = node.next;
            node.next = node1;
            this.size++;
        } else if (i == index - 1 && node != null && node.next == null) {
            Node<E> node1 = new Node<>(data);
            node1.next = node.next;
            node.next = node1;
            this.tail = node1;
            this.size++;
        } else {
            System.out.println("插入失败");
            return;
        }
    }
    // 2. 删除
    // a. 删除指定下标的结点
    public E remove(int index) {
        // 链表无结点
        if (this.head == null) {
            return null;
        }
        // 删除第一个结点
        if (index == 0) {
            Node<E> temp = this.head;
            this.head = this.head.next;
            return temp.data;
        }
        Node<E> node = this.head;
        int i = 0;
        // 找前驱
        while (i < index - 1 && node.next != null) {
            node = node.next;
            i++;
        }
        // 删除最后一个结点: 尾结点改变
        if (i == index - 1 && node.next != null && node.next.next == null) {
            Node<E> temp = node.next;
            node.next = node.next.next;
            this.tail = node.next;
            return temp.data;
        } else if (i == index - 1 && node.next != null && node.next.next != null) {
            // 删除中间元素
            Node<E> temp = node.next;
            node.next = node.next.next;
            this.tail = node.next;
            return node.data;
        } else {
            System.out.println("删除失败");
            return null;
        }
    }
    // b. 删除第一个与关键字 key 匹配的结点
    public boolean remove(E key) {
        if (this.head == null) {
            return false;
        }
        // 删除第一个结点
        if (this.head.data == key) {
            if (this.head.next == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
            }
            return true;
        }
        Node<E> node = this.head;
        // 删除其余结点
        while (node.next != null) {
            if (node.next.data == key) {
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }
    // c. 删除所有与关键字 key 匹配的结点
    public boolean removeAll(E key) {
        if (this.head == null) {
            return false;
        }
        Node<E> pre = this.head;
        Node<E> cur = this.head.next;
        // 删除一般结点: 头结点之后的节点是要删除的结点
        while (cur != null) {
            if (cur.data == key) {
                pre.next = pre.next.next;
                cur =  pre.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        // 删除头结点: 头结点是需要删除节点的情况
        if (this.head.data == key) {
            this.head = this.head.next;
            return true;
        }
        return false;
    }
    // 3. 更新
    public boolean set(int index, E data) {
        // 链表为空
        if (this.head == null) {
            return false;
        }
        Node<E> node = this.head;
        int i = 0;
        for (; i < index && node.next != null; i++) {
            node = node.next;
        }
        if (i == index) {
            node.data = data;
            return true;
        } else {
            return false;
        }
    }
    // 4. 查找
    // a. 根据下标找元素
    public E get(int index) {
        if (this.head == null) {
            return null;
        }
        Node<E> cur = this.head;
        int i  = 0;
        while (i < index && cur != null) {
            cur = cur.next;
            i++;
        }
        if (i == index && cur != null) {
            return cur.data;
        }
        return null;
    }
    // b. 根据元素找下标
    public int indexOf(E key) {
        Node<E> cur = this.head;
        int i = 0;
        while (cur != null && cur.data != key) {
            cur = cur.next;
            i++;
        }
        if (cur.data == key) {
            return i;
        }
        return -1;
    }
    // 5. 查找是否包含关键字 key 的结点
    public boolean contains(E key) {
        Node<E> cur = this.head;
        while (cur != null && cur.data != key) {
            cur = cur.next;
        }
        if (cur.data == key) {
            return true;
        }
        return false;
    }
    // 6. 判断是否为空链表
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }
    // 7. 清空
    public void clear() {
        this.head = null;
        this.tail = null;
    }
    // 8. 显示
    public void display() {
        Node<E> node = this.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    // 9. 返回长度
    public int size() {
        return this.size;
    }
    // 10. 反转
    public void reverse() {
        if (this.head == null) {
            return;
        }
        Node<E> pre = null;
        Node<E> cur = this.head;
        Node<E> next;
        while (cur != null) {
            next = cur.next;
            if (cur.next == null) {
                this.head = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
    // 11. 找倒数第 K 个结点
    public Node<E> findKthRe(int k) {
        Node<E> fast = this.head;
        if (k <= 0) {
            return null;
        }
        int i = 0;
        while (i < k && fast != null) {
            fast = fast.next;
            i++;
        }
        Node<E> slow = this.head;
        if (i == k) {
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        } else {
            return null;
        }
    }
    // 12. 找中间节点
    // slow 走一步; fast 走两步.
    // 当 fast 走到 null 时, slow 就是中间节点.
    // 该思路如果中间结点有两个, 则返回偏后面的节点.
    // eg: 1, 2, 3, 4 =====> 3
    public Node<E> middleNode() {
        Node<E> slow = this.head;
        Node<E> fast = this.head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // 13. 判断是否为回文序列
    public boolean isPalindromeSequence() {
        // 保存原有链表: 防止逆序时改变原有结点
        Node<E> node = this.head;
        // ① 找中间结点
        Node<E> slow = this.head;
        Node<E> fast = this.head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // ② 中间节点之后的结点逆序
        Node pre = null;
        Node<E> cur = slow;
        Node<E> next = slow.next;
        Node<E> newHead2 = slow;
        while (cur != null) {
            next = cur.next;
            if (next == null) {
                newHead2 = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // ③ 判断相等
        Node<E> newHead1 = this.head;
        while (newHead2 != null && newHead1.data == newHead2.data) {
            newHead1 = newHead1.next;
            newHead2 = newHead2.next;
        }
        if (newHead2 != null) {
            return false;
        }
        return true;
    }
    // 14. 遍历单链表一次,删除相同的结点
    // eg: 1 2 2 2 12 12 17------> 1 17
    public Node<E> deleteDuplication() {
        Node<E> newHead = new Node(0);
        newHead.next = this.head;
        Node<E> pre = newHead;
        Node<E> cur = this.head;
        while (cur != null && cur.next !=null) {
            if (cur.data == cur.next.data) {
                while (cur != null && cur.next !=null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                if (cur == null || cur.next == null) {

                }
                cur = cur.next;
            } else {
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
            }
        }
    }
}
