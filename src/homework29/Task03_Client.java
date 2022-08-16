package homework29;

import java.util.Objects;

public class Task03_Client {
    private String address;
    private int priority;

    public Task03_Client(String address, int priority) {
        this.address = address;
        this.priority = priority;
    }

    public String getAddress() {
        return address;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Client{" +
                "address='" + address + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task03_Client client = (Task03_Client) o;
        return priority == client.priority && Objects.equals(address, client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, priority);
    }
}
