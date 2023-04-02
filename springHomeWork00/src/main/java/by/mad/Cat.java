package by.mad;

public class Cat implements Animal {
    @Override
    public void say() {
        System.out.println("Meow!");
    }

    @Override
    public void eat() {
        System.out.println("Cat eats.");
    }
}
