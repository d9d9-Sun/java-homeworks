package homework30;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class General {
    public static List<Person> dataBase = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        dataBase.add(new Person(156216515, "Вася", "Minsk", TicketType.CREATING_AN_EMERGENCY));
        dataBase.add(new Person(221654112, "Петя", "Brest", TicketType.CROSSING_ROAD_IN_WRONG_PLACE));
        dataBase.add(new Person(356452125, "Маша", "Grodno", TicketType.PARKING));

        Menu.showMenu();
    }
}
