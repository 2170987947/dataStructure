package java0314;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/14 14:56
 */
public class Sort {
    // 1. 插入排序
    // 时间复杂度: 最好 O(n)
    //           平均 O(n ^ 2)
    //           最坏 O(n ^ 2)
    // 空间复杂度: O(1)
    public int[] insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int key = arr[i + 1];
            int j = 0;
            for (j = i; j >= 0; j--) {
                if (key < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    private void swap(int[] arr, int max, int i) {
        int temp = arr[max];
        arr[max] = arr[i];
        arr[i] = temp;
    }

    // 2. 选择排序
    // 时间复杂度: 最好/平均/最坏 O(n ^ 2)
    // 空间复杂度: O(1)
    public int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int max = 0;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            swap(arr, max, arr.length - i - 1);
        }
        return arr;
    }
    // 3. 希尔排序
    public int[] hillSort(int[] arr, int gap) {
        while (gap >= 1) {
            for (int i = gap; i < arr.length; i++) {
                int key = arr[i];
                int j = 0;
                for (j = i - gap; j >= 0; j = j - gap) {
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
        return arr;
    }
    // 4. 冒泡排序
    // 时间复杂度: 最好 O(n) ----> 对于一个有序数组
    //           平均 O(n ^ 2) ----> 对于一般数组
    //           最坏 O(n ^ 2) ----> 对于一般数组
    // 空间复杂度: O(1)
    public int[] bubbleSort(int[] arr) {
        boolean isSort = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isSort = false;
                }
            }
            if (isSort = true) {
                return arr;
            }
        }
        return arr;
    }
    // 5. 堆排序
    // 时间复杂度: 最好/平均/最坏 O(nlog(n))
    // 空间复杂度: O(1)
    public int[] heapSort(int[] arr) {
        // 寻找最后一个结点的父节点.
        int index = (arr.length - 1 - 1) / 2;
        for (int i = index; i >= 0; i--) {
            downAdjust(arr, i);
        }
        return arr;
    }
    // 向下调整
    public void downAdjust(int[] arr, int index) {
        int left = index * 2 + 1;
        if (left >= arr.length) {
            // 无孩子
            return;
        }
        // 有左孩子
        int small = left;
        // 有右孩子
        if (left + 1 < arr.length) {
            int right = left + 1;
            if (arr[small] > arr[right]) {
                small = right;
            }
        }

        if (arr[small] > arr[index]) {
            // 不调整
            return;
        } else {
            // 调整
            // 交换
            swap(arr, small, index);
            downAdjust(arr, small);
        }
    }
    // 6. 快速排序
    // 时间复杂度: 最好 O(nlog(n))
    //           平均 O(n ^ 2)
    //           最坏 O(n ^ 2)
    // 空间复杂度: O(1)
    // [start, end) 进行排序
    public void fastSort(int[] arr, int start, int end) {
        // 如果元素只有一个, 则无序排序
        if (end - start <= 1) {
            return;
        }
        // 将 start 下标所指的元素作为基准进行排序
        // 将比 key 小的元素放在 key 前面, 其余放在 key 后.
        int key = arr[start];
        int i = start + 1;
        int j = end - 1;
        while (i <= j) {
            while (i <= j && arr[j] >= key) {
                j--;
            }
            while (i <= j && arr[i] < key) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        // 此时 j 所指的元素为从左到右追后一个比 key 小的元素
        swap(arr, start, j);
        fastSort(arr, start, j);
        fastSort(arr, j + 1, end);
    }
    // 7. 归并排序
    // 时间复杂度: 最好/平均/最坏 O(nlog(n))
    // 空间复杂度: O(1)
    // 对 [start, end) 排序
    public int[] mergeSort(int[] arr, int start, int end) {
        // 如果只有一个元素, 则无序排序
        if (end - start <= 1) {
            return arr;
        }
        int index = (start + end) / 2;
        mergeSort(arr, start, index);
        mergeSort(arr, index, end);
        merge(arr, start, index, end);
        return arr;
    }
    // 合并 [start, index) 和 [index, end) 两断本省已排好序
    public int[] merge(int[] arr, int start, int index, int end) {
        // 临时存放已排好序的元素
        int[] result = new int[end - start];
        int count = 0;
        int i = start;
        int j = index;
        while (i < index && j < end) {
            if (arr[i] <= arr[j]) {
                result[count++] = arr[i++];
            } else {
                result[count++] = arr[j++];
            }
        }
        if (i < index) {
            while (i < index) {
                result[count++] = arr[i++];
            }
        } else {
            while (j < end) {
                result[count++] = arr[j++];
            }
        }
        // 将结果数组搬运回原数组
        for (i = start; i < end; i++) {
            arr[i] = result[i - start];
        }
        return arr;
    }
}
