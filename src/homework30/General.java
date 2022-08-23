package homework30;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class General {
    public static List<Person> dataBase = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        dataBase.add(new Person(15621651, "Вася", "Minsk", TicketType.CREATING_AN_EMERGENCY));
        dataBase.add(new Person(22165411, "Петя", "Brest", TicketType.CROSSING_ROAD_IN_WRONG_PLACE));
        dataBase.add(new Person(35645212, "Маша", "Grodno", TicketType.PARKING));

        Menu.showMenu();
    }
}
