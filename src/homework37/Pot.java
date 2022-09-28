package homework37;

public class Pot {
    private int potSize;
    private int portions;

    public Pot(int potSize) {
        this.potSize = potSize;
    }

    void emptyPot() {
        portions = 0;
        System.out.println("Медведь всё съел!");
    }

    void addPortion() {
        portions++;
        System.out.println("Порция " + portions + " добавлена");
    }

    boolean isFull() {
        return potSize == portions;
    }
}
