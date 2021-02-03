package LinkedList1;


public class MyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    // 1. 增添
    // a. 末尾增加
    public boolean add(E data) {
        // 链表没有元素时添加
        if (this.first == null) {
            this.first = new Node<>(data);
            this.last = this.first;
            this.size++;
            return true;
        }
        // 链表中有元素
        this.last.next = new Node<>(data);
        this.last = this.last.next;
        this.size++;
        return true;
    }
    // b. 指定位置增添
    public void add(int index, E data) {
        // 链表没有元素时, 在 0 下标插入元素
        if (this.first == null && index == 0) {
            this.first = new Node<>(data);
            this.last = this.first;
            this.size++;
            return;
        }
        Node<E> node = this.first;
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
            this.last = node1;
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
        if (this.first == null) {
            return null;
        }
        // 删除第一个结点
        if (index == 0) {
            Node<E> temp = this.first;
            this.first = this.first.next;
            return temp.data;
        }
        Node<E> node = this.first;
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
            this.last = node.next;
            return temp.data;
        } else if (i == index - 1 && node.next != null && node.next.next != null) {
            // 删除中间元素
            Node<E> temp = node.next;
            node.next = node.next.next;
            this.last = node.next;
            return node.data;
        } else {
            System.out.println("删除失败");
            return null;
        }
    }
    // b. 删除第一个与关键字 key 匹配的结点
    public boolean remove(E key) {
        if (this.first == null) {
            return false;
        }
        // 删除第一个结点
        if (this.first.data == key) {
            if (this.first.next == null) {
                this.first = null;
                this.last = null;
            } else {
                this.first = this.first.next;
            }
            return true;
        }
        Node<E> node = this.first;
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
        return true;
    }
    // 更新
    public boolean set(int index, E data) {
        // 链表为空
        if (this.first == null) {
            return false;
        }
        Node<E> node = this.first;
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
    // 显示
    public void display() {
        Node<E> node = this.first;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    // 返回长度
    public int size() {
        return this.size;
    }
}
