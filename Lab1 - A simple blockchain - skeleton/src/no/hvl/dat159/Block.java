package no.hvl.dat159;

public class Block {

	private long nonce;	 // The nonce for this block.
	private String data; // The data for this block.
	private String prev; // The hash of the previous block in the blockchain.

	public Block(String hashLastBlock) {
		// TODO
		// Initializing *ALL* the instance variables to a valid state.
		// The nonce can be 0. No mining required at this stage.
	}
	
	public boolean isValidAsNextBlock(String hashLastBlock, String miningTarget) {
		// TODO
		// A complete validation of the block, including prev matching
		// the hash of the last block in the blockchain, and that the block is
		// mined according to the mining target.
		return false;
	}
	
	// getters, setters and a nice toString()-method
	
	private String calculateHash() {
		// TODO
		// Calculating the hash for this block based on the other instance variables.
		// The hash is returned as a HEX-String.
		return null;
	}

}
