import java.util.*;

public class Blockchain {

    private static final int BLOCK_SIZE = 10;
    private List<Block> chain = new ArrayList<>();

    public Blockchain() {
        Block genesis = new Block();
        genesis.setHash("root");
        this.chain.add(genesis);
    }

    public Block createBlock() {
        Block newBlock = new Block();
        newBlock.setTimeStamp(System.currentTimeMillis());
        newBlock.setIndex(this.chain.size());
        String prevHash = this.chain.get(this.chain.size()-1).getHash();
        newBlock.setPrevHash(prevHash);
        return newBlock;
    }
}
