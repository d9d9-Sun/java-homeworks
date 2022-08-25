package homework31;

public class TVs {
    private String model;
    private int year;
    private double cost;
    private int diag;
    private String vendor;

    public TVs(String model, int year, double cost, int diag, String vendor) {
        this.model = model;
        this.year = year;
        this.cost = cost;
        this.diag = diag;
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getCost() {
        return cost;
    }

    public int getDiag() {
        return diag;
    }

    public String getVendor() {
        return vendor;
    }

    @Override
    public String toString() {
        return "TVs{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", cost=" + cost +
                ", diag=" + diag +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
