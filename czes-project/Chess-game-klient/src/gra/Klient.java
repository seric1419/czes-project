package gra;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import komunikacja.Komunikacja;

public class Klient {

	public static Komunikacja komunikacja = null;
	
    public static void main(String[] args) {
    	Szachownica.getInstance();
    	
        String nazwaSerwera = args[0];
        String nazwaGracza = args[1];
        
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }

        try {
            komunikacja = (Komunikacja) Naming.lookup(nazwaSerwera);
            
            Gracz gracz = komunikacja.zaloguj(nazwaGracza);
            Thread.sleep(1000);
            Gra.getInstance().setGracz(gracz);
            
            if(gracz.getId() == 1){
                Szachownica.getInstance().pobierzGUI().ustawImieGracza1(gracz.getName());
                Gracz gracz2 = new Gracz();
                while(gracz2.getName().equals("Gracz")){
                	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                	gracz2 = komunikacja.pobierzGracza(2);
                }
                
                Szachownica.getInstance().pobierzGUI().ustawImieGracza2(gracz2.getName());
            }
            else{
            	Szachownica.getInstance().pobierzGUI().ustawImieGracza2(gracz.getName());
            	Szachownica.getInstance().pobierzGUI().ustawImieGracza1(komunikacja.pobierzGracza(1).getName());
            	while(!Gra.getInstance().getGracz().getToken()){
            		try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
            		
            		Gra.getInstance().setGracz(komunikacja.pobierzGracza(2));
            	}
            	
            	Szachownica.getInstance().ustawPola(komunikacja.pobierzPola());
            }
        } catch (Exception e){
        	e.printStackTrace();
        }
    }
}
