package lab03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task05 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите путь к файлу: ");
        String path = input.readLine();

        System.out.println("Введите слово для поиска: ");
        String word = input.readLine();

        int count = 0;

        FileInputStream inputStream = new FileInputStream(path);
        int i;
        StringBuilder temp = new StringBuilder();
        while ((i = inputStream.read()) != -1) {
            temp.append((char) i);
        }
        inputStream.close();

        String[] text = new String(temp).split(" ");
        for (String t : text) {
            if (t.equalsIgnoreCase(word)) {
                count++;
            }
        }

        System.out.println("Слово встречается в файле " + count + " раз.");
    }
}
