import java.util.*;

public class Blockchain {

    private static final int BLOCK_SIZE = 10;
    private List<Block> chain = new ArrayList<>();

    public Blockchain() {
        Block genesis = new Block();
        this.chain.add(genesis);
    }

    public Block addBlock() {
        Block newBlock = new Block();
        return newBlock;
    }
}
