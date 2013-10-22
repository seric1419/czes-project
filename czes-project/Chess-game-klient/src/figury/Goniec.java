package figury;

import commons.Constants;

public class Goniec extends Figura {

	private static final long serialVersionUID = -4746165200566594974L;

	public Goniec(Kolor kolor) {
		super(kolor);
		
		if(kolor == Kolor.BIALY){
			super.setImage(Constants.BIALY_GONIEC_OBRAZEK);
		}
		else if(kolor == Kolor.CZARNY){
			super.setImage(Constants.CZARNY_GONIEC_OBRAZEK);
		}
	}

	public String coJestes(){
		return "Goniec";
	}

}
