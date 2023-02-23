import java.util.ArrayList;
import java.util.List;

public class General {
    public static void main(String[] args) {
        Sections sec1 = new Sections("sec1", 10, RoomType.ROOM_A);
        Sections sec2 = new Sections("sec2", 11, RoomType.ROOM_B);
        Sections sec3 = new Sections("sec3", 15, RoomType.ROOM_C);
        Sections sec4 = new Sections("sec4", 16, RoomType.SWIMMING_POOL);

        List<Instructor> instructors = new ArrayList<>();
        instructors.add(new Instructor("Vasya", 32, sec1, 10, "education"));
        instructors.add(new Instructor("Petya", 31, sec2, 11, "education"));
        instructors.add(new Instructor("Misha", 29, sec3, 12, "education"));
        instructors.add(new Instructor("valera", 26, sec4, 13, "education"));

        long count = instructors.stream()
                .filter(i -> i.getAge() > 30)
                .filter(i -> i.getSection().getRoomType().equals(RoomType.ROOM_A)
                       || i.getSection().getRoomType().equals(RoomType.SWIMMING_POOL) )
                .count();

        System.out.println(count);
    }
}
