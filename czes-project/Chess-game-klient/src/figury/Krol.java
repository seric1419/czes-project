package figury;

import commons.Constants;

public class Krol extends Figura {

	private static final long serialVersionUID = -4753976603867256403L;

	public Krol(Kolor kolor) {
		super(kolor);
		
		if(kolor == Kolor.BIALY){
			super.setImage(Constants.BIALY_KROL_OBRAZEK);
		}
		else if(kolor == Kolor.CZARNY){
			super.setImage(Constants.CZARNY_KROL_OBRAZEK);
		}
	}

	public String coJestes(){
		return "Krol";
	}
	
	public boolean czyKrol() {
		return true;
	}

}
