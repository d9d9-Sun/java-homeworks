package homework29;

import java.util.Collection;

public class Task01_02_Buyer {
    private String name;
    private int age;
    private Task01_02_DiscountType discountType;

    public Task01_02_Buyer(String name, int age, Task01_02_DiscountType discountType) {
        this.name = name;
        this.age = age;
        this.discountType = discountType;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Task01_02_DiscountType getDiscountType() {
        return discountType;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", discountType=" + discountType +
                '}';
    }

    public static void removeVIPUsers(Collection<Task01_02_Buyer> buyers) {
        buyers.removeIf(next -> next.getDiscountType().equals(Task01_02_DiscountType.VIP));
    }

}
