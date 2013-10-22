package figury;

import commons.Constants;

public class Wieza extends Figura {

	private static final long serialVersionUID = 4998903524212138062L;
	
	public Wieza(Kolor kolor) {
		super(kolor);
		
		if(kolor == Kolor.BIALY){
			super.setImage(Constants.BIALA_WIEZA_OBRAZEK);
		}
		else if(kolor == Kolor.CZARNY){
			super.setImage(Constants.CZARNA_WIEZA_OBRAZEK);
		}
	}
	public String coJestes(){
		return "Wieza";
	}

}
