package homework37;

public class Task {
    public static void main(String[] args) throws InterruptedException {
        int h = (int) (Math.random() * 50); //размер горшка
        int n = (int) (Math.random() * 10); //количество пчёл

        System.out.println("Размер горшка " + h);
        System.out.println("Количество пчёл " + n);

        Pot pot = new Pot(h);
        Bear bear = new Bear(pot);
        bear.start();

        for (int i = 0; i < n; i++) {
            Bee bee = new Bee(pot);
            bee.start();
        }

        bear.join();
    }
}
