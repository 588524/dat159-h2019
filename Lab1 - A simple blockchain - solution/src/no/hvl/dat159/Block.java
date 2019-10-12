package no.hvl.dat159;

import static no.hvl.dat159.StringUtil.truncated;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.google.common.io.BaseEncoding;

public class Block {

	private long nonce;
	private String data;
	private String prev;

	public Block(String hashLastBlock) {
		this.data = "";
		this.nonce = 0;
		this.prev = hashLastBlock;
	}

	public void mine(String miningTarget) {
		nonce = 0;
		while (!getHashAsBinaryString().matches(miningTarget)) {
			nonce++;
		}
	}
	
	public boolean isValidAsNextBlock(String hashLastBlock, String miningTarget) {
		return prev.equals(hashLastBlock) // The prev pointer must point to the previous block
				&& getHashAsBinaryString().matches(miningTarget) // The block must be mined
				&& isValidData(); // The data in the block must be valid
	}
	
	private boolean isValidData() {
		return data != null;
	}

	public String getHashAsBinaryString() {
		return bytesToBinary(calculateHash());
	}

	public String getHashAsHexString() {
		return BaseEncoding.base16().encode(calculateHash());
	}
	
	public String getPreviousHash() {
		return prev;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public long getNonce() {
		return nonce;
	}

	public void setNonce(long nonce) {
		this.nonce = nonce;
	}

	@Override
	public String toString() {
		return String.format("Block [nonce=%-8d data=%-18s prev=%-31s hash=%-31s]", 
				nonce, data, truncated(prev,28), truncated(getHashAsHexString(),28));
	}

	private byte[] calculateHash() {
		
		String input = data + nonce + prev;

		byte[] hashAsBytes = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			hashAsBytes = digest.digest(input.getBytes("ISO-8859-1"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return hashAsBytes;

	}
	
	private String bytesToBinary(byte[] bytes) {
		String binaryString = "";
		for (byte b : bytes) {
			binaryString += String
					.format("%8s", Integer.toBinaryString(b & 0xFF))
					.replace(' ', '0');
		}
		return binaryString;
	}
}
