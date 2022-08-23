package homework30;

public class Person {
    private int id;
    private String name;
    private String city;
    private TicketType ticketType;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", ticketType=" + ticketType +
                '}';
    }
}
