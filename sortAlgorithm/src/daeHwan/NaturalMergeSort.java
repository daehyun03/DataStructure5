package daeHwan;

public class NaturalMergeSort {
    private static void merge(Comparable[] arr, Comparable[] target, int startLeft, int startRight, int endRight) {
        int leftPos = startLeft;
        int rightPos = startRight;
        int targetPos = startLeft;

        while (leftPos < startRight && rightPos < endRight) {
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

        while (leftPos < startRight) {
            target[targetPos++] = arr[leftPos++];
        }
        while (rightPos < endRight) {
            target[targetPos++] = arr[rightPos++];
        }
    }

    public static void sort(Comparable[] arr) {
        int numElements = arr.length;

        Comparable[] tmp = new Comparable[numElements];
        int[] starts = new int[numElements + 1];

        int runCount = 0;
        starts[0] = 0;
        for (int i = 1; i <= numElements; i++) {
            if (i == numElements || arr[i].compareTo(arr[i - 1]) < 0) {
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
                System.arraycopy(from, lastStart, to, lastStart, numElements - lastStart);
                starts[newRunCount++] = lastStart;
            }

            starts[newRunCount] = numElements;
            runCount = newRunCount;

            Comparable[] help = from;
            from = to;
            to = help;
        }

        if (from != arr) {
            System.arraycopy(from, 0, arr, 0, numElements);
        }
    }
}
