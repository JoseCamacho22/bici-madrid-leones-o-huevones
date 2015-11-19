package ut01.biciMadrid;

import java.io.Serializable;

public class Bike implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	private int key;
	private boolean activa;
    private boolean alquilada;
    private int totemKey;
    
    Bike(){
    	
    }
    
    
    
	public Bike(int key, boolean activa, boolean alquilada, int totemKey) {
		this.key = key;
		this.activa = activa;
		this.alquilada = alquilada;
		this.totemKey = totemKey;
	}



	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	public boolean isAlquilada() {
		return alquilada;
	}
	public void setAlquilada(boolean alquilada) {
		this.alquilada = alquilada;
	}
	public int getTotem() {
		return totemKey;
	}
	public void setTotem(int totemKey) {
		this.totemKey = totemKey;
	}


	@Override
	public String toString() {
		return "Bike [key=" + key + ", activa=" + activa + ", alquilada=" + alquilada + ", totemKey=" + totemKey + "]";
	}
}
