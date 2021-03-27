package java0326;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/26 15:03
 */
public class Sort {

    public void mergeSort(int[] arr) {
        mergeSortInternal(arr, 0, arr.length);
    }
    // 递归划分区间, 直到区间有序时, 进行合并
    // 区间中只有一个元素时, 元素是有序的
    // 然后把有序区间进行合并
    // 递归划分 [start, end)区间
    private void mergeSortInternal(int[] arr, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortInternal(arr, start, mid);
        mergeSortInternal(arr, mid, end);
        merge(arr, start, mid, end);
    }
    // 合并两个有序区间 [start, mid) 和 [mid, end)
    private void merge(int[] arr, int start, int mid, int end) {
        if (end - start <= 1) {
            return;
        }
        // 临时用来存放合并好的有序数组
        int[] temp = new int[end - start];
        // 有序数组中的下标.
        int count = 0;
        int i = start;
        int j = mid;
        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                temp[count++] = arr[i++];
            }
            if (arr[i] > arr[j]) {
                temp[count++] = arr[j++];
            }
        }
        while (i < mid) {
            temp[count++] = arr[i++];
        }
        while (j < end) {
            temp[count++] = arr[j++];
        }
        // 合并好之后, 将有序数组搬回原数组的位置.
        for (i = start; i < end; i++) {
            arr[i] = temp[i - start];
        }
    }
}
