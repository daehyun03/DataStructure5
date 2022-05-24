package daeHwan;

public class RecursiveMergeSort {
    public static void sort(Comparable[] arr) {
        Comparable[] tempArr = new Comparable[arr.length];
        mergeSort(arr, tempArr, 0, arr.length - 1);
    }

    private static void merge(Comparable[] arr, Comparable[] tempArr, int low, int mid, int high) {
        int idx1 = low;
        int idx2 = mid + 1;

        for (int i = low; i <= high; i++) {
            if (idx1 > mid) {
                for (int j = idx2; j <= high; j++) {
                    tempArr[i++] = arr[j];
                }
            }
            else if (idx2 > high) {
                for (int j = idx1; j <= mid; j++) {
                    tempArr[i++] = arr[j];
                }
            }
            else if (isLess(arr[idx2], arr[idx1])) {
                tempArr[i] = arr[idx2++];
            }
            else {
                tempArr[i] = arr[idx1++];
            }
        }

        for (int i = low; i <= high; i++) {
            arr[i] = tempArr[i];
        }
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

    private static boolean isLess(Comparable e1, Comparable e2) {
        return e1.compareTo(e2) < 0;
    }
}