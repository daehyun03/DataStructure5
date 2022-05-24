package daeHyun;

import main.RandomArrayCreator;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = RandomArrayCreator.intArr(50);
        System.out.println("before : " + Arrays.toString(arr));

        BubbleSort.sort(arr);
        System.out.print("after : " + Arrays.toString(arr));
    }
}
