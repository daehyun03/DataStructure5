package jongHyeon;

import java.util.Arrays;

public class Test {
    public static void main(String...args) {
        int [] arr = {1, 3, 5, 7, 2, 6, 9, 0};
        CountingSort.sort(arr);

        System.out.print(Arrays.toString(arr));
    }
}
