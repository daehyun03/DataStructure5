package daeHwan;

public class RecursiveMergeSort {
    public static void sort(Comparable[] arr) {
        Comparable[] tempArr = new Comparable[arr.length];
        sort(arr, tempArr, 0, arr.length - 1);
    }

    private static void merge(Comparable[] arr, Comparable[] tempArr, int low, int mid, int high) {
        int idx1 = low;
        int idx2 = mid + 1;

        for (int i = low; i <= high; i++) {
            if (isLess(arr[idx1], arr[idx2])) {

            }
        }
        for (int i = low; i <= high; i++) {
            arr[i] = tempArr[i];
        }
    }

    private static void sort(Comparable[] arr, Comparable[] tempArr, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        sort(arr, tempArr, low, mid);
        sort(arr, tempArr, mid + 1, high);
        merge(arr, tempArr, low, mid, high);
    }

    private static boolean isLess(Comparable e1, Comparable e2) {
        return e1.compareTo(e2) < 0;
    }
}
