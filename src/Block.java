import java.util.*;
import java.sql.Timestamp;

public class Block<T> {

    private List<T> transactions = new LinkedList<>();
    private int index; //block index
    private Timestamp timeStamp; //time in epoch (seconds since 1 Jan 1970)
    private String hash; //hash of this block
    private String prevHash; //hash of previous block
    private String nonce; //value that needs to be mined

    public Block() {
        this.nonce = "0000";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.timeStamp = timestamp;
        this.hash = generateHash();
    }

    public String getHash() {
        return this.hash;
    }

    public String generateHash() {
        String contents = this.timeStamp.toString() + this.transactions.toString() + this.nonce + this.prevHash;
        return SHA256.generateHash(contents);
    }
    //public void computeHash() {}

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPrevHash() {
        return this.prevHash;
    }
    
    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    public String getNonce() {
        return this.nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String toString() {
        return "Timestamp: " + this.timeStamp + " Transactions: " + this.transactions + " Current Hash: " + this.hash;
    }
}
