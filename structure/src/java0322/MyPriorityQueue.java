package java0322;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/21 23:59
 */
public class MyPriorityQueue {
    public int arr[];
    public int size;
    public int capacity;

    public MyPriorityQueue(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
    }

    public void shiftDown(int index) {
        if (index< 0 || index >= size) {
            return;
        }
        int parent = index;
        int child = parent * 2 + 1;
        while (child < size) {
            if (child + 1 < size && arr[child + 1] < arr[child]) {
                child = child + 1;
            }
            if (arr[child] >= arr[parent]) {
                return;
            }
            swap(child, parent);
            parent = child;
            child = parent * 2 + 1;
        }
    }

    private void swap(int child, int parent) {
        int temp = arr[child];
        arr[child] = arr[parent];
        arr[parent] = temp;
    }

    public void shiftUp(int index) {
        if (index <= 0 || index >= size) {
            return;
        }
        int child = index;
        int parent = (index - 1) / 2;
        while (parent >= 0) {
            if (arr[parent] < arr[child]) {
                swap(parent,child);
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public void build(int size) {
        int index = (size - 1) / 2;
        for (int i = index; i >=0; i++) {
            shiftDown(i);
        }
    }

    public void insert(char val) {
        arr[size] = val;
        size++;
        shiftUp(size - 1);
    }

    public void delete() {
        swap(0, size - 1);
        size--;
        shiftDown(0);
    }
}
