package figury;

import java.util.ArrayList;

public class Krol extends Figura {

	private static final long serialVersionUID = -4753976603867256403L;
	
	public Krol(Kolor kolor) {
		super(kolor);
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
			nowa = y * 8 + x;
			tablica.add(nowa);
		}

		// PIERWSZY SKOS MALEJACO
		if (x - 1 > 0 && y - 1 > 0) {
			nowa = (y - 2) * 8 + x - 2;
			tablica.add(nowa);
		}

		// DRUGI SKOS ROSNACO
		if (x - 1 > 0 && y + 1 < 9) {
			nowa = y * 8 + x - 2;
			tablica.add(nowa);
		}

		// DRUGI SKOS MALEJACO
		if (x + 1 < 9 && y - 1 > 0) {
			nowa = (y - 2) * 8 + x;
			tablica.add(nowa);
		}

		// POZIOMO W GORE
		if (x + 1 < 9) {
			nowa = (y - 1) * 8 + x;
			tablica.add(nowa);
		}
		// POZIOMO W DOL
		if (x - 1 > 0) {
			nowa = (y - 1) * 8 + x - 2;
			tablica.add(nowa);
		}
		// PIONOWO W GORE
		if (y + 1 < 9) {
			nowa = y * 8 + x - 1;
			tablica.add(nowa);
		}
		// PIONOWO W DOL
		if (y - 1 > 0) {
			nowa = (y - 2) * 8 + x - 1;
			tablica.add(nowa);
		}

		return tablica;
	}
	
	public boolean czyKrol() {
		return true;
	}

}