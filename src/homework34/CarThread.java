package homework34;

import java.util.ArrayList;
import java.util.List;

public class CarThread extends Thread {
    private int waitTime;
    private int startTime;
    private int parkedTime;
    private Parking parking;
    private static int threadQty = 0;
    private int number = ++threadQty;

    public int getWaitTime() {
        return waitTime;
    }

    public CarThread(int waitTime, int startTime, int parkedTime, Parking parking) {
        this.waitTime = waitTime;
        this.startTime = startTime;
        this.parkedTime = parkedTime;
        this.parking = parking;
        start();
    }

    @Override
    public void run() {
        try {
            wait(startTime);
            boolean isAccepted = parking.accept(this);
            if (isAccepted) {
                wait(parkedTime);
                parking.release(this);
            } else {
                System.out.println(this + "can't wait more");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String toString() {
        return "Thread number: " + number
                + " waitTime: " + waitTime
                + " startTime:" + startTime
                + " parkedTime:" + parkedTime
                + "\n";
    }

    public void wait(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public static List<Thread> createCars(int carQty, Parking parking) {
        List<Thread> carList = new ArrayList<>();
        for (int carNumber = 0; carNumber < carQty; carNumber++) {
            int waitTime = (int) (Math.random() * 25);
            int startTime = (int) (Math.random() * 5);
            int parkedTime = (int) (Math.random() * 25);
            carList.add(new CarThread(waitTime, startTime, parkedTime, parking));
        }

        return carList;
    }

    public static void waitCars(List<Thread> threads) {
        try {
            for (Thread thread : threads) thread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
