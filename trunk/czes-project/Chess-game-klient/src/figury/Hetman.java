package figury;

import commons.Constants;

public class Hetman extends Figura {

	private static final long serialVersionUID = 4876493199274787356L;

	public Hetman(Kolor kolor) {
		super(kolor);
		
		if(kolor == Kolor.BIALY){
			super.setImage(Constants.BIALA_HETMAN_OBRAZEK);
		}
		else if(kolor == Kolor.CZARNY){
			super.setImage(Constants.CZARNY_HETMAN_OBRAZEK);
		}
	}

	public String coJestes(){
		return "Hetman";
	}
}
