package lab03;

import java.io.*;

public class Task03 {
    public static void main(String[] args) throws IOException {
        File tempFile = new File(createImage.getPath() + "temp");
        File[] files = tempFile.listFiles();
        if (files != null && files.length > 0) {
            createImage.create(files[0]);
        } else {
            System.out.println("папка temp пуста");
        }
    }
}
