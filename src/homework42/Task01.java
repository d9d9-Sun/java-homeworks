package homework42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task01 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Введите телефон (с кодом): ");
        String phoneNumber = input.readLine();

        phoneNumber = phoneNumber.replace(" ", "");

        Pattern pattern = Pattern.compile("^(80).*");
        Pattern pattern2 = Pattern.compile("^(375).*");

        Matcher matcher = pattern.matcher(phoneNumber);
        Matcher matcher2 = pattern2.matcher(phoneNumber);

        if (matcher.matches()) {
            phoneNumber = phoneNumber.replaceFirst("^(80)", "");
        }

        if (matcher2.matches()) {
            phoneNumber = phoneNumber.replaceFirst("^(375)", "");
        }

        System.out.println(phoneNumber.replaceFirst(
                "(\\d{2})(\\d{3})(\\d{2})(\\d{2})",
                "+375($1) ***-$3-$4"));
    }
}
