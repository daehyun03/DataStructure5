package minJun;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = {40, 60, 70, 50, 10, 30, 20};

        InsertionSort.sortLinear(arr);

        System.out.print(Arrays.toString(arr) + "\n");

        Integer[] arr2 = {40, 60, 70, 50, 10, 30, 20};

        InsertionSort.sortBinary(arr2);

        System.out.print(Arrays.toString(arr2) + "\n");

    }
}
