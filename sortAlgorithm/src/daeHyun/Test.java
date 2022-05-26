package daeHyun;

import main.RandomArrayCreator;

public class Test {
    public static void main(String[] args) {
        // 시간비교
       /* for ( int i = 1; i < 1000001; i = i*10) {
       // for ( int i = 100000; i > 0; i = i/10) {
            Integer[] arr = RandomArrayCreator.intArr(i);
            long beforeTime = System.nanoTime();
            BubbleSort.sort(arr);
            long afterTime = System.nanoTime();
            double time = (double)(afterTime - beforeTime)/1000000;
            BigDecimal time2 = new BigDecimal(time);
            System.out.println(i + " time : " + time2);
        }*/

        //정렬확인
    }

    public static boolean isSorted(Comparable[] arr) {
        for ( int i = 1; i < arr.length; i++ ) {
            if ( arr[i - 1].compareTo(arr[i]) > 0 ) {
                return false;
            }
        }
        return true;
    }
}
