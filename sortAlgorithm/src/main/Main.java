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

        int[] sizeArr = {10000, 20000, 30000, 40000, 50000};

        clearFile();
        tempRunAllSort();
        test(state, sortName, sizeArr);
    }

    public static void tempRunAllSort() {
        Comparable[] arr = RandomArrayCreator.intArr(10000);
        try{
            bubbleSortTest(arr.clone());
            selectionSortTest(arr.clone());
            linearInsertionSortTest(arr.clone());
            binaryInsertionSortTest(arr.clone());
            shellSortTest(arr.clone());
            heapSortTest(arr.clone());
            recursiveMergeSortTest(arr.clone());
            iterativeMergeSortTest(arr.clone());
            naturalMergeSortTest(arr.clone());
            recursiveQuickSortTest(arr.clone());
            medianOfThreeQuickSortTest(arr.clone());
            arraysSort(arr.clone());
            collectionsSort(Arrays.asList(arr.clone()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void test(String[] state, String[] sortName, int[] sizeArr) {
        StringBuilder[][] result = new StringBuilder[state.length][sortName.length];
        resetResult(result);

        appendFile("Integer\n");
        for (int size : sizeArr) {
            testAllState(result, state, sortName, RandomArrayCreator.intArr(size));
        }
        printResult(state, sortName, sizeArr, result);
        resetResult(result);

        appendFile("\n\nDouble\n");
        for (int size : sizeArr) {
            testAllState(result, state, sortName, RandomArrayCreator.doubleArr(size));
        }
        printResult(state, sortName, sizeArr, result);
        resetResult(result);

        appendFile("\n\nString\n");
        for (int size : sizeArr) {
            testAllState(result, state, sortName, RandomArrayCreator.strArr(size));
        }
        printResult(state, sortName, sizeArr, result);
        resetResult(result);

        appendFile("\n\nStudent\n");
        for (int size : sizeArr) {
            testAllState(result, state, sortName, RandomArrayCreator.studArr(size));
        }
        printResult(state, sortName, sizeArr, result);
    }

    public static void resetResult(StringBuilder[][] sb) {
        for (int i = 0; i < sb.length; i++) {
            for (int j = 0; j < sb[0].length; j++) {
                sb[i][j] = new StringBuilder();
            }
        }
    }

    public static void printResult(String[] state, String[] sortName, int[] sizeArr, StringBuilder[][] result) {
        for (int i = 0; i < result.length; i++) {
            appendFile(state[i] + "\n");
            appendFile(sortName, sizeArr, result[i]);
        }
    }



    public static void testAllState(StringBuilder[][] result, String[] state, String[] sortName, Comparable[] arr) {
        int time = 10;

        testAllSort(result[0], time, arr);
        Arrays.sort(arr);
        testAllSort(result[1], time, arr);
        Arrays.sort(arr, Comparator.reverseOrder());
        testAllSort(result[2], time, arr);

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

    public static void appendFile(String[] sortName, int[] sizeArr, StringBuilder[] result) {
        String filePath = "result.txt";
        File file = new File(filePath);

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bos = new BufferedWriter(fw);

            bos.write("size : ");
            for (int i = 0; i < sizeArr.length; i++) {
                bos.write("\t" + sizeArr[i]);
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
        long beforeTime = System.nanoTime();
        BubbleSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double selectionSortTest(Comparable[] arr) throws InterruptedException {
        long beforeTime = System.nanoTime();
        SelectionSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double linearInsertionSortTest(Comparable[] arr) throws InterruptedException {
        long beforeTime = System.nanoTime();
        LinearInsertionSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double binaryInsertionSortTest(Comparable[] arr) throws InterruptedException {
        long beforeTime = System.nanoTime();
        BinaryInsertionSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double shellSortTest(Comparable[] arr) throws InterruptedException {
        long beforeTime = System.nanoTime();
        ShellSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double heapSortTest(Comparable[] arr) throws InterruptedException {
        long beforeTime = System.nanoTime();
        HeapSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double recursiveMergeSortTest(Comparable[] arr) throws InterruptedException {
        long beforeTime = System.nanoTime();
        RecursiveMergeSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double iterativeMergeSortTest(Comparable[] arr) throws InterruptedException {
        long beforeTime = System.nanoTime();
        IterativeMergeSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double naturalMergeSortTest(Comparable[] arr) throws InterruptedException {
        long beforeTime = System.nanoTime();
        NaturalMergeSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double recursiveQuickSortTest(Comparable[] arr) throws InterruptedException {
        long beforeTime = System.nanoTime();
        RecursiveQuickSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double medianOfThreeQuickSortTest(Comparable[] arr) throws InterruptedException {
        long beforeTime = System.nanoTime();
        MedianOfThreeQuickSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double arraysSort(Comparable[] arr) throws InterruptedException {
        long beforeTime = System.nanoTime();
        Arrays.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double collectionsSort(List arr) throws InterruptedException {
        long beforeTime = System.nanoTime();
        Collections.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }
}