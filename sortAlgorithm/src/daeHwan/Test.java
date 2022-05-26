package daeHwan;

import daeHyun.BottomUpMergeSort;
import main.RandomArrayCreator;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {
        Integer[] arr = RandomArrayCreator.intArr(10);
        BottomUpMergeSort.sort(arr);

        System.out.print("after : " + Arrays.toString(arr));
    }
}