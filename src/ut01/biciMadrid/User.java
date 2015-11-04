package ut01.biciMadrid;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int key;
    private String name; // 20 characters Max
    private String last_name; // 20 characters Max
    private String dni;
    private boolean subscriber; // si está abonado
    private String address; // 40 characters Max
    private double credit; //saldo
    
    User(){
    	
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
    
    
}
