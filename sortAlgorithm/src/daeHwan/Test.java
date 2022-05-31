package daeHwan;

import main.RandomArrayCreator;


public class Test {
    public static void main(String[] args) throws InterruptedException {
        int size = 100000;

        Integer[] arr1 = RandomArrayCreator.intArr(size);
        Integer[] arr2 = arr1.clone();
        Integer[] arr3 = arr1.clone();
        Integer[] arr4 = arr1.clone();

        RecursiveMergeSort.sort(arr3);
        NaturalMergeSort2.sort(arr4);


        double startTime_rec2 = System.nanoTime();
        NaturalMergeSort2.sort(arr2);
        double finishTime_rec2 = System.nanoTime();
        double elapsedTime_rec2 = finishTime_rec2 - startTime_rec2;
        System.out.println(elapsedTime_rec2 / 1000000.0);


        double startTime_rec = System.nanoTime();
        RecursiveMergeSort.sort(arr1);
        double finishTime_rec = System.nanoTime();
        double elapsedTime_rec = finishTime_rec - startTime_rec;
        System.out.println(elapsedTime_rec / 1000000.0);


    }
}