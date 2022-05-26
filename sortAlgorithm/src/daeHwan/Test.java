package daeHwan;

import daeHyun.BottomUpMergeSort;
import main.RandomArrayCreator;


public class Test {
    public static void main(String[] args) {
        int size = 100000;

        int time = 30;

        long sumNMS = 0;
        long sumBUMS = 0;
        long sumMS = 0;
        long nms;
        long bums;
        long ms;

        System.out.printf("NMS \t: BUMS \t: MS \n");

        for (int i = 0; i < time; i++) {
            Integer[] arr1 = RandomArrayCreator.intArr(size);
            Integer[] arr2 = arr1.clone();
            Integer[] arr3 = arr1.clone();

            ms = testMS(arr3);
            bums = testBUMS(arr2);
            nms = testNMS(arr1);

            sumNMS += nms;
            sumBUMS += bums;
            sumMS += ms;

            System.out.printf("%d \t: %d \t: %d \n", nms, bums, ms);
        }
        System.out.println("평균시간");
        System.out.printf("%f \t: %f \t: %f \n", (double)sumNMS / time, (double)sumBUMS / time, (double)sumMS / time);
    }


    public static long testNMS(Integer[] arr) {
        long t1 = System.currentTimeMillis();
        try {
            Thread.sleep(500);
            NaturalMergeSort.sort(arr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return System.currentTimeMillis() - t1 - 500;
    }

    public static long testBUMS(Integer[] arr) {
        long t1 = System.currentTimeMillis();
        try {
            Thread.sleep(500);
            BottomUpMergeSort.sort(arr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return System.currentTimeMillis() - t1 - 500;
    }

    public static long testMS(Integer[] arr) {
        long t1 = System.currentTimeMillis();
        try {
            Thread.sleep(500);
            RecursiveMergeSort.sort(arr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return System.currentTimeMillis() - t1 - 500;
    }
}