package no.hvl.dat159;

public class Miner {
	
	private Blockchain chain;
	
	public Miner(Blockchain chain) {
		this.chain = chain;
	}

	public Block createAndMineNewBlock(String data) {
		Block b = new Block(chain.getHashLastBlock());
		b.setData(data);
		b.mine(chain.getMiningTarget());
		return b;
	}
		
}
