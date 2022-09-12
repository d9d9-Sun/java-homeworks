package homework34;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private int carLimit;
    private List<Thread> parkedCars = new ArrayList<>();
    private List<Thread> visitedCars = new ArrayList<>();

    public Parking(int carLimit) {
        this.carLimit = carLimit;
    }

    public List<Thread> getVisitedCars() {
        return visitedCars;
    }

    public synchronized boolean accept(CarThread thread) throws InterruptedException {
        while (carLimit == 0) {
            wait(thread.getWaitTime());
            if (carLimit == 0) {
                return false;
            } else {
                break;
            }
        }
        carLimit--;
        parkedCars.add(thread);
        notifyAll();

        return true;
    }

    public synchronized void release(CarThread thread) {
        if (parkedCars.contains(thread)) {
            visitedCars.add(thread);
            carLimit++;
            parkedCars.remove(thread);
        }
    }

}
