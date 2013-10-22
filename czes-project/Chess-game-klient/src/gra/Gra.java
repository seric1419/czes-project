package gra;

public class Gra {

	private Gracz gracz;
	private static Gra instance;
	
	public static Gra getInstance(){
		if(instance == null){
			instance = new Gra();
		}
		return instance;
	}
	
	private Gra(){
		
	}

	public Gracz getGracz() {
		return gracz;
	}

	public void setGracz(Gracz gracz) {
		this.gracz = gracz;
	}
}
