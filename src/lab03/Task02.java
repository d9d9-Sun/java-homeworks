package lab03;

import java.io.*;

public class Task02 {
    public static void main(String[] args) {
        File img = new File(System.getProperty("user.dir") + File.separator + "src/lab03", "1.png");

        try {
            FileInputStream inputStream = new FileInputStream(img);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();

            File imgNew = new File(System.getProperty("user.dir") + File.separator + "src/lab03", "2.png");
            FileOutputStream outputStream = new FileOutputStream(imgNew);
            outputStream.write(buffer);
            outputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
