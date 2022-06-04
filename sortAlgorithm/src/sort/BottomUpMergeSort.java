package sort;

public class BottomUpMergeSort {
    public static void sort(Comparable[] arr) {
        int arrSize = arr.length;

        Comparable[] from = arr;
        Comparable[] to = new Comparable[arrSize];

        for (int size = 1; size < arrSize; size *= 2) {
            for (int low = 0; low + size <= arrSize; low += size*2) {
                merge(from, to, low, low + size, Math.min(low + 2 * size, arrSize));
            }

            Comparable[] temp = from;
            from = to;
            to = temp;
        }

        if (from != arr) {
            System.arraycopy(from, 0, arr, 0, arrSize);
        }
    }

    private static void merge(Comparable[] arr, Comparable[] tempArr, int low, int mid, int high) {
        int idx1 = low;
        int idx2 = mid;
        int tempIdx = low;

        while (idx1 < mid && idx2 < high) {
            if (arr[idx1].compareTo(arr[idx2]) < 0) {
                tempArr[tempIdx++] = arr[idx1++];
            }
            else {
                tempArr[tempIdx++] = arr[idx2++];
            }
        }

        while (idx1 < mid) {
            tempArr[tempIdx++] = arr[idx1++];
        }
        while (idx2 < high) {
            tempArr[tempIdx++] = arr[idx2++];
        }
    }
}
