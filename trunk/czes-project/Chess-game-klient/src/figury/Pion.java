package figury;

import java.util.ArrayList;

import commons.Constants;

public class Pion extends Figura {

	public Pion(Kolor kolor) {
		super(kolor);
		
		if(kolor == Kolor.BIALY){
			super.setImage(Constants.BIALY_PION_OBRAZEK);
		}
		else if(kolor == Kolor.CZARNY){
			super.setImage(Constants.CZARNY_PION_OBRAZEK);
		}
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
