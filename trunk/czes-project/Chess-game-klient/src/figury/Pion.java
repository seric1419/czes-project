package figury;

import commons.Constants;

public class Pion extends Figura {

	private static final long serialVersionUID = -705828682495989647L;

	public Pion(Kolor kolor) {
		super(kolor);
		
		if(kolor == Kolor.BIALY){
			super.setImage(Constants.BIALY_PION_OBRAZEK);
		}
		else if(kolor == Kolor.CZARNY){
			super.setImage(Constants.CZARNY_PION_OBRAZEK);
		}
	}

	public String coJestes(){
		return "Pion";
	}

	public boolean czyPionek() {
		// TODO Auto-generated method stub
		return true;
	}

}
