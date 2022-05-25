package daeHyun;

public class BottomUpMergeSort {

    public static void sort(Comparable[] arr) {
        Comparable[] tempArr = new Comparable[arr.length];
        int high = arr.length - 1;
        for ( int size = 1; size < arr.length; size = size*2 ) {
            for ( int low = 0; low < high; low = low + size*2 ) {
                merge(arr, tempArr, low, Math.min(low+size-1,high), Math.min(low+size*2-1,high));
            }
        }
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

    private static boolean isLess(Comparable e1, Comparable e2) {
        return e1.compareTo(e2) < 0;
    }
}
