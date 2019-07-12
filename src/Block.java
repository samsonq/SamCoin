import java.util.*;

public class Block {

    //private List<T> transactions = new LinkedList<>();
    private int index; //block index
    private long timeStamp; //time in epoch (seconds since 1 Jan 1970)
    private String hash; //hash of this block
    private String prevHash; //hash of previous block
    private String nonce; //value that needs to be mined

    public void computeHash() {

    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
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
}
