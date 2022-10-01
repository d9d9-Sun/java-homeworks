package lab03;

import java.io.*;

public class Task08 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите путь к файлу: ");
        String path = input.readLine();

        System.out.println("Введите количество запрещённых слов:");
        int count = Integer.parseInt(input.readLine());

        String[] forbiddenWords = new String[count];
        for (int j = 0; j < forbiddenWords.length; j++) {
            System.out.println("Введите запрещённое слово: ");
            forbiddenWords[j] = input.readLine();
        }

        FileInputStream inputStream = new FileInputStream(path);
        int i;
        StringBuilder temp = new StringBuilder();
        while ((i = inputStream.read()) != -1) {
            temp.append((char) i);
        }
        inputStream.close();

        String[] text = new String(temp).split(" ");

        FileOutputStream outputStream = new FileOutputStream(path);
        for (int j = 0; j < forbiddenWords.length; j++) {
            int counter = 0;
            for (int k = 0; k < text.length; k++) {
                if (forbiddenWords[j].equalsIgnoreCase(text[k])) {
                    text[k] = "";
                    counter++;
                }
            }
            System.out.println("Слово " + forbiddenWords[j] + " удалено " + counter + " раз.");
        }

        StringBuilder tempOut = new StringBuilder();
        for (int j = 0; j < text.length; j++) {
            if (text[j] != null && j == text.length - 1) {
                tempOut.append(text[j]);
                break;
            }
            if (text[j] != null) {
                tempOut.append(text[j]);
                tempOut.append(" ");
            }
        }

        byte[] output = String.valueOf(tempOut).getBytes();

        outputStream.write(output);
        outputStream.close();

    }
}
