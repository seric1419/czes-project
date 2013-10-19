package figury;

import java.util.ArrayList;

public class Goniec extends Figura {

	Goniec(Kolor kolor) {
		super(kolor);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Integer> mozliweRuchy(int x, int y) {

		ArrayList<Integer> tablica = new ArrayList<Integer>();

		int nowa; // w niej zapisujemy zmienna gotowa do przekazania do
					// arraylisty

		int p = x + 1; // zmienne pomocnicze
		int r = y + 1;
		// PIERWSZY SKOS ROSNACO
		while (p < 9 && r < 9) {
			// do tablicy przekazujemy p*10 + r, pozniej uzyskamy dzielac przez
			// 10
			nowa = p * 10 + r;
			tablica.add(nowa);
			p++;
			r++;
		}

		p = x - 1;
		r = y - 1;
		// PIERWSZY SKOS MALEJACO
		while (p > 0 && r > 0) {
			// do tablicy przekazujemy p*10 + r, pozniej uzyskamy dzielac przez
			// 10
			nowa = p * 10 + r;
			tablica.add(nowa);
			p--;
			r--;
		}

		p = x - 1;
		r = y + 1;
		// DRUGI SKOS ROSNACO
		while (p > 0 && r < 9) {
			// do tablicy przekazujemy p*10 + r, pozniej uzyskamy dzielac przez
			// 10
			nowa = p * 10 + r;
			tablica.add(nowa);
			p--;
			r++;
		}

		p = x + 1;
		r = y - 1;
		// DRUGI SKOS MALEJACO
		while (p < 9 && r > 0) {
			// do tablicy przekazujemy p*10 + r, pozniej uzyskamy dzielac przez
			// 10
			nowa = p * 10 + r;
			tablica.add(nowa);
			p++;
			r--;
		}

		return tablica;
	}

}
