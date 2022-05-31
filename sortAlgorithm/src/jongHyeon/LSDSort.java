package jongHyeon;

public class LSDSort {

    public static void sort(Integer[] array) {
        sort(array, 1000);
    }

    public static void sort(Integer[] array, int radix) {
        if (array.length == 0) {
            return;
        }

        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        int exponent = 1;
        while ((maxValue - minValue) / exponent >= 1) {
            LSDSort.countingSortByDigit(array, radix, exponent, minValue);
            exponent *= radix;
        }
    }

    private static void countingSortByDigit(
            Integer[] array, int radix, int digit, int minValue) {
        int bucketIndex;
        int[] buckets = new int[radix];
        int[] output = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            bucketIndex = (int) (((array[i] - minValue) / digit) % radix);
            buckets[bucketIndex]++;
        }

        for (int i = 1; i < radix; i++) {
            buckets[i] += buckets[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            bucketIndex = (int) (((array[i] - minValue) / digit) % radix);
            output[--buckets[bucketIndex]] = array[i];
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }
}
