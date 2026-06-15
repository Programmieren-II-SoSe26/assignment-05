package MultiThreadedMergeSort;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        mergeSortRecursive(arr, 0, arr.length - 1);
    }

    static void mergeSortRecursive(int[] arr, int left, int right) {
        // TODO (a): Implementieren Sie die rekursive Zerlegung

    }

    static void merge(int[] arr, int[] temp, int start, int mid, int end) {
        System.arraycopy(arr, start, temp, start, end - start);

        int i = start, j = mid, k = start;
        while (i < mid && j < end) {
            arr[k++] = (temp[i] <= temp[j]) ? temp[i++] : temp[j++];
        }

        while (i < mid) arr[k++] = temp[i++];
        while (j <= end) arr[k++] = temp[j++];
    }
}