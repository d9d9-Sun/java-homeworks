package homework37;

public class Bee extends Thread {
    Pot pot;

    Bee(Pot pot) {
        this.pot = pot;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (pot) {
                if (!pot.isFull()) {
                    pot.addPortion();
                    if (pot.isFull()) {
                        pot.notifyAll();
                    }
                }
            }
        }
    }
}
