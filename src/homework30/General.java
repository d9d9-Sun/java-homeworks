package homework30;

import java.io.IOException;
import java.util.HashMap;

public class General {
    public static HashMap<Long, Person> dataBase = new HashMap<>();
    public static void main(String[] args) throws IOException {
        Menu.showMenu();
    }
}
