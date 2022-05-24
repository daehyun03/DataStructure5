package daeHwan;

import main.RandomArrayCreator;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[] arr = RandomArrayCreator.strArr(100);
        HeapSort.sort(arr);

        System.out.print(Arrays.toString(arr));
    }
}