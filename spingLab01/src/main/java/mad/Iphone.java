package mad;

public class Iphone implements CellPhone {
    @Override
    public void incomingCall() {
        System.out.println("Принят входящий вызов на iPhone");
    }

    @Override
    public void outgoingCall() {

    }
}
