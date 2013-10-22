package figury;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Figura implements Serializable{

	private static final long serialVersionUID = -7025810851788967103L;
	protected Kolor kolor;

	public abstract ArrayList<Integer> mozliweRuchy(int x, int y);

	public Figura(Kolor kolor) {
		this.kolor = kolor;
	}

	public Kolor pobierzKolor() {
		return this.kolor;
	}

	public boolean czyPionek() {
		return false;
	}
	
	public boolean czyKrol() {
		return false;
	}
	
	public String coJestes(){
		return "Nie wiem";
	}
}
