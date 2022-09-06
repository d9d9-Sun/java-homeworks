package homework32;

import java.util.ArrayList;

public class Task {
    public static void main(String[] args) {
        Programmer programmer1 = new Programmer(Languages.JAVA, "Вася", 5000, true);
        Programmer programmer2 = new Programmer(Languages.JAVA, "Петя", 6000, false);
        Programmer programmer3 = new Programmer(Languages.PYTHON, "Гена", 3000, true);
        Programmer programmer4 = new Programmer(Languages.PYTHON, "Миша", 3500, true);
        Programmer programmer5 = new Programmer(Languages.JS, "Егор", 2500, true);
        Programmer programmer6 = new Programmer(Languages.JS, "Люда", 2000, false);

        ArrayList<Programmer> programmers = new ArrayList<>();
        programmers.add(programmer1);
        programmers.add(programmer2);
        programmers.add(programmer3);
        programmers.add(programmer4);
        programmers.add(programmer5);
        programmers.add(programmer6);

        System.out.println("Максимальная зарплата: "
                + programmers.stream()
                .mapToInt(x -> x.getSalary())
                .max()
                .getAsInt()
        );

        System.out.println("Минимальная зарплата: "
                + programmers.stream()
                .mapToInt(x -> x.getSalary())
                .min()
                .getAsInt()
        );

        System.out.println("Средняя зарплата: "
                + programmers.stream()
                .mapToDouble(x -> x.getSalary())
                .average()
                .getAsDouble()
        );

        System.out.println("Всего программистов: "
                + programmers.stream()
                .count()
        );

        System.out.println("Программисты, работающие удалённо: ");
        programmers.stream()
                .filter(x -> x.isRemote())
                .map(x -> x.getFio().toString())
                .forEach(x -> System.out.println(x));

        System.out.println("Количество программистов Java: "
                + programmers.stream()
                .filter(x -> x.getLanguage().equals(Languages.JAVA))
                .count()
        );

        System.out.println("Программисты Python, работающие удалённо: ");
        programmers.stream()
                .filter(x -> x.isRemote() && x.getLanguage().equals(Languages.PYTHON))
                .map(x -> x.getFio().toString())
                .forEach(x -> System.out.println(x));

        System.out.println("Максимальная зарплата программиста JS: "
                + programmers.stream()
                .filter(x -> x.getLanguage().equals(Languages.JS))
                .mapToInt(x -> x.getSalary())
                .max()
                .getAsInt()
        );
    }
}
