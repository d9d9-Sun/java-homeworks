package by.mad;

import java.util.List;

public class Farm {
    private List<Animal> animal;

    public Farm(List<Animal> animal) {
        this.animal = animal;
    }

    public void start() {
        animal.forEach(x -> {
            x.eat();
            x.say();
        });
    }
}
