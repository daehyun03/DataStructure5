package sort;

public class BubbleSort {
    public static void sort(Comparable[] arr) {
        int arrLength = arr.length;

        for ( int i = 0; i < arrLength; i++ ) {
            for ( int j = i+1; j < arrLength; j++ ) {
                if ( arr[i].compareTo(arr[j]) > 0 ) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(Comparable[] arr, int idx1, int idx2) {
        Comparable temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
