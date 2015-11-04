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
	private Date startTime;
	private Date endTime;
	
	Order(){
		
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	

}
