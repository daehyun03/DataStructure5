package sort;

public class RecursiveQuickSort {

    public static void sort(Comparable [] a) {
        m_pivot_sort(a, 0, a.length - 1);
    }

    private static void m_pivot_sort(Comparable [] a, int low, int high) {
        if(low >= high) {
            return;
        }

        int pivot = partition(a, low, high);

        m_pivot_sort(a, low, pivot);
        m_pivot_sort(a, pivot + 1, high);
    }

    private static int partition(Comparable [] a, int left, int right) {

        int low = left - 1;
        int high = right + 1;
        Comparable pivot = a[(left + right) / 2];

        while(true) {
            do {
                low++;
            } while(a[low].compareTo(pivot) < 0);

            do {
                high--;
            } while(a[high].compareTo(pivot) > 0 && low <= high);

            if(low >= high) {
                return high;
            }
            swap(a, low, high);
        }
    }

    private static void swap(Comparable [] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
