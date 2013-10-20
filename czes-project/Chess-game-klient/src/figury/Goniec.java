package figury;

import java.util.ArrayList;

import commons.Constants;

public class Goniec extends Figura {

	public Goniec(Kolor kolor) {
		super(kolor);
		
		if(kolor == Kolor.BIALY){
			super.setImage(Constants.BIALY_GONIEC_OBRAZEK);
		}
		else if(kolor == Kolor.CZARNY){
			super.setImage(Constants.CZARNY_GONIEC_OBRAZEK);
		}
	}

	public String coJestes(){
		return "Goniec";
	}
	public ArrayList<Integer> mozliweRuchy(int x, int y) {

		ArrayList<Integer> tablica = new ArrayList<Integer>();

		int nowa; // w niej zapisujemy zmienna gotowa do przekazania do
					// arraylisty

		int p = x + 1; // zmienne pomocnicze
		int r = y + 1;
		// PIERWSZY SKOS ROSNACO
		while (p < 9 && r < 9) {
			nowa = (r-1) * 8 + p-1;
			tablica.add(nowa);
			p++;
			r++;
		}

		p = x - 1;
		r = y - 1;
		// PIERWSZY SKOS MALEJACO
		while (p > 0 && r > 0) {
			nowa = (r-1) * 8 + p-1;
			tablica.add(nowa);
			p--;
			r--;
		}

		p = x - 1;
		r = y + 1;
		// DRUGI SKOS ROSNACO
		while (p > 0 && r < 9) {
			nowa = (r-1) * 8 + p-1;
			tablica.add(nowa);
			p--;
			r++;
		}

		p = x + 1;
		r = y - 1;
		// DRUGI SKOS MALEJACO
		while (p < 9 && r > 0) {
			nowa = (r-1) * 8 + p-1;
			tablica.add(nowa);
			p++;
			r--;
		}

		return tablica;
	}

}
