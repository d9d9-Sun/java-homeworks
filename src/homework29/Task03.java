package homework29;

import java.util.Comparator;
import java.util.Date;
import java.util.TreeMap;

public class Task03 {
    public static void main(String[] args) {
        Comparator<Task03_Client> comparator = ((a, b) -> {
            if (b.getPriority() == a.getPriority() && a.getAddress().equals(b.getAddress())) {
                return 0;
            }
            if (b.getPriority() > a.getPriority()) {
                return -1;
            }
            return 1;
        });

        TreeMap<Task03_Client, String> server = new TreeMap<>(comparator);

        Date date = new Date();

        server.put(new Task03_Client("127.0.0.1", 20), date.toString());
        server.put(new Task03_Client("192.168.0.1", 10), date.toString());
        server.put(new Task03_Client("192.0.0.2", 40), date.toString());
        server.put(new Task03_Client("243.5.5.1", 30), date.toString());

        System.out.println(server);
    }
}
