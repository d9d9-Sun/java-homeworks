package homework42;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task02 {
    public static void main(String[] args) {
        String fileName = "poem.pdf";

        Pattern pattern = Pattern.compile(".*(\\.txt)$|.*(\\.pdf)$");

            Matcher matcher = pattern.matcher(fileName);

            if (matcher.matches()) {
                System.out.println("Соответствует.");
            } else {
                System.out.println("Не соответствует.");
            }

    }
}
