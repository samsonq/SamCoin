import java.util.*;

public class Blockchain<T> {

    private static final int BLOCK_SIZE = 10;
    private List<Block<T>> chain = new ArrayList<>();

    public Blockchain() {
        Block genesis = new Block();
        genesis.setHash("root");
        this.chain.add(genesis);
    }

    public Block createBlock() {
        Block newBlock = new Block();
        newBlock.setTimeStamp(System.currentTimeMillis());
        newBlock.setIndex(this.chain.size());
        String prevHash = lastBlock().getHash();
        newBlock.setPrevHash(prevHash);
        return newBlock;
    }

    public void addBlock(Block<T> block) {
        Block<T> curr = block;
        for (int i = this.chain.size()-1; i >= 0; i--) {
            if (this.chain.get(i).getHash().equals(curr.getHash())) {
                curr = this.chain.get(i);
            } else {
                throw new RuntimeException("Block Invalid!");
            }
        }
        this.chain.add(block);
    }

    private Block lastBlock() {
        return this.chain.get(this.chain.size()-1);
    }
}
