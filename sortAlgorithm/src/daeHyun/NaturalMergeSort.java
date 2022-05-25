package daeHyun;

public class NaturalMergeSort {

    public static void sort(Comparable[] arr) {
        Comparable[] tempArr = new Comparable[arr.length];
        int idx = 0;
        while ( idx < arr.length-1 ) {
            if ( arr[idx].compareTo(arr[idx + 1]) > 0 ) {
                break;
            }
            idx++;
        }
        sort(arr, tempArr, idx);
    }

    private static void sort(Comparable[] arr, Comparable[] tempArr, int mid) {
        int high = 0;
        while ( !(high == arr.length-1) ) {
            high = mid+1;
            while ( high < arr.length-1 ) {
                if ( arr[high].compareTo(arr[high + 1]) > 0 ) {
                    break;
                }
                high++;
            }
            merge(arr, tempArr, 0, mid, high);
            mid = high;
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
