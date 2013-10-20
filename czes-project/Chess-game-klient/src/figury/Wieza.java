package figury;

import java.util.ArrayList;

import commons.Constants;

public class Wieza extends Figura {

	public Wieza(Kolor kolor) {
		super(kolor);
		
		if(kolor == Kolor.BIALY){
			super.setImage(Constants.BIALA_WIEZA_OBRAZEK);
		}
		else if(kolor == Kolor.CZARNY){
			super.setImage(Constants.CZARNA_WIEZA_OBRAZEK);
		}
	}
	public String coJestes(){
		return "Wieza";
	}

	public ArrayList<Integer> mozliweRuchy(int x, int y) {

		ArrayList<Integer> tablica = new ArrayList<Integer>();

		int nowa; // w niej zapisujemy zmienna gotowa do przekazania do
					// arraylisty
		// POZIOMO W GORE
		int p = x + 1;
		int r = y;
		while (p < 9) {
			// do tablicy przekazujemy p*10 + r, pozniej uzyskamy dzielac przez
			// 10
			nowa = p * 8 + r;
			tablica.add(nowa);
			p++;
		}
		// POZIOMO W DOL
		p = x - 1;
		r = y;
		while (p > 0) {
			// do tablicy przekazujemy p*10 + r, pozniej uzyskamy dzielac przez
			// 10
			nowa = p * 8 + r;
			tablica.add(nowa);
			p--;
		}
		// PIONOWO W GORE
		p = x;
		r = y + 1;
		while (r < 9) {
			// do tablicy przekazujemy p*10 + r, pozniej uzyskamy dzielac przez
			// 10
			nowa = p * 8 + r;
			tablica.add(nowa);
			r++;
		}
		// PIONOWO W DOL
		p = x;
		r = y - 1;
		while (r > 0) {
			// do tablicy przekazujemy p*10 + r, pozniej uzyskamy dzielac przez
			// 10
			nowa = p * 8 + r;
			tablica.add(nowa);
			r--;
		}

		return tablica;
	};

}
