package sort;

public class SelectionSort {
    public static void sort(Comparable[] arr) {
        int arrLength = arr.length;

        for ( int i = 0; i < arrLength; i++ ) {
            for ( int j = i+1; j < arrLength; j++ ) {
                int minidx = i;
                if ( isLess(arr[j], arr[minidx]) ) {
                    minidx = j;
                }
                swap(arr, i, minidx);
            }
        }
    }

    private static boolean isLess(Comparable e1, Comparable e2) {
        return ( e1.compareTo(e2) < 0 );
    }

    private static void swap(Comparable[] arr, int idx1, int idx2) {
        Comparable temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}
