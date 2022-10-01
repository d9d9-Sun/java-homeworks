package homework39;

import java.io.Serializable;

public class Employee implements Serializable {
    private String lastName;
    private int age;
    private String position;
    private int salaryRate;

    public Employee() {
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public int getSalaryRate() {
        return salaryRate;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalaryRate(int salaryRate) {
        this.salaryRate = salaryRate;
    }

    @Override
    public String toString() {
        return lastName + ", "
               + age + ", "
               + position + ", "
               + salaryRate + "$/hour";
    }
}
