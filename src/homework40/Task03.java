package homework40;

import homework39.Employee;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class Task03 {
    private static File file = new File(
            System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "homework40"
                    + File.separator, "Students.txt");

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        StringBuilder temp = new StringBuilder();

        int i;
        while ((i = inputStreamReader.read()) != -1) {
            temp.append((char) i);
        }
        inputStreamReader.close();

        String[] base = new String(temp).split(System.lineSeparator());

        ArrayList<Students> dataBase = new ArrayList<>();
        for (int j = 0; j < base.length; j++) {
            String[] infoArray = base[j].split(" ");

            Students student = new Students();

            student.setFio(infoArray[0]);

            int[] scores = new int[infoArray.length - 1];
            int sum = 0;
            for (int k = 1; k < infoArray.length; k++) {
                scores[k - 1] = Integer.parseInt(infoArray[k]);
                sum += scores[k - 1];
            }

            double average = (double) sum / (infoArray.length - 1);

            student.setScores(scores);
            student.setAverage(average);
            dataBase.add(student);
        }

        dataBase.stream()
                .filter(x-> x.getAverage() > 7)
                .forEach(x -> x.setFio(x.getFio().toUpperCase()));

        FileWriter writer;
        try {
            writer = new FileWriter(file);
            for(Students st: dataBase) {
                writer.write(st + System.lineSeparator());
            }

            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
