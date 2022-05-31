package main;

public class Student implements Comparable<Student>{
    private String name;
    private int[] score;

    public Student(String name, int[] score) {
        this.name = name;
        this.score = score;
    }

    public double getAvg() {
        double sum = 0;

        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }

        return sum / score.length;
    }

    @Override
    public int compareTo(Student stud) {
        double avg1 = getAvg();
        double avg2 = stud.getAvg();

        if (avg1 > avg2) {
            return 1;
        }
        else if (avg1 == avg2) {
            return 0;
        }
        else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return String.format("name : \s avg: \f", name, getAvg());
    }
}