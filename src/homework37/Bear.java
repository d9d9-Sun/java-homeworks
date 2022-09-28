package homework37;

public class Bear extends Thread {
    Pot pot;

    Bear(Pot pot) {
        this.pot = pot;
    }

    public void run() {
        while(true) {
            synchronized(pot) {
                while(!pot.isFull()) {
                    try {
                        pot.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Медведь проснулся.");
                pot.emptyPot();
            }
        }

    }
}
