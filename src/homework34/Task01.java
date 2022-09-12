package homework34;

import java.util.List;

public class Task01 {
    public static void main(String[] args) {
        int carAmount = 7;
        int parkingSpotAmount = 5;

        Parking parking = new Parking(parkingSpotAmount);
        List<Thread> carList = CarThread.createCars(carAmount, parking);
        CarThread.waitCars(carList);

        System.out.println(carList);
        System.out.println(parking.getVisitedCars());
    }
}
