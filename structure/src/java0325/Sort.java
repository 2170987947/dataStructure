package java0325;


/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/25 12:28
 */
public class Sort {
    // 堆排序
    public void heapSort(int[] arr) {
        createHeap(arr);
        int count = arr.length;
        while (count > 0) {
            swap(arr, count - 1, 0);
            count--;
            shiftDown(arr, count, 0);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void createHeap(int[] arr) {
        int index = (arr.length - 1 - 1) / 2;
        for (int i = index; i >= 0; i--) {
            shiftDown(arr, arr.length, i);
        }
    }

    private void shiftDown(int[] arr, int length, int i) {
        int parent = i;
        int child = 2 * parent + 1;
        while (child < length) {
            if (child + 1 < length && arr[child + 1] > arr[child]) {
                child = child + 1;
            }
            if (arr[child] <= arr[parent]) {
                return;
            } else {
                swap(arr, parent, child);
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    // 快速排序
    public void quickSort(int[] arr) {
        quickSortInternal(arr, 0, arr.length - 1);
    }
    // 对 [start, end] 区间的元素进行排序
    public void quickSortInternal(int[] arr, int start, int end) {
        if (end - start <= 0) {
            return;
        }
        int index = partition(arr, start, end);
        quickSortInternal(arr, start, index - 1);
        quickSortInternal(arr, index + 1, end);
    }
    // 对 [start, end] 区间的元素进行排序
    public int partition(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && arr[j] >= arr[start]) {
                j--;
            }
            while (i < j && arr[i] <= arr[start]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, j, start);
        return j;
    }
}
