import java.util.*;

public class Blockchain extends Miner {

    private static final int BLOCK_SIZE = 10;
    private List<Block> chain = new ArrayList<>();

    public Blockchain() {
        Block genesis = new Block();
        this.chain.add(genesis);
    }

    public void printBlocks() {
        for (int i = 0; i < this.chain.size(); i++) {
            System.out.println(this.chain.get(i));
        }
    }

    public Block createBlock() {
        Block newBlock = new Block();
        newBlock.setIndex(this.chain.size());
        String prevHash = lastBlock().getHash();
        newBlock.setPrevHash(prevHash);
        return newBlock;
    }

    public String addBlock(Block block) {
        this.chain.add(block);
        if (!validateChain()) {
            this.chain.remove(lastBlock());
            throw new RuntimeException("Invalid Block!");
        }
        return Miner.proofOfWork(block);
    }

    private Block lastBlock() {
        return this.chain.get(this.chain.size()-1);
    }

    public boolean validateChain() {
        for (int i = 1; i < this.chain.size(); i++) {
            Block curr = this.chain.get(i);
            Block prev = this.chain.get(i-1);
            if (!curr.getHash().equals(curr.generateHash())) {
                return false;
            }
            if (!curr.getPrevHash().equals(prev.generateHash())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}
