package sort;

public class InsertionSort {
    public static void sortLinear(Comparable[] a) {
        int arrayLength = a.length;
        for (int i = 1; i < arrayLength; i++) {
            for (int j = i; j > 0; j--) {
                if ( isLess( a[j], a[j-1]) ) {
                    swap(a, j, j-1);
                }
                else break;
            }
        }
    }

    public static void sortBinary(Comparable[] arr) {
        int targetIdx;
        for (int i = 1; i < arr.length; i++) {
            targetIdx = binarySearch(arr, arr[i], i);
            for(int j = i; targetIdx < j; j--) {
                if ( isLess( arr[j], arr[j-1]) ) {
                    swap(arr, j, j-1);
                }
            }
        }
    }

    public static int binarySearch(Comparable[] arr, Comparable key, int high) {
        int mid = 0;
        int low = 0;

        while (low < high) {
            mid = (low + high) / 2;

            if (isLess(arr[mid], key)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public static boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void swap(Comparable[] array, int index1, int index2) {
        Comparable temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
