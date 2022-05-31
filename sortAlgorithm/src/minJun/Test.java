package minJun;

import sort.ShellSort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Input a = new Input(70, 0);
        Input b = new Input(20, 0);
        Input c = new Input(20, 1);
        Input d = new Input(100, 0);
        Input e = new Input(10, 0);
        Input f = new Input(20, 2);
        Input g = new Input(10, 1);
        Input h = new Input(70, 1);
        Input i = new Input(100, 1);
        Input j = new Input(10, 2);
        Input[] array = {a, b, c, d, e, f, g, h, i, j};

        ShellSort.sort(array);

        System.out.print(Arrays.toString(array));








    }
}
