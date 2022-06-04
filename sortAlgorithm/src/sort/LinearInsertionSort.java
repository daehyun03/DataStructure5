package sort;

public class LinearInsertionSort {
    public static void sort(Comparable[] a) {
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

    public static boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void swap(Comparable[] array, int index1, int index2) {
        Comparable temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
