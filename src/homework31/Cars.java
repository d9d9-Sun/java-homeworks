package homework31;

public class Cars {
    private String name;
    private int year;
    private double cost;
    private String color;
    private double v;

    public Cars(String name, int year, double cost, String color, double v) {
        this.name = name;
        this.year = year;
        this.cost = cost;
        this.color = color;
        this.v = v;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getCost() {
        return cost;
    }

    public String getColor() {
        return color;
    }

    public double getV() {
        return v;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", cost=" + cost +
                ", color='" + color + '\'' +
                ", v=" + v +
                '}';
    }
}
