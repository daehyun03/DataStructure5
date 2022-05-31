package sort;

public class RecursiveQuickSort {

    public static void sort(Comparable[] a) {
        int low = 0;
        int high = a.length - 1;
        sort(a, low, high);
    }

    public static void sort(Comparable[] a, int low, int high) {
        if(high <= low) { return; }
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }


    public static int partition(Comparable[] a, int low, int high) {
        int pivot = low;
        Comparable standard = a[pivot];
        int i = low + 1;
        int j = high;
        while(true) {
            while(i < high && standard.compareTo(a[i]) >= 0) { i++; }
            while(j > low && standard.compareTo(a[j]) < 0) { j--; }
            if(i >= j) break;
            swap(a, i, j);
        }
        swap(a, pivot, j);
        return j;
    }
    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
