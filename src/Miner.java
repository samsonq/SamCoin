public class Miner {

    private String proofOfWork(Block block) {
        String key = block.getNonce();
        long nonce = 0;
        boolean found = false;
        String hash = "";

        String content = block.getTimeStamp().toString() + block.getIndex() + block.getPrevHash();

        while (!found) {
            hash = SHA256.generateHash(content + nonce);
            found = hash.substring(0, key.length()).equals(key);
            nonce++;
        }

        return hash;
    }
}
