package sort;

public class ShellSort {
    public static void sort(Comparable[] array) {
        int h = 4;
        while (h >= 1) {
            for ( int i = h; i < array.length; i++ ) {
                for ( int j = i; j >= h && isLess(array[j], array[j-h]); j -=h ) {
                    swap(array, j, j-h);
                }
            }
            h /= 2;
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
