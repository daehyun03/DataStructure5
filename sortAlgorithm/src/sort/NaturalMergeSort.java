package sort;

public class NaturalMergeSort {
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

    public static void sort(Comparable[] arr) {
        int arrSize = arr.length;

        Comparable[] from = arr;
        Comparable[] to = new Comparable[arrSize];
        int[] starts = new int[arrSize + 1];

        int runCount = 0;
        starts[0] = 0;
        for (int i = 1; i <= arrSize; i++) {
            if (i == arrSize || arr[i - 1].compareTo(arr[i]) > 0) {
                starts[++runCount] = i;
            }
        }

        while (runCount > 1) {
            int newRunCount = 0;

            for (int i = 0; i < runCount - 1; i += 2) {
                merge(from, to, starts[i], starts[i + 1], starts[i + 2]);
                starts[newRunCount++] = starts[i];
            }

            if ((runCount & 1) == 1) {
                int lastStart = starts[runCount - 1];
                System.arraycopy(from, lastStart, to, lastStart, arrSize - lastStart);
                starts[newRunCount++] = lastStart;
            }

            starts[newRunCount] = arrSize;
            runCount = newRunCount;

            Comparable[] temp = from;
            from = to;
            to = temp;
        }

        if (from != arr) {
            System.arraycopy(from, 0, arr, 0, arrSize);
        }
    }
}