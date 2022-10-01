package lab03;

import java.io.*;

public class Task07 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] pathes = new String[4];
        int bytesCount = 0;

        for (int i = 0; i < pathes.length; i++) {
            System.out.println("Введите путь к файлу " + (i + 1) + ": ");
            pathes[i] = input.readLine();
        }

        byte[][] buffer = new byte[pathes.length][];

        for (int i = 0; i < pathes.length - 1; i++) {
            FileInputStream inputStream = new FileInputStream(pathes[i]);
            buffer[i] = new byte[inputStream.available()];
            bytesCount += inputStream.available();
            inputStream.read(buffer[i]);
            inputStream.close();
        }

        FileOutputStream outputStream = new FileOutputStream(pathes[3]);
        for (int i = 0; i < pathes.length - 1; i++) {
            outputStream.write(buffer[i]);
            outputStream.write((System.lineSeparator() + System.lineSeparator()).getBytes());
        }

        outputStream.close();

        System.out.println("Количество перенесённых байт: " + bytesCount);
    }
}
