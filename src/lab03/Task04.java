package lab03;

import java.io.*;

public class Task04 {
    public static void main(String[] args) throws IOException {
        File tempFile = new File(createImage.getPath() + "temp");
        File[] files = tempFile.listFiles();
        if (files != null && files.length > 0) {
            createImage.create(files[0]);
            if (createImage.getImgOut() != null) {
                addInfoToFile(createImage.getLastName(), createImage.getImgOut().getName());
            }
        } else {
            System.out.println("папка temp пуста");
        }
    }

    public static void addInfoToFile(String name, String img) throws IOException {
        File info = new File(createImage.getPath() + "user_photos" + File.separator, "info.txt");
        FileInputStream inputStream = new FileInputStream(info);
        int i;
        StringBuilder temp = new StringBuilder();
        while ((i = inputStream.read()) != -1) {
            temp.append((char) i);
        }
        inputStream.close();

        File infoOut = new File(createImage.getPath() + "user_photos" + File.separator, "info.txt");
        FileOutputStream outputStream = new FileOutputStream(infoOut);
        outputStream.write((temp + "\n" + name + ", " + img).getBytes());
        outputStream.close();
    }
}
