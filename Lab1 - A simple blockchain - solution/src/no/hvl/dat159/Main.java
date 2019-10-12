package no.hvl.dat159;

import java.time.Duration;
import java.time.Instant;

public class Main {
	
	public static void main(String[] args) {
		
		int MINING_DIFFICULTY = 20; //Minimum number of leading zeros in (binary) block hash
		
		Blockchain blockchain = new Blockchain(MINING_DIFFICULTY);
		Miner miner = new Miner(blockchain);
		
		String[] dataForTheBlocks = {
				"Bla bla", "Ukebla", "Dette er gøy", "Halloen", 
				"På do", "Bitcoin er gøy!", "Dette er fremtiden",
				"Siste blokken"};

		Instant start = Instant.now();
		
		System.out.println("Mining difficulty: " + blockchain.getMiningDifficulty() 
				+ " leading (binary) 0s.");
		System.out.println();
		System.out.println("Building chain from scratch ... ");
		
		//Creating and appending the genesis block
		Block newBlock = miner.createAndMineNewBlock("Genesisblokken");
		blockchain.validateAndAppendNewBlock(newBlock);
		System.out.println("Genesis block: " + newBlock);
		
		//Creating and appending the the rest of the blocks
		for (int i=0; i<dataForTheBlocks.length; i++) {
			newBlock = miner.createAndMineNewBlock(dataForTheBlocks[i]);
			blockchain.validateAndAppendNewBlock(newBlock);
			System.out.println("Block " + (i+1) + ":       " + newBlock);
		}

		System.out.println("Build successful. " + (dataForTheBlocks.length+1) 
				+ " blocks added to the chain.");

		Instant finish = Instant.now();
		
		System.out.println("Mining time: " 
				+ StringUtil.formatDuration((Duration.between(start, finish))));
		System.out.println("Mining time in millis: " 
				+ Duration.between(start, finish).toMillis());
		System.out.println();

		start = Instant.now();

		System.out.println("Validating chain ... ");

		if (blockchain.isValidChain()) {
			System.out.println("Validation successful. The chain is valid!");
		} else {
			System.out.println("Invalid chain!");
		}

		finish = Instant.now();
		System.out.println("Validation time in millis: " 
				+ Duration.between(start, finish).toMillis());

	}
	
}
