package daeHwan;

import main.RandomArrayCreator;
import sort.IterativeMergeSort;

import java.util.Arrays;


public class Test {
    public static void main(String[] args) throws InterruptedException {
        int size = 10;

        Integer[] arr1 = RandomArrayCreator.intArr(size);
        System.out.println(Arrays.toString(arr1));

        IterativeMergeSort.sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}