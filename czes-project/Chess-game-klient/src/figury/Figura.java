package figury;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public abstract class Figura implements Serializable{
	
	private static final long serialVersionUID = -7025810851788967103L;
	protected Kolor kolor;
	protected BufferedImage image;

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
