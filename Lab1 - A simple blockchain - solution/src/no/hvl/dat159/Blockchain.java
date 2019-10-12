package no.hvl.dat159;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {

	private int miningDifficulty; //Number of leading (binary) 0s.
	private String miningTarget;  //A regular expression with a number of leading (binary) 0s.
	
	private List<Block> listOfBlocks = new ArrayList<>();
	
	public Blockchain(int miningDifficulty) {
		this.miningDifficulty = miningDifficulty;
		this.miningTarget = "^0{" + miningDifficulty + "}(0|1){" + (256-miningDifficulty) + "}";
	}
	
	public String getHashLastBlock() {
		return listOfBlocks.isEmpty() ? "0" 
				: listOfBlocks.get(listOfBlocks.size()-1).getHashAsHexString();
	}

	public boolean validateAndAppendNewBlock(Block b) {
		if (b.isValidAsNextBlock(getHashLastBlock(), miningTarget)) {
			listOfBlocks.add(b);
			return true;
		}
		return false;
	}
	
	public boolean isValidChain() {
		for (int i = 0; i < listOfBlocks.size(); i++) {
			Block block = listOfBlocks.get(i);
			String hashLastBlock = i==0 ? "0" : listOfBlocks.get(i-1).getHashAsHexString();
			if (!block.isValidAsNextBlock(hashLastBlock, miningTarget)) {
				return false;
			}
		}
		return true;
	}

	public int getMiningDifficulty() {
		return miningDifficulty;
	}

	public String getMiningTarget() {
		return miningTarget;
	}

	public List<Block> getListOfBlocks() {
		return listOfBlocks;
	}

}
