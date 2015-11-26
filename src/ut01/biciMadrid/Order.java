package ut01.biciMadrid;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userKey;
	private int bikeKey;
	private double totalCost;
	private String startTotem;
	private String endTotem;
	private String startTime;
	private String endTime;
	
	Order(){
		
	}
	
	public Order(int userKey, int bikeKey, double totalCost, String startTotem, String endTotem, String startTime,
			String endTime) {
		super();
		this.userKey = userKey;
		this.bikeKey = bikeKey;
		this.totalCost = totalCost;
		this.startTotem = startTotem;
		this.endTotem = endTotem;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getUserKey() {
		return userKey;
	}
	public void setUserKey(int userKey) {
		this.userKey = userKey;
	}
	public int getBikeKey() {
		return bikeKey;
	}
	public void setBikeKey(int bikeKey) {
		this.bikeKey = bikeKey;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public String getStartTotem() {
		return startTotem;
	}
	public void setStartTotem(String startTotem) {
		this.startTotem = startTotem;
	}
	public String getEndTotem() {
		return endTotem;
	}
	public void setEndTotem(String endTotem) {
		this.endTotem = endTotem;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String Endtime) {
		this.endTime = Endtime;
	}

	@Override
	public String toString() {
		return "Order [userKey=" + userKey + ", bikeKey=" + bikeKey + ", totalCost=" + totalCost + ", startTotem="
				+ startTotem + ", endTotem=" + endTotem + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
	

}
