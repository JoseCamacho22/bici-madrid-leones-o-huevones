package ut01.biciMadrid;

import java.io.Serializable;

public class Totem implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int key;
	private String address;
	private int maxNumBikes;
	private int numAnchorBikes;
	
	Totem(){
		
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMaxNumBikes() {
		return maxNumBikes;
	}

	public void setMaxNumBikes(int maxNumBikes) {
		this.maxNumBikes = maxNumBikes;
	}

	public int getNumAnchorBikes() {
		return numAnchorBikes;
	}

	public void setNumAnchorBikes(int numAnchorBikes) {
		this.numAnchorBikes = numAnchorBikes;
	}
	
	
	
}
