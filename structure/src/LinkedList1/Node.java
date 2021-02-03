package LinkedList1;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/1/29 1:11
 */
public class Node<E> {
    public E data;
    public Node<E> next;

    public Node() {

    }

    public Node(E data) {
        this.data = data;
    }
}
