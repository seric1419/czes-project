package gra;
import java.io.Serializable;

import figury.Figura;

public class Pole implements Serializable{

	private static final long serialVersionUID = -7566188556025919518L;
	private Figura figura;
	private int wspol_x;
	private int wspol_y;
	
	public Pole(Figura figura, int x, int y) {
		this.figura = figura;
		this.wspol_x = x;
		this.wspol_y = y;
	}
	
	public void ustawFigure(Figura figura) {
		this.figura = figura;
	}

	public Figura pobierzFigure() {
		return figura;
	}

	public int pobierzX() {
		return wspol_x;
	}

	public int pobierzY() {
		return wspol_y;
	}
}
