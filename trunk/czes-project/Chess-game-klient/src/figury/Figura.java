package figury;

import java.util.ArrayList;

public abstract class Figura {
	protected Kolor kolor;

	public abstract ArrayList<Integer> mozliweRuchy(int x, int y);

	public Figura(Kolor kolor) {
		this.kolor = kolor;
	}

	public Kolor pobierzKolor() {
		return this.kolor;
	}

	public boolean czyPionek() {
		return false;
	}

}
