import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sections {
    private String name;
    private int maxCapacity;
    private RoomType roomType;
}
