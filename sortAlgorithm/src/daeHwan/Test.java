package daeHwan;

import main.RandomArrayCreator;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception{
        Integer[] arr = RandomArrayCreator.intArr(10);
        RecursiveMergeSort.sort(arr);

        System.out.print("after : " + Arrays.toString(arr));

        //test
    }
}