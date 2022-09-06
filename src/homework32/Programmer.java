package homework32;

public class Programmer {
    private Languages language;
    private String fio;
    private int salary;
    private boolean remote;

    public Programmer(Languages language, String fio, int salary, boolean remote) {
        this.language = language;
        this.fio = fio;
        this.salary = salary;
        this.remote = remote;
    }

    public Languages getLanguage() {
        return language;
    }

    public String getFio() {
        return fio;
    }

    public int getSalary() {
        return salary;
    }

    public boolean isRemote() {
        return remote;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "language=" + language +
                ", fio='" + fio + '\'' +
                ", salary=" + salary +
                ", remote=" + remote +
                '}';
    }
}
