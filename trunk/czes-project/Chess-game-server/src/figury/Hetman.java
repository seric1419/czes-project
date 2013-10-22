package figury;

import java.util.ArrayList;

public class Hetman extends Figura {

	private static final long serialVersionUID = 4876493199274787356L;
	
	public Hetman(Kolor kolor) {
		super(kolor);
	}

	public String coJestes(){
		return "Hetman";
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

		// POZIOMO W GORE
		p = x + 1;
		r = y;
		while (p < 9) {
			nowa = (r-1) * 8 + p-1;
			tablica.add(nowa);
			p++;
		}
		// POZIOMO W DOL
		p = x - 1;
		r = y;
		while (p > 0) {
			nowa = (r-1) * 8 + p-1;
			tablica.add(nowa);
			p--;
		}
		// PIONOWO W GORE
		p = x;
		r = y + 1;
		while (r < 9) {
			nowa = (r-1) * 8 + p-1;
			tablica.add(nowa);
			r++;
		}
		// PIONOWO W DOL
		p = x;
		r = y - 1;
		while (r > 0) {
			nowa = (r-1) * 8 + p-1;
			tablica.add(nowa);
			r--;
		}

		return tablica;
	}
}