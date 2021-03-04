package LinkedList2;

import LinkedList2.iml.Deque;

import java.sql.PreparedStatement;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/4 12:53
 */
public class LinkedList implements Deque {
    private static class Node {
        private Integer val;
        Node previous;
        Node next;

        Node(Integer cal) {
            this.val = val;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    @Override
    public boolean offerFirst(Integer e) {
        if (this.size == 0) {
            this.head = this.tail = new Node(e);
        } else {
            Node temp = new Node(e);
            this.head.previous = temp;
            temp.next = this.head;
            this.head = temp;
        }
        this.size++;
        return true;
    }

    @Override
    public Integer peekFirst() {
        if (this.size == 0) {
            return null;
        }
        return this.head.val;
    }

    @Override
    public Integer pollFirst() {
        if (this.size == 0) {
            return null;
        }
        Integer e = this.head.val;
        this.head = this.head.next;
        if (this.head != null) {
            this.head.previous = null;
        } else {
            this.tail = null;
        }
        this.size--;
        return e;
    }

    @Override
    public boolean offerLast(Integer e) {
        if (this.size == 0) {
            this.head = new Node(e);
            this.tail = this.head;
        } else {
            Node temp = new Node(e);
            temp.previous = this.tail;
            this.tail.next = temp;
            this.tail = temp;
        }
        this.size++;
        return true;
    }

    @Override
    public Integer peekLast() {
        if (this.size == 0) {
            return null;
        }
        return this.tail.val;
    }

    @Override
    public Integer pollLast() {
        if (this.size == 0) {
            return null;
        }
        Integer e = this.tail.val;
        this.tail = this.tail.previous;
        if (this.tail != null) {
            this.tail.next = null;
        } else {
            this.head = null;
        }
        this.size--;
        return e;
    }
}
