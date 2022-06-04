package main;

import sort.*;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] state = {
                "Random",
                "Increase",
                "Decrease"
        };
        String[] sortName = {
                "BubbleSort",
                "SelectionSort",
                "LinearInsertionSort",
                "BinaryInsertionSort",
                "ShellSort",
                "HeapSort",
                "RecursiveMergeSort",
                "IterativeMergeSort",
                "NaturalMergeSort",
                "RecursiveQuickSort",
                "MedianOfThreeQuickSort",
                "ArraysSort",
                "CollectionsSort"
        };

        clearFile();


        int[] sizeArr = {1000, 2000, 3000, 4000, 5000};

        appendFile("Integer\n");
        for (int size : sizeArr) {
            testAllState(state, sortName, RandomArrayCreator.intArr(size));
        }

        appendFile("\n\nDouble\n");
        for (int size : sizeArr) {
            testAllState(state, sortName, RandomArrayCreator.doubleArr(size));
        }

        appendFile("\n\nString\n");
        for (int size : sizeArr) {
            testAllState(state, sortName, RandomArrayCreator.strArr(size));
        }

        appendFile("\n\nStudent\n");
        for (int size : sizeArr) {
            testAllState(state, sortName, RandomArrayCreator.studArr(size));
        }
    }



    public static void testAllState(String[] state, String[] sortName, Comparable[] arr) {
        StringBuilder[] result = new StringBuilder[sortName.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new StringBuilder();
        }

        int time = 5;

        testAllSort(result, time, arr);
        Arrays.sort(arr);
        testAllSort(result, time, arr);
        Arrays.sort(arr, Comparator.reverseOrder());
        testAllSort(result, time, arr);

        appendFile(state, sortName, arr.length, result);

        System.out.println("complete one cycle");
    }

    public static void testAllSort(StringBuilder[] result, int time, Comparable[] arr) {
        double[] sumRuntime = new double[result.length];

        try {
            for (int i = 0; i < time; i++) {
                sumRuntime[0] += bubbleSortTest(arr.clone());
                sumRuntime[1] += selectionSortTest(arr.clone());
                sumRuntime[2] += linearInsertionSortTest(arr.clone());
                sumRuntime[3] += binaryInsertionSortTest(arr.clone());
                sumRuntime[4] += shellSortTest(arr.clone());
                sumRuntime[5] += heapSortTest(arr.clone());
                sumRuntime[6] += recursiveMergeSortTest(arr.clone());
                sumRuntime[7] += iterativeMergeSortTest(arr.clone());
                sumRuntime[8] += naturalMergeSortTest(arr.clone());
                sumRuntime[9] += recursiveQuickSortTest(arr.clone());
                sumRuntime[10] += medianOfThreeQuickSortTest(arr.clone());
                sumRuntime[11] += arraysSort(arr.clone());
                sumRuntime[12] += collectionsSort(Arrays.asList(arr.clone()));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < result.length; i++) {
            result[i].append(String.format("%f\t", sumRuntime[i] / time));
        }
    }



    public static void clearFile() {
        try {
            String filePath = "result.txt";
            File file = new File(filePath);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bos = new BufferedWriter(fw);
            bos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void appendFile(String str) {
        String filePath = "result.txt";
        File file = new File(filePath);

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bos = new BufferedWriter(fw);

            bos.write(str);
            bos.flush();
            bos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void appendFile(String[] state, String[] sortName, int size, StringBuilder[] result) {
        String filePath = "result.txt";
        File file = new File(filePath);

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bos = new BufferedWriter(fw);

            bos.write("size : "+ size +"\n");
            for (int i = 0; i < state.length; i++) {
                bos.write("\t" + state[i]);
            }
            bos.write("\n");

            for (int i = 0; i < sortName.length; i++) {
                bos.write(sortName[i] + "\t" + result[i].toString() + "\n");
            }
            bos.write("\n\n");

            bos.flush();
            bos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static double bubbleSortTest(Comparable[] arr) throws InterruptedException {
        Thread.sleep(1000);

        long beforeTime = System.nanoTime();
        BubbleSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double selectionSortTest(Comparable[] arr) throws InterruptedException {
        Thread.sleep(1000);

        long beforeTime = System.nanoTime();
        SelectionSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double linearInsertionSortTest(Comparable[] arr) throws InterruptedException {
        Thread.sleep(1000);

        long beforeTime = System.nanoTime();
        LinearInsertionSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double binaryInsertionSortTest(Comparable[] arr) throws InterruptedException {
        Thread.sleep(1000);

        long beforeTime = System.nanoTime();
        BinaryInsertionSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double shellSortTest(Comparable[] arr) throws InterruptedException {
        Thread.sleep(1000);

        long beforeTime = System.nanoTime();
        ShellSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double heapSortTest(Comparable[] arr) throws InterruptedException {
        Thread.sleep(1000);

        long beforeTime = System.nanoTime();
        HeapSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double recursiveMergeSortTest(Comparable[] arr) throws InterruptedException {
        Thread.sleep(1000);

        long beforeTime = System.nanoTime();
        RecursiveMergeSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double iterativeMergeSortTest(Comparable[] arr) throws InterruptedException {
        Thread.sleep(1000);

        long beforeTime = System.nanoTime();
        IterativeMergeSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double naturalMergeSortTest(Comparable[] arr) throws InterruptedException {
        Thread.sleep(1000);

        long beforeTime = System.nanoTime();
        NaturalMergeSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double recursiveQuickSortTest(Comparable[] arr) throws InterruptedException {
        Thread.sleep(1000);

        long beforeTime = System.nanoTime();
        RecursiveQuickSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double medianOfThreeQuickSortTest(Comparable[] arr) throws InterruptedException {
        Thread.sleep(1000);

        long beforeTime = System.nanoTime();
        MedianOfThreeQuickSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double arraysSort(Comparable[] arr) throws InterruptedException {
        Thread.sleep(1000);

        long beforeTime = System.nanoTime();
        Arrays.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double collectionsSort(List arr) throws InterruptedException {
        Thread.sleep(1000);

        long beforeTime = System.nanoTime();
        Collections.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }
}