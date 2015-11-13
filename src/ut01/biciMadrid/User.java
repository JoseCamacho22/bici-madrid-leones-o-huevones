package ut01.biciMadrid;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int key; //4b
    private String name; // 20 characters Max 40b 
    private String last_name; // 20 characters Max 40b
    private String dni; // 9 characters 18b
    private boolean subscriber; // si está abonado 1b
    private String address; // 40 characters Max 80b
    private double credit; //saldo 8b
    
    User(){
    	
    }

	public User(int key, String name, String last_name, String dni, boolean subscriber, String address, double credit) {
		this.key = key;
		this.name = name;
		this.last_name = last_name;
		this.dni = dni;
		this.subscriber = subscriber;
		this.address = address;
		this.credit = credit;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isSubscriber() {
		return subscriber;
	}

	public void setSubscriber(boolean subscriber) {
		this.subscriber = subscriber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}
    
	@Override
	public String toString() {
		return "User [key=" + key + ", name=" + name + ", lastname= " + last_name + ", dni= " + dni + " subscriber= " 
	+subscriber+ " address= " +address+ " credit= " +credit+"]";
	}
}
