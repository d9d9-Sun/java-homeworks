package homework40;

import java.util.Arrays;

public class Students {
    private String fio;
    private int[] scores;
    private double average;

    public Students() {
    }

    public String getFio() {
        return fio;
    }

    public int[] getScores() {
        return scores;
    }

    public double getAverage() {
        return average;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return fio + " "
                + Arrays.toString(scores)
                    .replace("[","")
                    .replace("]","")
                    .replace(",","");
    }
}
