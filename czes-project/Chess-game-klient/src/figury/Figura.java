package figury;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Figura {
	protected Kolor kolor;
	protected BufferedImage image;

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
	
	public boolean czyKrol() {
		return false;
	}

	public BufferedImage pobierzObrazek() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public String coJestes(){
		return "Nie wiem";
	}
}
