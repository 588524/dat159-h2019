package no.hvl.dat159;

public class Miner {
	
	private Blockchain chain;
	
	public Miner(Blockchain chain) {
		this.chain = chain;
	}

	public Block createAndMineNewBlock(String data) {
		// TODO
		// Create a new block and mine with the goal of appending to the chain.
		// Given the miningTarget, mine until the calculated hash matches the target.
		// The target is a regular expression, for example "^0{5}.*" which implies
		// that the hash must start with 5 zeros.
		// Return the mined block.
		return null;
	}		
		
}
