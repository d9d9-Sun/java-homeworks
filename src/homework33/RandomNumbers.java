package homework33;

public class RandomNumbers extends Thread{
    public static int[] array = new int[10];

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
    }
}
