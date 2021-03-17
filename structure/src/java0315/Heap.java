package java0315;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/15 9:58
 */
public class Heap {
    // 1. 建小堆
    public int[] buildHeap(int[] arr, int size) {
        // 找到最后一个结点的父节点
        int index  = (size - 1) / 2;
        for (int i = index; i >= 0; i--) {
            downHeap(arr, size, i);
        }
        return arr;
    }
    // 2. 向上调整
    public void upHeap(int[] arr, int size, int index) {
        // 没有此位置的元素
        if (index < 0 || index >= size) {
            return;
        }
        while (true) {
            if (index <= 0) {
                return;
            }
            int parent = (index - 1) / 2;
            if (arr[parent] > arr[index]) {
                swap(arr, parent, index);
            } else {
                // 无需调整
            }
            index = parent;
        }
    }

    private void swap(int[] arr, int parent, int index) {
        int temp = arr[parent];
        arr[parent] = arr[index];
        arr[index] = temp;
    }

    // 3, 向下调整
    public void downHeap(int[] arr, int size, int index) {
        // 没有此位置的元素
        if (index < 0 || index >= size) {
            return;
        }
        while (true) {
            int left = index * 2 + 1;
            // 无孩子, 无需调整
            if (left >= size) {
                return;
            }
            int small = left;
            int right = left + 1;
            if (right < size && arr[right] < arr[left]) {
                small = right;
            }
            if (arr[small] >= arr[index]) {
                return;
            }
            swap(arr, small, index);
            index = small;
        }
    }
    // 插入
    public void insert(int[] arr, int size,  int val) {
        arr[size] = val;
        upHeap(arr, size + 1, size);
    }
    // 删除
    public void remove(int[] arr, int size) {
        swap(arr, 0, size - 1);
        downHeap(arr, size - 1, 0);
    }
}
