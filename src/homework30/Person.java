package homework30;

public class Person {
    private int id;
    private String name;
    private String city;
    private TicketType ticketType;

    public Person(int id, String name, String city, TicketType ticketType) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.ticketType = ticketType;
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
        return  "id=" + id +
                ", Имя: " + name +
                ", Город: " + city +
                ", Виды штрафов: " + ticketType.getTicketType();
    }
}
