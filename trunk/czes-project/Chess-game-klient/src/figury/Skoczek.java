package figury;

import java.util.ArrayList;

public class Skoczek extends Figura {

	public Skoczek(Kolor kolor) {
		super(kolor);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Integer> mozliweRuchy(int x, int y) {
		ArrayList<Integer> tablica = new ArrayList<Integer>();

		int nowa; // w niej zapisujemy zmienna gotowa do przekazania do
					// arraylisty

		// DLA SKOCZKA ROZPATRUJEMY 8 PRZYPADKOW:

		// 1.
		int p = x + 2; // zmienne pomocnicze
		int r = y + 1;
		if (p < 9 && r < 9) {
			nowa = p * 10 + r;
			tablica.add(nowa);
		}
		// 2.
		p = x - 2; // zmienne pomocnicze
		r = y + 1;
		if (p > 0 && r < 9) {
			nowa = p * 10 + r;
			tablica.add(nowa);
		}

		// 3.
		p = x + 2; // zmienne pomocnicze
		r = y - 1;
		if (p < 9 && r > 0) {
			nowa = p * 10 + r;
			tablica.add(nowa);
		}

		// 4.
		p = x - 2; // zmienne pomocnicze
		r = y - 1;
		if (p > 0 && r > 0) {
			nowa = p * 10 + r;
			tablica.add(nowa);
		}

		// 5.
		p = x + 1; // zmienne pomocnicze
		r = y + 2;
		if (p < 9 && r < 9) {
			nowa = p * 10 + r;
			tablica.add(nowa);
		}

		// 6.
		p = x + 1; // zmienne pomocnicze
		r = y - 2;
		if (p < 9 && r > 0) {
			nowa = p * 10 + r;
			tablica.add(nowa);
		}

		// 7.
		p = x - 1; // zmienne pomocnicze
		r = y + 2;
		if (p > 0 && r < 9) {
			nowa = p * 10 + r;
			tablica.add(nowa);
		}

		// 8.
		p = x - 1; // zmienne pomocnicze
		r = y - 2;
		if (p > 0 && r > 0) {
			nowa = p * 10 + r;
			tablica.add(nowa);
		}

		return tablica;
	}

}
