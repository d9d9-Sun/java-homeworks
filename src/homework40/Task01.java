package homework40;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task01 {
    private static File file = new File(
            System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "homework40"
                    + File.separator, "poem.txt");

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        StringBuilder temp = new StringBuilder();

        int i;
        while ((i = inputStreamReader.read()) != -1) {
            temp.append((char) i);
        }
        inputStreamReader.close();

        String[] words = new String(temp).split(" ");
        String tempWord = words[0];
        words[0] = words[words.length - 1];
        words[words.length - 1] = tempWord;

        StringBuilder output = new StringBuilder();
        for (String word : words) {
            output.append(word).append(" ");
        }

        String outputString = String.valueOf(output);
        byte[] outputBytes = outputString.getBytes();

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(outputBytes);
        fileOutputStream.close();
    }
}
