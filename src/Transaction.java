import java.util.*;
import java.sql.Timestamp;

public class Transaction {

    private Client sender;
    private Client recipient;
    private float value;
    private Timestamp time;

    public Transaction(Client sender, Client recipient, float value) {
        this.sender = sender;
        this.recipient = recipient;
        this.value = value;
        this.time = new Timestamp(System.currentTimeMillis());
    }

    public Client getSender() {
        return this.sender;
    }

    public Client getRecipient() {
        return this.recipient;
    }

    public float getValue() {
        return this.value;
    }

    public Timestamp getTime() {
        return this.time;
    }
}
