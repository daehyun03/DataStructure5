package main;

public class RandomArrayCreator {
    public static Integer[] intArr(int size) {
        Integer[] arr = new Integer[size];
        for(int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * size);
        }

        return arr;
    }

    public static Double[] doubleArr(int size) {
        Double[] arr = new Double[size];
        for(int i = 0; i < size; i++) {
            arr[i] = (Math.random() * size);
        }

        return arr;
    }

    public static Student[] studArr(int size) {
        Student[] arr = new Student[size];
        for(int i = 0; i < size; i++) {
            arr[i] = new Student(convert26((int)(Math.random() * size)), scoreArr()); // 수정 중
        }

        return arr;
    }

    public static int[] scoreArr() {
        final int SIZE = 5;
        int[] arr = new int[SIZE];
        for(int i = 0; i < SIZE; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        return arr;
    }

    public static String[] strArr(int size) {
        String[] arr = new String[size];
        for(int i = 0; i < size; i++) {
            arr[i] = convert26((int)(Math.random() * size));
        }

        return arr;
    }

    private static final String convert26(int num) {
        final int NOTATION = 26;
        final char START_CHAR = 'A';

        StringBuilder sb = new StringBuilder();

        while (num != -1) {
            sb.append((char)(num % NOTATION + START_CHAR));
            num = num / NOTATION - 1;
        }

        return sb.reverse().toString();
    }
}
