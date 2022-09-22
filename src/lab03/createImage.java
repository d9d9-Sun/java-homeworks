package lab03;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

public class createImage {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "lab03" + File.separator;
    public static String getPath() {
        return path;
    }

    private static String lastName;
    public static String getLastName() {
        return lastName;
    }

    private static File imgOut;
    public static File getImgOut() {
        return imgOut;
    }

    public static void setImgOut(File imgOut) {
        createImage.imgOut = imgOut;
    }

    public static void create(File file) throws IOException {
        System.out.println("Введите фамилию: ");
        lastName = input.readLine();

        File img = new File(String.valueOf(file));

        imgOut = new File(path + "user_photos" + File.separator, lastName + ".png");
        if (!imgOut.exists()) {
            Files.copy(img.toPath(), imgOut.toPath());
            img.delete();
        } else {
            for (int i = 1; i < Integer.MAX_VALUE; i++) {
                imgOut = new File(path + "user_photos" + File.separator, lastName + i + ".png");
                if (!imgOut.exists()) {
                    imgOut = new File(path +  "user_photos" + File.separator, lastName + i + ".png");
                    Files.copy(img.toPath(), imgOut.toPath());
                    img.delete();
                    break;
                }
            }
        }
    }
}
