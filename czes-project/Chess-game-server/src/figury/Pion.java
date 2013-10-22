package figury;

import java.util.ArrayList;

public class Pion extends Figura {

	private static final long serialVersionUID = -705828682495989647L;
	
	public Pion(Kolor kolor) {
		super(kolor);
	}

	public String coJestes(){
		return "Pion";
	}
	@Override
	public ArrayList<Integer> mozliweRuchy(int x, int y) {
		ArrayList<Integer> tablica = new ArrayList<Integer>(); // nieistotne, wszystko zapisane w szachownicy
		return tablica;
	}

	public boolean czyPionek() {
		// TODO Auto-generated method stub
		return true;
	}

}
