package daeHwan;

public class NaturalMergeSort {
    public static void sort(Comparable[] arr) {
        Comparable[] tempArr = new Comparable[arr.length];
        Queue<Integer> queue = new Queue<Integer>();
        int size = 1;
        int idx = 0;

        while (idx < arr.length) {
            idx++;
            while (idx < arr.length) {
                if ( arr[idx - 1].compareTo(arr[idx]) > 0 ) {
                    break;
                }
                size++;
                idx++;
            }
            queue.enqueue(size);
            size = 1;
        }

        sort(arr, tempArr, queue);
    }

    public static void sort(Comparable[] arr, Comparable[] tempArr, Queue<Integer> queue) {
        int low = 0;
        int mid;
        int high;

        while(queue.size() != 1) {
            mid = low + queue.dequeue() - 1;
            high = mid + queue.dequeue();

            merge(arr, tempArr, low, mid, high);
            queue.enqueue(high - low + 1);

            low = high + 1;


            if (low == arr.length) {
                low = 0;
            }
            else if (low + queue.peek() >= arr.length) {
                queue.enqueue(queue.dequeue());
                low = 0;
            }
        }
    }

    private static void merge(Comparable[] arr, Comparable[] tempArr, int low, int mid, int high) {
        int idx1 = low;
        int idx2 = mid + 1;

        int tempIdx = low;
        while (idx1 <= mid && idx2 <= high) {
            if (arr[idx1].compareTo(arr[idx2]) <= 0)
                tempArr[tempIdx++] = arr[idx1++];
            else
                tempArr[tempIdx++] = arr[idx2++];
        }

        while (idx1 <= mid) {
            tempArr[tempIdx++] = arr[idx1++];
        }
        while (idx2 <= high) {
            tempArr[tempIdx++] = arr[idx2++];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = tempArr[i];
        }
    }
}
