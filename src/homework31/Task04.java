package homework31;

import java.util.ArrayList;
import java.util.Comparator;

public class Task04 {
    public static void main(String[] args) {
        TVs tv1 = new TVs("s541", 2015, 314.45, 21, "Samsung");
        TVs tv2 = new TVs("l418", 2016, 124.15, 19, "LG");
        TVs tv3 = new TVs("h512", 2020, 299.99, 19, "Horizont");
        TVs tv4 = new TVs("s189", 2022, 1299.99, 51, "Samsung");

        ArrayList<TVs> tvs = new ArrayList<>();
        tvs.add(tv1);
        tvs.add(tv2);
        tvs.add(tv3);
        tvs.add(tv4);

        tvs.forEach(x -> System.out.println(x));

        System.out.println("Телевизоры с диагональю 19 дюймов:");
        tvs.stream()
                .filter(x -> x.getDiag() == 19)
                .forEach(x -> System.out.println(x));

        System.out.println("Телевизоры Samsung:");
        tvs.stream()
                .filter(x -> x.getVendor().equalsIgnoreCase("Samsung"))
                .forEach(x -> System.out.println(x));

        System.out.println("Телевизоры текущего года:");
        tvs.stream()
                .filter(x -> x.getYear() == 20202)
                .forEach(x -> System.out.println(x));

        System.out.println("Телевизоры дороже 1000:");
        tvs.stream()
                .filter(x -> x.getCost() > 1000)
                .forEach(x -> System.out.println(x));

        System.out.println("Отсортированы по цене по возрастанию:");
        tvs.stream()
                .sorted(priceASC)
                .forEach(x -> System.out.println(x));

        System.out.println("Отсортированы по цене по убыванию:");
        tvs.stream()
                .sorted(priceDESC)
                .forEach(x -> System.out.println(x));

        System.out.println("Отсортированы по диагонали по возрастанию:");
        tvs.stream()
                .sorted(diagASC)
                .forEach(x -> System.out.println(x));

        System.out.println("Отсортированы по диагонали по убыванию:");
        tvs.stream()
                .sorted(diagDESC)
                .forEach(x -> System.out.println(x));
    }

    public static Comparator<TVs> priceASC = (tv1, tv2) -> {
        return Double.compare(tv1.getCost(), tv2.getCost());
    };

    public static Comparator<TVs> priceDESC = (tv1, tv2) -> {
        return -Double.compare(tv1.getCost(), tv2.getCost());
    };

    public static Comparator<TVs> diagASC = (tv1, tv2) -> {
        return Integer.compare(tv1.getDiag(), tv2.getDiag());
    };

    public static Comparator<TVs> diagDESC = (tv1, tv2) -> {
        return -Integer.compare(tv1.getDiag(), tv2.getDiag());
    };
}
