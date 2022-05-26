package jongHyeon;

public class CountingSort {
    public static void sort(int [] a) {
        int [] count = new int [10];
        int [] sort = new int [a.length];

        for(int i = 0; i < count.length; i++) {
            count[i] = 0;
        }

        for(int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }

        for(int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        for(int i = a.length - 1; i >= 0; i--) {
            sort[count[a[i]]-1] = a[i];
            count[a[i]]--;
        }

        for(int i = 0; i < a.length; i++) {
            a[i] = sort[i];
        }
    }
}
