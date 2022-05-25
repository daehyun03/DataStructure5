package jongHyeon;

public class MedianOfThreeQuickSort {
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
        int mid = (low + high) / 2;
        setPivot(a, low, mid, high);

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

    public static void setPivot(Comparable[] a, int low, int mid, int high) {
        if(a[low].compareTo(a[mid]) >= 0) {
            if(a[mid].compareTo(a[high]) >= 0) {
                swap(a, low, mid);
            }
            else if(a[low].compareTo(a[high]) <= 0) {

            }
            else {
                swap(a, low, mid);
            }
        }
        else if(a[high].compareTo(a[low]) < 0) {

        }
        else if(a[mid].compareTo(a[high]) > 0) {
            swap(a, low, high);
        }
        else {
            swap(a, low, mid);
        }
    }
}
