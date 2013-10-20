package figury;

import java.util.ArrayList;

public class PustaFigura extends Figura {

	public PustaFigura() {
		super(Kolor.BRAK);

	}

	public ArrayList<Integer> mozliweRuchy(int x, int y) {

		ArrayList<Integer> tablica = new ArrayList<Integer>();
		return tablica;
	}
	public String coJestes(){
		return "Pusta";
	}

}
