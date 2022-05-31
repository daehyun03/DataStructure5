package daeHyun;

import sort.NaturalMergeSort;
import sort.RecursiveMergeSort;
import main.RandomArrayCreator;
import sort.BottomUpMergeSort;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        System.out.println("Integer Type");
        System.out.println("arr len         R             up            down\tMerge");
        for ( int i = 1000000; i > 0; i = i/10) {
            Integer[] arr = RandomArrayCreator.intArr(i);

            long beforeTime = System.nanoTime();
            RecursiveMergeSort.sort(arr);
            long afterTime = System.nanoTime();

            long beforeTime2 = System.nanoTime();
            RecursiveMergeSort.sort(arr);
            long afterTime2 = System.nanoTime();

            Arrays.sort(arr, Comparator.reverseOrder());

            long beforeTime3 = System.nanoTime();
            RecursiveMergeSort.sort(arr);
            long afterTime3 = System.nanoTime();


            double time = (double)(afterTime - beforeTime)/1000000;
            double time2 = (double)(afterTime2 - beforeTime2)/1000000;
            double time3 = (double)(afterTime3 - beforeTime3)/1000000;
            System.out.printf("%-8d time : %f\t%f\t%f\n", i, time, time2, time3);
        }

        System.out.println("arr len         R             up            down\tBottomUpMerge");
        for ( int i = 1000000; i > 0; i = i/10) {
            Integer[] arr = RandomArrayCreator.intArr(i);

            long beforeTime = System.nanoTime();
            BottomUpMergeSort.sort(arr);
            long afterTime = System.nanoTime();

            long beforeTime2 = System.nanoTime();
            BottomUpMergeSort.sort(arr);
            long afterTime2 = System.nanoTime();

            Arrays.sort(arr, Comparator.reverseOrder());

            long beforeTime3 = System.nanoTime();
            BottomUpMergeSort.sort(arr);
            long afterTime3 = System.nanoTime();


            double time = (double)(afterTime - beforeTime)/1000000;
            double time2 = (double)(afterTime2 - beforeTime2)/1000000;
            double time3 = (double)(afterTime3 - beforeTime3)/1000000;
            System.out.printf("%-8d time : %f\t%f\t%f\n", i, time, time2, time3);
        }

        System.out.println("arr len         R             up            down\tNaturalMerge");
        for ( int i = 1000000; i > 0; i = i/10) {
            Integer[] arr = RandomArrayCreator.intArr(i);

            long beforeTime = System.nanoTime();
            NaturalMergeSort.sort(arr);
            long afterTime = System.nanoTime();

            long beforeTime2 = System.nanoTime();
            NaturalMergeSort.sort(arr);
            long afterTime2 = System.nanoTime();

            Arrays.sort(arr, Comparator.reverseOrder());

            long beforeTime3 = System.nanoTime();
            NaturalMergeSort.sort(arr);
            long afterTime3 = System.nanoTime();


            double time = (double)(afterTime - beforeTime)/1000000;
            double time2 = (double)(afterTime2 - beforeTime2)/1000000;
            double time3 = (double)(afterTime3 - beforeTime3)/1000000;
            System.out.printf("%-8d time : %f\t%f\t%f\n", i, time, time2, time3);
        }
    }
}
