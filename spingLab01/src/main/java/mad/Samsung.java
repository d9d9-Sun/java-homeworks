package mad;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Samsung implements CellPhone {
    @Value("${outgoing.number}")
    private String outgoingNumber;

    @Override
    public void incomingCall() {
        System.out.println("Входящий звонок на Samsung");
    }

    @Override
    public void outgoingCall() {
        System.out.println("Звонок на номер " + outgoingNumber);
        Iphone iphone = new Iphone();
        iphone.incomingCall();
    }
}
