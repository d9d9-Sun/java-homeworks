package by.mad;

import java.util.List;

public class Cake implements Sweet {
    private String sweetName;
    private List<String> size;

    @Override
    public void run() {
        size.forEach(x -> System.out.println("Готовим пирожное " + getSweetName() + " размер " + x));
    }

    public String getSweetName() {
        return sweetName;
    }

    public void setSweetName(String sweetName) {
        this.sweetName = sweetName;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }
}
