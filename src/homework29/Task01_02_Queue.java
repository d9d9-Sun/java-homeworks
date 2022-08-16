package homework29;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Task01_02_Queue {
    public static void main(String[] args) {
        Task01_02_Buyer b4 = new Task01_02_Buyer("Петя", 23, Task01_02_DiscountType.VIP);
        Task01_02_Buyer b2 = new Task01_02_Buyer("Маша", 60, Task01_02_DiscountType.MEDIUM);
        Task01_02_Buyer b3 = new Task01_02_Buyer("Женя", 19, Task01_02_DiscountType.STANDARD);
        Task01_02_Buyer b1 = new Task01_02_Buyer("Вася", 65, Task01_02_DiscountType.VIP);

        Comparator<Task01_02_Buyer> buyerComparator = (a, b) -> {
            if (a.getAge() == b.getAge() && a.getName().equals(b.getName()) && a.getDiscountType().equals(b.getDiscountType())) {
                return 0;
            }
            if (a.getAge() > 60 && (a.getAge() < 60 && b.getDiscountType().equals(Task01_02_DiscountType.VIP))) {
                return 1;
            }
            if (b.getDiscountType().equals(Task01_02_DiscountType.VIP) && a.getAge() < 60) {
                return 1;
            }
            return -1;
        };

        TreeSet<Task01_02_Buyer> buyers = new TreeSet<>(buyerComparator);

        buyers.add(b1);
        buyers.add(b2);
        buyers.add(b3);
        buyers.add(b4);

        buyers.forEach(x -> System.out.println(x));

        Task01_02_Buyer.removeVIPUsers(buyers);

        buyers.forEach(x -> System.out.println(x));

    }

}

