package daeHwan;

public class NaturalMergeSort {
    private static void merge(Comparable[] arr, Comparable[] target, int low, int mid, int high) {
        int leftPos = low;
        int rightPos = mid;
        int targetPos = low;

        while (leftPos < mid && rightPos < high) {
            Comparable leftValue = arr[leftPos];
            Comparable rightValue = arr[rightPos];

            if (leftValue.compareTo(rightValue) < 0) {
                target[targetPos++] = leftValue;
                leftPos++;
            }
            else {
                target[targetPos++] = rightValue;
                rightPos++;
            }
        }

        while (leftPos < mid) {
            target[targetPos++] = arr[leftPos++];
        }
        while (rightPos < high) {
            target[targetPos++] = arr[rightPos++];
        }
    }

    public static void sort(Comparable[] arr) {
        int arrSize = arr.length;

        Comparable[] tmp = new Comparable[arrSize];
        int[] starts = new int[arrSize + 1];

        int runCount = 0;
        starts[0] = 0;
        for (int i = 1; i <= arrSize; i++) {
            if (i == arrSize || arr[i].compareTo(arr[i - 1]) < 0) {
                starts[++runCount] = i;
            }
        }

        Comparable[] from = arr;
        Comparable[] to = tmp;

        while (runCount > 1) {
            int newRunCount = 0;

            for (int i = 0; i < runCount - 1; i += 2) {
                merge(from, to, starts[i], starts[i + 1], starts[i + 2]);
                starts[newRunCount++] = starts[i];
            }

            if (runCount % 2 == 1) {
                int lastStart = starts[runCount - 1];
                System.arraycopy(from, lastStart, to, lastStart, arrSize - lastStart);
                starts[newRunCount++] = lastStart;
            }

            starts[newRunCount] = arrSize;
            runCount = newRunCount;

            Comparable[] help = from;
            from = to;
            to = help;
        }

        if (from != arr) {
            System.arraycopy(from, 0, arr, 0, arrSize);
        }
    }
}
