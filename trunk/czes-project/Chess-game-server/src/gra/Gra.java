package gra;
import java.util.ArrayList;
import java.util.List;


public class Gra {

	private List<Gracz> gracze = new ArrayList<Gracz>();
	private static Gra instance; 
	
	public static Gra getInstance(){
		if(instance == null){
			instance = new Gra();
		}
		return instance;
	}
	
	private Gra(){
		
	}

	public List<Gracz> getGracze() {
		return gracze;
	}

	public void setGracze(List<Gracz> gracze) {
		this.gracze = gracze;
	}
}
