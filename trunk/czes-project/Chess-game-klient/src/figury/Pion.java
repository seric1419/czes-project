package figury;

import java.util.ArrayList;

public class Pion extends Figura {

	public Pion(Kolor kolor) {
		super(kolor);
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
