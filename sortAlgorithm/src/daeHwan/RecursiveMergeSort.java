package daeHwan;

public class RecursiveMergeSort {
    public static void sort(Comparable[] arr) {
        Comparable[] tempArr = new Comparable[arr.length];
        mergeSort(arr, tempArr, 0, arr.length - 1);
    }

    private static void mergeSort(Comparable[] arr, Comparable[] tempArr, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(arr, tempArr, low, mid);
        mergeSort(arr, tempArr, mid + 1, high);
        merge(arr, tempArr, low, mid, high);
    }

    protected static void merge(Comparable[] arr, Comparable[] tempArr, int low, int mid, int high) {
        int idx1 = low;
        int idx2 = mid + 1;

        int tempIdx = low;
        while (idx1 <= mid && idx2 <= high) {
            if (arr[idx1].compareTo(arr[idx2]) <= 0)
                tempArr[tempIdx++] = arr[idx1++];
            else
                tempArr[tempIdx++] = arr[idx2++];
        }

        while (idx1 <= mid) {
            tempArr[tempIdx++] = arr[idx1++];
        }
        while (idx2 <= high) {
            tempArr[tempIdx++] = arr[idx2++];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = tempArr[i];
        }
    }
}