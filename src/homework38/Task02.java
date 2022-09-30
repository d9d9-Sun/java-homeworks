package homework38;

import java.io.*;

public class Task02 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите путь к файлу: ");
        String path = input.readLine();

        System.out.println("Введите слово для поиска: ");
        String word = input.readLine();

        System.out.println("Введите слово для замены: ");
        String replace = input.readLine();

        FileInputStream inputStream = new FileInputStream(path);
        int i;
        StringBuilder temp = new StringBuilder();
        while ((i = inputStream.read()) != -1) {
            temp.append((char) i);
        }
        inputStream.close();

        String[] text = new String(temp).split(" ");

        FileOutputStream outputStream = new FileOutputStream(path);

        int counter = 0;
        for (String t : text) {
            if (word.equalsIgnoreCase(t)) {
                t = replace;
                counter++;
            }
            outputStream.write((t + " ").getBytes());
        }

        outputStream.close();

        System.out.println("Количество замен: " + counter);
    }
}
