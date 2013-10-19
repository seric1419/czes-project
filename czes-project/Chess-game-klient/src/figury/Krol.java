package figury;

import java.util.ArrayList;

public class Krol extends Figura {

	Krol(Kolor kolor) {
		super(kolor);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Integer> mozliweRuchy(int x, int y) {

		ArrayList<Integer> tablica = new ArrayList<Integer>();

		int nowa; // w niej zapisujemy zmienna gotowa do przekazania do
					// arraylisty

		// PIERWSZY SKOS ROSNACO
		if (x + 1 < 9 && y + 1 < 9) {
			nowa = (x + 1) * 10 + y + 1;
			tablica.add(nowa);
		}

		// PIERWSZY SKOS MALEJACO
		if (x - 1 > 0 && y - 1 > 0) {
			nowa = (x - 1) * 10 + y - 1;
			tablica.add(nowa);
		}

		// DRUGI SKOS ROSNACO
		if (x - 1 > 0 && y + 1 < 9) {
			nowa = (x - 1) * 10 + y + 1;
			tablica.add(nowa);
		}

		// DRUGI SKOS MALEJACO
		if (x + 1 < 9 && y - 1 < 0) {
			nowa = (x + 1) * 10 + y - 1;
			tablica.add(nowa);
		}

		// POZIOMO W GORE
		if (x + 1 < 9) {
			nowa = (x + 1) * 10 + y;
			tablica.add(nowa);
		}
		// POZIOMO W DOL
		if (x - 1 > 0) {
			nowa = (x - 1) * 10 + y;
			tablica.add(nowa);
		}
		// PIONOWO W GORE
		if (y + 1 < 9) {
			nowa = x * 10 + y + 1;
			tablica.add(nowa);
		}
		// PIONOWO W DOL
		if (y - 1 > 0) {
			nowa = x * 10 + y - 1;
			tablica.add(nowa);
		}

		return tablica;
	}

}
