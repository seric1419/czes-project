package figury;

import java.util.ArrayList;

import commons.Constants;

public class Krol extends Figura {

	public Krol(Kolor kolor) {
		super(kolor);
		
		if(kolor == Kolor.BIALY){
			super.setImage(Constants.BIALY_KROL_OBRAZEK);
		}
		else if(kolor == Kolor.CZARNY){
			super.setImage(Constants.CZARNY_KROL_OBRAZEK);
		}
	}

	public String coJestes(){
		return "Krol";
	}
	public ArrayList<Integer> mozliweRuchy(int x, int y) {

		ArrayList<Integer> tablica = new ArrayList<Integer>();

		int nowa; // w niej zapisujemy zmienna gotowa do przekazania do
					// arraylisty

		// PIERWSZY SKOS ROSNACO
		if (x + 1 < 9 && y + 1 < 9) {
			nowa = (x + 1) * 8 + y + 1;
			tablica.add(nowa);
		}

		// PIERWSZY SKOS MALEJACO
		if (x - 1 > 0 && y - 1 > 0) {
			nowa = (x - 1) * 8 + y - 1;
			tablica.add(nowa);
		}

		// DRUGI SKOS ROSNACO
		if (x - 1 > 0 && y + 1 < 9) {
			nowa = (x - 1) * 8 + y + 1;
			tablica.add(nowa);
		}

		// DRUGI SKOS MALEJACO
		if (x + 1 < 9 && y - 1 < 0) {
			nowa = (x + 1) * 8 + y - 1;
			tablica.add(nowa);
		}

		// POZIOMO W GORE
		if (x + 1 < 9) {
			nowa = (x + 1) * 8 + y;
			tablica.add(nowa);
		}
		// POZIOMO W DOL
		if (x - 1 > 0) {
			nowa = (x - 1) * 8 + y;
			tablica.add(nowa);
		}
		// PIONOWO W GORE
		if (y + 1 < 9) {
			nowa = x * 8 + y + 1;
			tablica.add(nowa);
		}
		// PIONOWO W DOL
		if (y - 1 > 0) {
			nowa = x * 8 + y - 1;
			tablica.add(nowa);
		}

		return tablica;
	}
	
	public boolean czyKrol() {
		return true;
	}

}
