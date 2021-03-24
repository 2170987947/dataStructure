package java0322;

import java.security.PublicKey;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/22 0:18
 */
public class Sort {
    // 1. 插入排序
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (key < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }
    // 2. 希尔排序
    public void shellSort(int[] arr, int gap) {
        while (gap >= 1) {
            for (int i = gap; i < arr.length; i++) {
                int key = arr[i];
                int j = i - gap;
                for (; j >= 0; j -= 7) {
                    if (key < arr[j]) {
                        arr[j + gap] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + gap] = key;
            }
            gap /= 2;
        }
    }
    // 3. 选择排序
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            swap(arr, max, arr.length - i - 1);
        }
    }

    private void swap(int[] arr, int max, int i) {
        int temp = arr[max];
        arr[max] = arr[i];
        arr[i] = temp;
    }
    // 4. 冒泡排序
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+ 1);
                }
            }
        }
    }
    // 5. 堆排序
    public void heapSort(int[] arr, int size) {
        int index = (arr.length - 1 - 1) / 2;
        for (int i = index; i >= 0; i--) {
            shiftDown(arr, size, i);
        }
    }

    private void shiftDown(int[] arr, int size, int index) {
        if (index < 0 || index >= size) {
            return;
        }
        int parent = index;
        int child = 2 * index + 1;
        while (child < size) {
            if (child + 1 < size && arr[child + 1] < arr[child]) {
                child = child + 1;
            }
            if (arr[child] >= arr[parent]) {
                return;
            }
            swap(arr, parent, child);
            parent = child;
            child = 2 * parent + 1;
        }
    }
    // 6. 快速排序
    public void quickSort(int[] arr, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int key = start;
        int i = start;
        int j = end - 1;
        while (i < j) {
            while (i < j && arr[key] <= arr[j]) {
                j--;
            }
            while (i < j && arr[key] >= arr[i]) {
                i++;
            }
                swap(arr, i, j);
        }
        swap(arr, key, j);
        quickSort(arr, start, j);
        quickSort(arr, j + 1, end);
    }
    // 7. 归并排序
    public void mergeSort(int[] arr, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int index = (start + end) / 2;
        mergeSort(arr, start, index);
        mergeSort(arr, index, end);
        merge(arr, start, index, end);
    }
    public void merge(int[] arr, int start, int index, int end) {
        int[] temp = new int[end - start];
        int count = 0;
        int i = start;
        int j = index;
        while (i < index && j < end) {
            if (arr[i] <= arr[j]) {
                temp[count++] = arr[i++];
            } else {
                temp[count++] = arr[j++];
            }
        }
        while (i < index) {
            temp[count++] = arr[i++];
        }
        while (j < end) {
            temp[count++] = arr[j++];
        }
        for (i = start; i < end; i++) {
            arr[i] = temp[i - start];
        }
    }
}
