package minJun;

import main.RandomArrayCreator;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = RandomArrayCreator.intArr(20);

        InsertionSort.sortLinear(arr);

        System.out.print(Arrays.toString(arr) + "\n");

        String[] arr2 = RandomArrayCreator.strArr(20);

        InsertionSort.sortBinary(arr2);

        System.out.print(Arrays.toString(arr2) + "\n");

        Integer[] arr3 = RandomArrayCreator.intArr(20);

        InsertionSort.sortBinary(arr3);

        System.out.print(Arrays.toString(arr3) + "\n");

    }
}
