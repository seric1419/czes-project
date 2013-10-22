package figury;

import commons.Constants;

public class Skoczek extends Figura {

	private static final long serialVersionUID = -7719501471555673776L;
	
	public Skoczek(Kolor kolor) {
		super(kolor);
		
		if(kolor == Kolor.BIALY){
			super.setImage(Constants.BIALY_KON_OBRAZEK);
		}
		else if(kolor == Kolor.CZARNY){
			super.setImage(Constants.CZARNY_KON_OBRAZEK);
		}
	}
	public String coJestes(){
		return "Skoczek";
	}

}
