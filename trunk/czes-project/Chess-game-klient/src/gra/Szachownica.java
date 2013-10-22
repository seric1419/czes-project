package gra;
import figury.Figura;
import figury.Goniec;
import figury.Hetman;
import figury.Kolor;
import figury.Krol;
import figury.Pion;
import figury.Skoczek;
import figury.Wieza;
import interfejs.SzachownicaGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;

import commons.Constants;

public class Szachownica implements Pole.ZmianaWybranegoListener{

	private static Szachownica instance;
	
	private List<Pole> pola;
	private SzachownicaGUI szachownicaGUI;

	int focusedX = 0;
	int focusedY = 0;
	
	public static Szachownica getInstance(){
		if(instance == null){
			instance = new Szachownica();
		}
		return instance;
	}
	
	public Szachownica() {
		pola = new ArrayList<Pole>(Constants.ILOSC_POL);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					szachownicaGUI = new SzachownicaGUI();
					szachownicaGUI.setVisible(true);
					
					inicjalizujPola();
					inicjalizujFigury();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void inicjalizujPola(){
		boolean brazowe = false;
		int pozycjaX = 10;
		int pozycjaY = 30;
		
		for(int i = 1; i < 9; i++){
			for(int j = 1; j < 9; j++){
				Pole pole = new Pole(Constants.PUSTA_FIGURA, j, i);
				pole.pobierzImagePanel().setBounds(pozycjaX, pozycjaY, 100, 100);
				pole.pobierzImagePanel().setBorder(BorderFactory.createLineBorder(Color.BLACK));
				pole.setZmianaWybranegoPolaListener(this);
				
				if(brazowe){
					pole.pobierzImagePanel().setBackground(Constants.BROWN);
				}
				else{
					pole.pobierzImagePanel().setBackground(Constants.LIGHT_BROWN);
				}
				
				pola.add(pole);
				szachownicaGUI.dodajPanel(pole.pobierzImagePanel());
				
				pozycjaX += 100;
				brazowe = !brazowe;
			}
			
			brazowe = !brazowe;
			pozycjaX = 10;
			pozycjaY += 100;
		}
	}
	
	private void inicjalizujFigury(){
		pobierzPole(1,1).ustawFigure(Constants.CZARNA_WIEZA);
		pobierzPole(2,1).ustawFigure(Constants.CZARNY_SKOCZEK);
		pobierzPole(3,1).ustawFigure(Constants.CZARNY_GONIEC);
		pobierzPole(4,1).ustawFigure(Constants.CZARNY_HETMAN);
		pobierzPole(5,1).ustawFigure(Constants.CZARNY_KROL);
		pobierzPole(6,1).ustawFigure(Constants.CZARNY_GONIEC);
		pobierzPole(7,1).ustawFigure(Constants.CZARNY_SKOCZEK);
		pobierzPole(8,1).ustawFigure(Constants.CZARNA_WIEZA);
		pobierzPole(1,2).ustawFigure(Constants.CZARNY_PION);
		pobierzPole(2,2).ustawFigure(Constants.CZARNY_PION);
		pobierzPole(3,2).ustawFigure(Constants.CZARNY_PION);
		pobierzPole(4,2).ustawFigure(Constants.CZARNY_PION);
		pobierzPole(5,2).ustawFigure(Constants.CZARNY_PION);
		pobierzPole(6,2).ustawFigure(Constants.CZARNY_PION);
		pobierzPole(7,2).ustawFigure(Constants.CZARNY_PION);
		pobierzPole(8,2).ustawFigure(Constants.CZARNY_PION);
		
		pobierzPole(1,7).ustawFigure(Constants.BIALY_PION);
		pobierzPole(2,7).ustawFigure(Constants.BIALY_PION);
		pobierzPole(3,7).ustawFigure(Constants.BIALY_PION);
		pobierzPole(4,7).ustawFigure(Constants.BIALY_PION);
		pobierzPole(5,7).ustawFigure(Constants.BIALY_PION);
		pobierzPole(6,7).ustawFigure(Constants.BIALY_PION);
		pobierzPole(7,7).ustawFigure(Constants.BIALY_PION);
		pobierzPole(8,7).ustawFigure(Constants.BIALY_PION);
		pobierzPole(1,8).ustawFigure(Constants.BIALA_WIEZA);
		pobierzPole(2,8).ustawFigure(Constants.BIALY_SKOCZEK);
		pobierzPole(3,8).ustawFigure(Constants.BIALY_GONIEC);
		pobierzPole(4,8).ustawFigure(Constants.BIALY_HETMAN);
		pobierzPole(5,8).ustawFigure(Constants.BIALY_KROL);
		pobierzPole(6,8).ustawFigure(Constants.BIALY_GONIEC);
		pobierzPole(7,8).ustawFigure(Constants.BIALY_SKOCZEK);
		pobierzPole(8,8).ustawFigure(Constants.BIALA_WIEZA);
	}
	
	public void zamien(Pole p1, Pole p2) {
		p2.ustawFigure(p1.pobierzFigure());
		p1.ustawFigure(Constants.PUSTA_FIGURA);
	}
	
	public Pole pobierzPole(int pozycjaX, int pozycjaY){
		return pola.get((pozycjaY - 1) * 8 + pozycjaX - 1);
	}
	
	public void ustawPola(List<Pole> pola){
		for(Pole temp: pola){
			pobierzPole(temp.pobierzX(), temp.pobierzY()).ustawFigure(getFigura(temp.pobierzFigure()));
		}
	}
	
	private Figura getFigura(Figura figura){
		if(figura instanceof Wieza){
			if(figura.pobierzKolor() == Kolor.CZARNY){
				return Constants.CZARNA_WIEZA;
			}
			else {
				return Constants.BIALA_WIEZA;
			}
		}
		else if(figura instanceof Skoczek){
			if(figura.pobierzKolor() == Kolor.CZARNY){
				return Constants.CZARNY_SKOCZEK;
			}
			else {
				return Constants.BIALY_SKOCZEK;
			}
		}
		else if(figura instanceof Goniec){
			if(figura.pobierzKolor() == Kolor.CZARNY){
				return Constants.CZARNY_GONIEC;
			}
			else {
				return Constants.BIALY_GONIEC;
			}
		}
		else if(figura instanceof Hetman){
			if(figura.pobierzKolor() == Kolor.CZARNY){
				return Constants.CZARNY_HETMAN;
			}
			else {
				return Constants.BIALY_HETMAN;
			}
		}
		else if(figura instanceof Krol){
			if(figura.pobierzKolor() == Kolor.CZARNY){
				return Constants.CZARNY_KROL;
			}
			else {
				return Constants.BIALY_KROL;
			}
		}
		else if(figura instanceof Pion){
			if(figura.pobierzKolor() == Kolor.CZARNY){
				return Constants.CZARNY_PION;
			}
			else {
				return Constants.BIALY_PION;
			}
		}
		
		return Constants.PUSTA_FIGURA;
	}
	
	public SzachownicaGUI pobierzGUI(){
		return szachownicaGUI;
	}
	
	@Override
	public void zmianaWybranegoPola(int nowyX, int nowyY) {
		if(focusedX != 0 && focusedY != 0){
			pobierzPole(focusedX, focusedY).pobierzImagePanel().setWybrany(false);
			pobierzPole(nowyX, nowyY).pobierzImagePanel().setWybrany(false);
			
			try {
				if(Klient.komunikacja.wykonajRuch(focusedX, focusedY, nowyX, nowyY, Gra.getInstance().getGracz().getId())){
					zamien(pobierzPole(focusedX, focusedY), pobierzPole(nowyX, nowyY));
					Gra.getInstance().getGracz().setToken(false);
				}
				
				focusedX = 0;
				focusedY = 0;
				return;
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		focusedX = nowyX;
		focusedY = nowyY;
	}
}
