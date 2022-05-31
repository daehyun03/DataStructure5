package daeHyun;

import daeHwan.NaturalMergeSort;
import daeHwan.RecursiveMergeSort;
import main.RandomArrayCreator;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        System.out.println("arr len         R             up            down\tMerge");

        int[] sizeArr = {1000000, 500000, 100000, 50000, 10000};

        double[] avgTime1 = new double[5];
        double[] avgTime2 = new double[5];
        double[] avgTime3 = new double[5];


        test(RandomArrayCreator.intArr(1000000));
        for ( int j = 0; j < 10; j++) {
            for (int i : sizeArr) {
                Integer[] arr = RandomArrayCreator.intArr(i);

                double time1 = test(arr);
                double time2 = test(arr);
                Arrays.sort(arr, Comparator.reverseOrder());
                double time3 = test(arr);
                System.out.printf("%-8d time : %f\t%f\t%f\n", i, time1, time2, time3);
                /*avgTime1[] += time1;
                avgTime2[] += time2;
                avgTime3[] += time3;*/
            }
            System.out.println();
        }
        //System.out.printf("avg : %f\t%f\t%f", avgTime1/10, avgTime2/10, avgTime3/10);
    }

    public static double test(Comparable[] arr) {
        long beforeTime = System.nanoTime();
        NaturalMergeSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    /*public static double test2(Comparable[] arr) {
        long beforeTime = System.nanoTime();
        NaturalMergeSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }*/
}
