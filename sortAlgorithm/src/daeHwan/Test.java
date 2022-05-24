package daeHwan;

import main.RandomArrayCreator;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = RandomArrayCreator.intArr(100);
        RecursiveMergeSort.sort(arr);

        System.out.print(Arrays.toString(arr));
    }
}