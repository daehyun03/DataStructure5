package minJun;

import java.lang.Comparable;

public class InsertionSort {
    public static void sortLinear(Comparable[] a) {
        int arrayLength = a.length;
        for (int i = 1; i < arrayLength; i++) {
            for (int j = i; j > 0; j--) {
                if (isLess( a[j], a[j-1]) ) {
                    swap(a, j, j-1);
                }
                else break;
            }
        }
    }

    public static void sortBinary(Comparable[] arr) {
        int size = 1;
        int targetIdx;

        for (int i = 1; i < arr.length; i++) {
            targetIdx = binarySearch(arr, arr[i], size++);
            for(int j = i; targetIdx < j; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    public static int binarySearch(Comparable[] arr, Comparable key, int high) {
        int low = 0;
        int mid = 0;

        while(low < high) {
            mid = (low + high) / 2;

            if (key.compareTo(arr[mid]) < 0) {
                high = mid;
            } else {
                low = mid + 1;
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
