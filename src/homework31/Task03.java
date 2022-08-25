package homework31;

import java.util.ArrayList;

public class Task03 {
    public static void main(String[] args) {
        Cars car1 = new Cars("Volvo", 2009, 12500, "dark blue", 3.2);
        Cars car2 = new Cars("VW", 1998, 8500, "gray", 1.9);
        Cars car3 = new Cars("Audi", 1986, 1100, "white", 2.0);
        Cars car4 = new Cars("Mercedes", 2010, 27000, "dark blue", 2.0);
        Cars car5 = new Cars("Mercedes", 2015, 45000, "black", 3.2);

        ArrayList<Cars> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        cars.forEach(x-> System.out.println(x));

        System.out.println("Автомобили тёмно-синего цвета:");
        cars.stream()
                .filter(x -> x.getColor().equalsIgnoreCase("dark blue"))
                .forEach(x -> System.out.println(x));

        System.out.println("Автомобили объёмом 3.2:");
        cars.stream()
                .filter(x -> x.getV() == 3.2)
                .forEach(x -> System.out.println(x));

        System.out.println("Автомобили дороже 25000:");
        cars.stream()
                .filter(x -> x.getCost() > 25000)
                .forEach(x -> System.out.println(x));

        System.out.println("Автомобили 2010-x выпуска:");
        cars.stream()
                .filter(x -> x.getYear() < 2020 && x.getYear() >= 2010)
                .forEach(x -> System.out.println(x));
    }
}
