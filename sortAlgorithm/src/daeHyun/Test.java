package daeHyun;

import daeHwan.HeapSort;
import daeHwan.RecursiveMergeSort;
import main.RandomArrayCreator;
import minJun.InsertionSort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        for ( int i = 1; i < 10001; i = i*10) {
            Integer[] arr = RandomArrayCreator.intArr(i);
            long beforeTime = System.nanoTime();
            RecursiveMergeSort.sort(arr);
            long afterTime = System.nanoTime();
            double time = (double)(afterTime - beforeTime)/1000000;
            System.out.println(i + " time : " + time);
        }
    }
}
