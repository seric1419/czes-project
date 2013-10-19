package figury;

import java.util.ArrayList;

public class Pion extends Figura {

	Pion(Kolor kolor) {
		super(kolor);
	}

	@Override
	public ArrayList<Integer> mozliweRuchy(int x, int y) {
		ArrayList<Integer> tablica = new ArrayList<Integer>();
		int nowa;
		if (kolor.equals(Kolor.BIALY))
			if (x + 1 < 9) {
				nowa = 10 * (x + 1) + y;
				tablica.add(nowa);
			} else if (kolor.equals(Kolor.CZARNY))
				if (x - 1 > 0) {
					nowa = 10 * (x - 1) + y;
					tablica.add(nowa);
				}
		return tablica;
	}

	public ArrayList<Integer> mozliweBicia(int x, int y) {
		ArrayList<Integer> tablica = new ArrayList<Integer>();
		int nowa;

		if (kolor.equals(Kolor.BIALY)) {
			if (x + 1 < 9 && y + 1 < 9) {
				nowa = 10 * (x + 1) + y + 1;
				tablica.add(nowa);
			}
			if (x + 1 < 9 && y - 1 > 0) {
				nowa = 10 * (x + 1) + y - 1;
				tablica.add(nowa);
			}
		} else if (kolor.equals(Kolor.CZARNY)) {
			if (x - 1 > 0 && y - 1 > 0) {
				nowa = 10 * (x - 1) + y - 1;
				tablica.add(nowa);
			}
			if (x - 1 > 0 && y + 1 > 0) {
				nowa = 10 * (x - 1) + y + 1;
				tablica.add(nowa);
			}
		}
		return tablica;
	}

	public boolean czyPionek() {
		// TODO Auto-generated method stub
		return true;
	}

}
