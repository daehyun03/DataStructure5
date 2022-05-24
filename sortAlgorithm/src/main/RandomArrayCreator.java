package main;

public class RandomArrayCreator {
    public static Integer[] IntArr(int size) {
        Integer[] arr = new Integer[size];
        for(int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * size);
        }

        return arr;
    }
}
