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
