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

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", Имя: " + name +
                ", Город: " + city +
                ", Виды штрафов: " + ticketType.getTicketType();
    }
}
