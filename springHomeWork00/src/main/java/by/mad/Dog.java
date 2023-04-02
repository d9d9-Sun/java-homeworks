package by.mad;

public class Dog implements Animal {
    @Override
    public void say() {
        System.out.println("Woof!");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats.");
    }
}
