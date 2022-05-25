package minJun;

public class Input implements Comparable<Input>{
    private int value;
    private int order;

    public Input(int value, int order) {
        this.value = value;
        this.order = order;
    }

    @Override
    public int compareTo(Input a) {
        if (this.value == a.value) {
            return 0;
        } else if (this.value > a.value) {
            return 1;
        } else return -1;
    }

    public String toString() {
        return String.format("[%d, %d]", value, order);
    }
}
