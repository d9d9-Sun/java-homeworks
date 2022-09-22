package lab03;

import java.io.File;
import java.util.Arrays;

public class Task01 {
    public static void main(String[] args) {
        File dir = new File("D:/");
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
                System.out.println(Arrays.toString(file.listFiles()));
            }
        }
    }
}
