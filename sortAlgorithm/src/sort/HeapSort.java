package sort;

public class HeapSort {
    public static void sort(Comparable[] arr) {
        int size = arr.length - 1;

        for (int i = size / 2; i >= 0; i--) {
            downHeap(arr, i, size);
        }
        while (size > 0) {
            swap(arr, 0, size--);
            downHeap(arr, 0, size);
        }
    }

    private static void downHeap(Comparable[] arr, int target, int size) {
        while (target * 2 + 1 <= size) {
            int bigChild = target * 2 + 1;

            if (bigChild < size && isLess(arr[bigChild], arr[bigChild + 1])) {
                bigChild++;
            }
            if (!isLess(arr[target], arr[bigChild])) {
                break;
            }

            swap(arr, target, bigChild);
            target = bigChild;
        }
    }

    private static boolean isLess(Comparable e1, Comparable e2) {
        return e1.compareTo(e2) < 0;
    }

    private static void swap(Comparable[] arr, int idx1, int idx2) {
        Comparable temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
