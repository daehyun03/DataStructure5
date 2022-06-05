package daeHyun;

import sort.*;
import main.RandomArrayCreator;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        System.out.println("arr len         R             up            down");

        int[] sizeArr = {10000, 20000, 30000, 40000, 50000};

        double[] avgTime1 = new double[sizeArr.length];
        double[] avgTime2 = new double[sizeArr.length];
        double[] avgTime3 = new double[sizeArr.length];

        test(RandomArrayCreator.intArr(1000000));
        for ( int j = 0; j < 10; j++) {
            for ( int i = 0; i < sizeArr.length; i++ ) {
                Integer[] arr = RandomArrayCreator.intArr(sizeArr[i]);
                double time1 = test(arr);
                double time2 = test(arr);
                Arrays.sort(arr, Comparator.reverseOrder());
                double time3 = test(arr);
                System.out.printf("%-8d time : %f\t%f\t%f %b\n", i, time1, time2, time3, isSorted(arr));
                avgTime1[i] += time1;
                avgTime2[i] += time2;
                avgTime3[i] += time3;
            }
            System.out.println();
        }

        for ( int size : sizeArr ) {
            System.out.print(size + "\t");
        }
        System.out.println();
        for ( double dou : avgTime1 ) {
            System.out.print(dou/10 + "\t");
        }
        System.out.println();
        for ( double dou : avgTime2 ) {
            System.out.print(dou/10 + "\t");
        }
        System.out.println();
        for ( double dou : avgTime3 ) {
            System.out.print(dou/10 + "\t");
        }
    }

    public static double test(Comparable[] arr) {
        long beforeTime = System.nanoTime();
        NaturalMergeSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static boolean isSorted(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if ( array[i].compareTo(array[i+1]) > 0 )
                return false;
        }
        return true;
    }
    /*
        arraysSort(arr.clone());
        collectionsSort(Arrays.asList(arr.clone()));*/
}
