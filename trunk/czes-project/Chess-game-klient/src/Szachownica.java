import java.util.ArrayList;
import java.util.List;

import figury.Figura;
import figury.PustaFigura;
import commons.Constants;

public class Szachownica {

	private List<Pole> pola;

	public Szachownica() {
		pola = new ArrayList<Pole>(Constants.ILOSC_POL);
	}

	public void zamien(Pole p1, Pole p2) {
		p2.ustawFigure(p1.pobierzFigure());
		p1.ustawFigure(new PustaFigura());
	}

	public void czySzach() {

	}

	public void czyMat() {

	}

	public ArrayList<Integer> sprawdzanePola(Pole pole_start) {
		return pole_start.pobierzFigure().mozliweRuchy(pole_start.pobierzX(),
				pole_start.pobierzY());
	}

	public boolean sprawdzRuch(int x) {
		Pole pole_start = pola.get(x);
		ArrayList<Integer> tablica = sprawdzanePola(pole_start);
		// Tutaj jeszcze kilka rzeczy do sprawdzenia, czy taki sam kolor maja
		// pionki, czy jest to pion, czy krol nie wystawi sie na szach, czy pion
		// nie przekroczy granicy, czy mozliwa roszada
		return true;

	}
}
