package daeHwan;

import main.RandomArrayCreator;
import main.Student;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
/*        Integer[] arr = RandomArrayCreator.intArr(100);
        HeapSort.sort(arr);

        System.out.print(Arrays.toString(arr));*/

        Student a = new Student("홍길동", 10, 20, 32, 45, 51);
        System.out.print(a.getAvg());
    }
}