import java.util.*;

public class Blockchain {

    private static final int BLOCK_SIZE = 10;
    private List<Block> chain = new ArrayList<>();

    public Blockchain() {
        Block genesis = new Block();
        //genesis.setHash("root");
        this.chain.add(genesis);
    }

    public void printBlocks() {
        for (int i = 0; i < this.chain.size(); i++) {
            System.out.println(this.chain.get(i));
        }
    }

    public Block createBlock() {
        Block newBlock = new Block();
        //newBlock.setTimeStamp(System.currentTimeMillis());
        newBlock.setIndex(this.chain.size());
        String prevHash = lastBlock().getHash();
        newBlock.setPrevHash(prevHash);
        return newBlock;
    }

    public void addBlock(Block block) {
        Block curr = block;
        /*
        for (int i = this.chain.size()-1; i >= 0; i--) {
            if (this.chain.get(i).getHash().equals(curr.getHash())) {
                curr = this.chain.get(i);
            } else {
                throw new RuntimeException("Block Invalid!");
            }
        }
        */
        String proof = proofOfWork(block);
        this.chain.add(block);
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

    public String proofOfWork(Block block) {
        String nonce = block.getNonce();
        long temp = 0;
        boolean found = false;
        String hash = "";

        return "";
    }
}
