package by.mad;

public class Cow implements Animal {

    @Override
    public void say() {
        System.out.println("Moo!");
    }

    @Override
    public void eat() {
        System.out.println("Cow eats.");
    }
}
