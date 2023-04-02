package by.mad;

import java.util.Map;

public class Pie implements Sweet {
    private Map<String, Integer> price;
    private String cookName;
    private int discount;

    public void setPrice(Map<String, Integer> price) {
        this.price = price;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Pie(String cookName, int discount) {
        this.cookName = cookName;
        this.discount = discount;
    }

    @Override
    public void run() {
        price.entrySet().forEach(
                x -> System.out.println("Выпекаем пирог " + x.getKey() + " " + x.getValue()
                        + " " + cookName + ", скидка: " + discount)
        );
    }

}
