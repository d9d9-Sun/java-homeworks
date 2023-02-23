import lombok.*;

@Data
@AllArgsConstructor
public class Instructor {
    private String fio;
    private int age;
    private Sections section;
    private int experience;
    private String education;
}
