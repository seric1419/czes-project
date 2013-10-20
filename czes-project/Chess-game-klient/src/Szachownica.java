import figury.Goniec;
import figury.Hetman;
import figury.Kolor;
import figury.PustaFigura;
import figury.Wieza;
import interfejs.SzachownicaGUI;

import java.awt.Color;
import java.awt.EventQueue;
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

	public static void main(final String[] args){
		new Szachownica();
	}
	
	public void wypiszPomoc(int x, Pole pole){
		System.out.println("Index:" + x);
		System.out.println("Pole X:" + pole.pobierzX());
		System.out.println("Pole Y:" + pole.pobierzY());
		System.out.println("Pole figura: " + pole.pobierzFigure().coJestes());
	}
	public void wypiszSprawdzane(ArrayList<Integer> list)
	{
		System.out.println("Oto rozmiar tablicy: " + list.size());
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println("Oto " + i + " element: " + list.get(i));
			pola.get(list.get(i)).zaznaczPole();
		}
	}
	
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
					szachownicaGUI = new SzachownicaGUI("");
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
				Pole pole = new Pole(new PustaFigura(), j, i);
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
		p1.ustawFigure(new PustaFigura());
	}

	public boolean czySzach(Pole pole1, Pole pole2) {

		
		
		//pobieramy wspolrzedne pola
		int x = pole2.pobierzX();
		int y = pole2.pobierzY();
		
		
		if(pole1.pobierzFigure().pobierzKolor().equals(Kolor.BIALY)){ // dla bialego krola

			//////////////////////////////////////////
			///////////SZACH PRZEZ PIONKA
			////////////////////////////////////////
			
			// obliczamy pozycje figur po ukosie
			if(x - 1 > 0 && y - 1 > 0){
				int pionek1 = (y-2)*8 + x - 2;
				if(pola.get(pionek1).pobierzFigure().czyPionek()) // sprawdzamy czy po ukosie jest pionek
					if(pola.get(pionek1).pobierzFigure().pobierzKolor().equals(Kolor.CZARNY)) return true; // sprawdzamy czy po ukosie jest pionek
			}
			if(x + 1 < 9 && y - 1 > 0){
				int pionek2 = (y-2)*8 + x;
				if(pola.get(pionek2).pobierzFigure().czyPionek()) 
					if(pola.get(pionek2).pobierzFigure().pobierzKolor().equals(Kolor.CZARNY)) return true; // sprawdzamy czy po ukosie jest pionek	
			}
			
			//////////////////////////////////////////
			///////////SZACH PRZEZ WIEZE/HETMANA
			////////////////////////////////////////
			
			//////////////////////////////////////////
			///////////SZACH PRZEZ GONCA/HETMANA
			////////////////////////////////////////
			
			//////////////////////////////////////////
			///////////SZACH PRZEZ SKOCZKA
			////////////////////////////////////////

			//////////////////////////////////////////
			///////////SZACH PRZEZ KROLA
			////////////////////////////////////////	

		} else { // dla czarnego krola
					
			//////////////////////////////////////////
			///////////SZACH PRZEZ PIONKA
			////////////////////////////////////////
			// obliczamy pozycje figur po ukosie
			if(x - 1 > 0 && y + 1 < 9){
				int pionek1 = (x-1)*8 + y + 1;
				if(pola.get(pionek1).pobierzFigure().czyPionek())
					if(pola.get(pionek1).pobierzFigure().pobierzKolor().equals(Kolor.BIALY)) return true; // sprawdzamy czy po ukosie jest pionek
			}
			if(x + 1 < 9 && y + 1 < 9){
				int pionek2 = (x+1)*8 + y + 1;
				if(pola.get(pionek2).pobierzFigure().czyPionek()) 
					if(pola.get(pionek2).pobierzFigure().pobierzKolor().equals(Kolor.BIALY)) return true; // sprawdzamy czy po ukosie jest pionek	
			}
			
			//////////////////////////////////////////
			///////////SZACH PRZEZ WIEZE/HETMANA
			////////////////////////////////////////
			
			//////////////////////////////////////////
			///////////SZACH PRZEZ GONCA/HETMANA
			////////////////////////////////////////
			
			//////////////////////////////////////////
			///////////SZACH PRZEZ SKOCZKA
			////////////////////////////////////////

			//////////////////////////////////////////
			///////////SZACH PRZEZ KROLA
			////////////////////////////////////////
					
		}
		return false;		
		
	}

	public boolean czyMat() {
		return false;
	}

	public ArrayList<Integer> sprawdzanePola(Pole pole_start) {
		return pole_start.pobierzFigure().mozliweRuchy(pole_start.pobierzX(),
				pole_start.pobierzY());
	}
	// zamienia pionek na inna figure w polu z argumentu
	public void ZamienPionek(Pole pole){
		
	}
	
	public ArrayList<Integer> dodajPrzeszkody(ArrayList<Integer> lista, Pole pole){
		
		ArrayList<Integer> listaZPrzeszkodami = new ArrayList<Integer>();
		/////////////////////////////
		/////Dla wiezy lub hetmana
		////////////////////////////
		if(pole.pobierzFigure() instanceof Wieza || pole.pobierzFigure() instanceof Hetman){
			int p = pole.pobierzX();
			int r = pole.pobierzY();
			int temp; // liczba ktora bedziemy dodawac
			int index = 1; // iterator
			
			
			//sprawdzamy pola idac w dol
			while(p + index < 9)
			{
				if(pobierzPole(p + index, r).pobierzFigure().pobierzKolor().equals(pole.pobierzFigure().pobierzKolor())){ // jesli maja taki sam kolor
					break;
				} else if(pobierzPole(p + index, r).pobierzFigure().pobierzKolor().equals(Kolor.BRAK)){ // brak figury
					temp = (r - 1) * 8 + p + index - 1;
					listaZPrzeszkodami.add(temp);					
				} else{ // jesli maja przeciwny kolor
					temp = (r - 1) * 8 + p + index - 1;
					listaZPrzeszkodami.add(temp);
					break;
				}
				index++;
			}
			
			//sprawdzamy pola idac w prawo
			index = 1;
			while(r + index < 9)
			{
				if(pobierzPole(p, r + index).pobierzFigure().pobierzKolor().equals(pole.pobierzFigure().pobierzKolor())){ // jesli maja taki sam kolor
					break;
				} else if(pobierzPole(p, r + index).pobierzFigure().pobierzKolor().equals(Kolor.BRAK)){ // brak figury
					temp = (r + index - 1) * 8 + p - 1;
					listaZPrzeszkodami.add(temp);					
				} else{ // jesli maja przeciwny kolor
					temp = (r + index - 1) * 8 + p - 1;
					listaZPrzeszkodami.add(temp);
					break;
				}
				index++;
			}
			
			//sprawdzamy pola idac w gore
			index = 1;
			while(p - index > 0)
			{
				if(pobierzPole(p - index, r).pobierzFigure().pobierzKolor().equals(pole.pobierzFigure().pobierzKolor())){ // jesli maja taki sam kolor
					break;
				} else if(pobierzPole(p - index, r).pobierzFigure().pobierzKolor().equals(Kolor.BRAK)){ // brak figury
					temp = (r - 1) * 8 + p - index - 1;
					listaZPrzeszkodami.add(temp);					
				} else{ // jesli maja przeciwny kolor
					temp = (r - 1) * 8 + p - index - 1;
					listaZPrzeszkodami.add(temp);
					break;
				}
				index++;
			}
			
			//sprawdzamy pola idac w lewo
			index = 1;
			while(r - index > 0)
			{
				if(pobierzPole(p, r - index).pobierzFigure().pobierzKolor().equals(pole.pobierzFigure().pobierzKolor())){ // jesli maja taki sam kolor
					break;
				} else if(pobierzPole(p, r - index).pobierzFigure().pobierzKolor().equals(Kolor.BRAK)){ // brak figury
					temp = (r - index - 1) * 8 + p - 1;
					listaZPrzeszkodami.add(temp);					
				} else{ // jesli maja przeciwny kolor
					temp = (r - index - 1) * 8 + p - 1;
					listaZPrzeszkodami.add(temp);
					break;
				}
				index++;
			}
			
		}
		
		/////////////////////////////
		/////Dla gonca lub hetmana
		////////////////////////////		
		if(pole.pobierzFigure() instanceof Goniec || pole.pobierzFigure() instanceof Hetman){
			
			int p = pole.pobierzX();
			int r = pole.pobierzY();
			int temp; // liczba ktora bedziemy dodawac
			int index = 1; // iterator
			
			
			//sprawdzamy pola idac w dol i prawo
			while(p + index < 9 && r + index < 9)
			{
				if(pobierzPole(p + index, r + index).pobierzFigure().pobierzKolor().equals(pole.pobierzFigure().pobierzKolor())){ // jesli maja taki sam kolor
					break;
				} else if(pobierzPole(p + index, r + index).pobierzFigure().pobierzKolor().equals(Kolor.BRAK)){ // brak figury
					temp = (r + index - 1) * 8 + p + index - 1;
					listaZPrzeszkodami.add(temp);					
				} else{ // jesli maja przeciwny kolor
					temp = (r + index - 1) * 8 + p + index - 1;
					listaZPrzeszkodami.add(temp);
					break;
				}
				index++;
			}
			
			//sprawdzamy pola idac w prawo
			index = 1;
			while(r + index < 9 && p - index > 0)
			{
				if(pobierzPole(p - index, r + index).pobierzFigure().pobierzKolor().equals(pole.pobierzFigure().pobierzKolor())){ // jesli maja taki sam kolor
					break;
				} else if(pobierzPole(p - index, r + index).pobierzFigure().pobierzKolor().equals(Kolor.BRAK)){ // brak figury
					temp = (r + index - 1) * 8 + p - index - 1;
					listaZPrzeszkodami.add(temp);					
				} else{ // jesli maja przeciwny kolor
					temp = (r + index - 1) * 8 + p - index - 1;
					listaZPrzeszkodami.add(temp);
					break;
				}
				index++;
			}
			
			//sprawdzamy pola idac w gore
			index = 1;
			while(p - index > 0 && r - index > 0)
			{
				if(pobierzPole(p - index, r - index).pobierzFigure().pobierzKolor().equals(pole.pobierzFigure().pobierzKolor())){ // jesli maja taki sam kolor
					break;
				} else if(pobierzPole(p - index, r - index).pobierzFigure().pobierzKolor().equals(Kolor.BRAK)){ // brak figury
					temp = (r - index - 1) * 8 + p - index - 1;
					listaZPrzeszkodami.add(temp);					
				} else{ // jesli maja przeciwny kolor
					temp = (r - index - 1) * 8 + p - index - 1;
					listaZPrzeszkodami.add(temp);
					break;
				}
				index++;
			}
			
			//sprawdzamy pola idac w lewo
			index = 1;
			while(r - index > 0 && p + index < 9)
			{
				if(pobierzPole(p + index, r - index).pobierzFigure().pobierzKolor().equals(pole.pobierzFigure().pobierzKolor())){ // jesli maja taki sam kolor
					break;
				} else if(pobierzPole(p + index, r - index).pobierzFigure().pobierzKolor().equals(Kolor.BRAK)){ // brak figury
					temp = (r - index - 1) * 8 + p + index - 1;
					listaZPrzeszkodami.add(temp);					
				} else{ // jesli maja przeciwny kolor
					temp = (r - index - 1) * 8 + p + index - 1;
					listaZPrzeszkodami.add(temp);
					break;
				}
				index++;
			}
			
			
		}
		
		lista.retainAll(listaZPrzeszkodami); // czesc wspolna obu list
		return lista;
	}
	
	public boolean sprawdzRuch(int x1, int x2) {
		
		//pomoc
		//System.out.println("SPRADZAMY POZYCJE WYJSCIOWA");
		//wypiszPomoc(x1, pola.get(x1));
		//System.out.println(" ");
		//System.out.println("SPRADZAMY POZYCJE DOCELOWA");
		wypiszPomoc( x2, pola.get(x2));
		//System.out.println(" ");
		//System.out.println(" ");
		
		Pole pole_start = pola.get(x1);
		Pole pole_fin = pola.get(x2);
		
		////////////////////////////////////////////////////
		////////////////////////////PIONEK
		/////////////////////////////////////////////////
		if(pole_start.pobierzFigure().czyPionek()) // czy jest pionkiem
		{
			if(pole_start.pobierzFigure().pobierzKolor().equals(Kolor.BIALY)){ // czy jest koloru bialego
				
				if(pole_start.pobierzY() == 2){	// czy jest na przedostatnim wierszu
	
					if(pole_fin.pobierzY() == 1){
						
						if(pole_fin.pobierzX() == pole_start.pobierzX()){ // czy chcemy sie przemiescic na wprost
						
							if(pole_fin.pobierzFigure().pobierzKolor().equals(Kolor.BRAK)){ // czy na wprost nie ma pionka
								ZamienPionek(pole_start); // zamieniamy pionek w starcie, bo dopiero po return zamienia on sie miejscami
								return true;
							} else return false;
							
						} else if(pole_fin.pobierzX() == pole_start.pobierzX() + 1){ // jezeli idziemy w prawo
							if(pole_fin.pobierzFigure().pobierzKolor().equals(Kolor.CZARNY)){ // jezeli jest tam przeciwnik
								ZamienPionek(pole_start); // zamieniamy pionek w starcie, bo dopiero po return zamienia on sie miejscami
								return true;
							} else return false;
						
						} else if(pole_fin.pobierzX() == pole_start.pobierzX() - 1){ // jezeli idziemy w lewo
							if(pole_fin.pobierzFigure().pobierzKolor().equals(Kolor.CZARNY)){ // jezeli jest tam przeciwnik
								ZamienPionek(pole_start); // zamieniamy pionek w starcie, bo dopiero po return zamienia on sie miejscami
								return true;
							} else return false; 
						} else return false; // jezeli nie idziemy ani na bok, ani na wprost 
					} else return false; // jesli wybralismy inny wiersz docelowy niz kolejny
				
				} else if(pole_start.pobierzY() > 2){
					
					if(pole_fin.pobierzY() == pole_start.pobierzY() - 1){
						
						if(pole_fin.pobierzX() == pole_start.pobierzX()){ // czy chcemy sie przemiescic na wprost
						
							if(pole_fin.pobierzFigure().pobierzKolor().equals(Kolor.BRAK)){ // czy na wprost nie ma pionka
								return true;
							} else return false;
							
						} else if(pole_fin.pobierzX() == pole_start.pobierzX() + 1){ // jezeli idziemy w prawo
							if(pole_fin.pobierzFigure().pobierzKolor().equals(Kolor.CZARNY)){ // jezeli jest tam przeciwnik
								return true;
							} else return false;
						
						} else if(pole_fin.pobierzX() == pole_start.pobierzX() - 1){ // jezeli idziemy w lewo
							if(pole_fin.pobierzFigure().pobierzKolor().equals(Kolor.CZARNY)){ // jezeli jest tam przeciwnik
								return true;
							} else return false; 
						} else return false; // jezeli nie idziemy ani na bok, ani na wprost 
					} else return false; // jesli wybralismy inny wiersz docelowy niz kolejny
					
				} // TU TWOJE MIEJSCE NA OBSLUGE BLEDU!
			} else if(pole_start.pobierzFigure().pobierzKolor().equals(Kolor.CZARNY)){
				
				if(pole_start.pobierzY() == 7){	// czy jest na przedostatnim wierszu
					
					if(pole_fin.pobierzY() == 8){
						
						if(pole_fin.pobierzX() == pole_start.pobierzX()){ // czy chcemy sie przemiescic na wprost
						
							if(pole_fin.pobierzFigure().pobierzKolor().equals(Kolor.BRAK)){ // czy na wprost nie ma pionka
								ZamienPionek(pole_start); // zamieniamy pionek w starcie, bo dopiero po return zamienia on sie miejscami
								return true;
							} else return false;
							
						} else if(pole_fin.pobierzX() == pole_start.pobierzX() + 1){ // jezeli idziemy w prawo
							if(pole_fin.pobierzFigure().pobierzKolor().equals(Kolor.BIALY)){ // jezeli jest tam przeciwnik
								ZamienPionek(pole_start); // zamieniamy pionek w starcie, bo dopiero po return zamienia on sie miejscami
								return true;
							} else return false;
						
						} else if(pole_fin.pobierzX() == pole_start.pobierzX() - 1){ // jezeli idziemy w lewo
							if(pole_fin.pobierzFigure().pobierzKolor().equals(Kolor.BIALY)){ // jezeli jest tam przeciwnik
								ZamienPionek(pole_start); // zamieniamy pionek w starcie, bo dopiero po return zamienia on sie miejscami
								return true;
							} else return false; 
						} else return false; // jezeli nie idziemy ani na bok, ani na wprost 
					} else return false; // jesli wybralismy inny wiersz docelowy niz kolejny
				
				} else if(pole_start.pobierzY() < 7){
					
					if(pole_fin.pobierzY() == pole_start.pobierzY() + 1){
						
						if(pole_fin.pobierzX() == pole_start.pobierzX()){ // czy chcemy sie przemiescic na wprost
						
							if(pole_fin.pobierzFigure().pobierzKolor().equals(Kolor.BRAK)){ // czy na wprost nie ma pionka
								return true;
							} else return false;
							
						} else if(pole_fin.pobierzX() == pole_start.pobierzX() + 1){ // jezeli idziemy w prawo
							if(pole_fin.pobierzFigure().pobierzKolor().equals(Kolor.BIALY)){ // jezeli jest tam przeciwnik
								return true;
							} else return false;
						
						} else if(pole_fin.pobierzX() == pole_start.pobierzX() - 1){ // jezeli idziemy w lewo
							if(pole_fin.pobierzFigure().pobierzKolor().equals(Kolor.BIALY)){ // jezeli jest tam przeciwnik
								return true;
							} else return false; 
						} else return false; // jezeli nie idziemy ani na bok, ani na wprost 
					} else return false; // jesli wybralismy inny wiersz docelowy niz kolejny
					
				} // TU TWOJE MIEJSCE NA OBSLUGE BLEDU!
				
			}
					
		} else{
			
			////////////////////////////////////////////////////
			////////////////////////////INNE FIGURY
			/////////////////////////////////////////////////
			ArrayList<Integer> tablica = sprawdzanePola(pole_start);
			
			//pomoc
			//wypiszSprawdzane(tablica);
			
			tablica = dodajPrzeszkody(tablica, pole_start);
			for(int i = 0; i < tablica.size(); i++)
			{
				int temp = tablica.get(i);
				
				if(temp == x2){ // sprawdzamy czy pole docelowe jest na tablicy dostepnych
					
					if(!pole_start.pobierzFigure().pobierzKolor().equals(pole_fin.pobierzFigure().pobierzKolor())){ //sprawdzamy czy figury maja takie same kolory
						
						if(pole_start.pobierzFigure().czyKrol()){ // sprawdzamy dla krola
							if(!czySzach(pole_start, pole_fin)) return true; // sprawdzamy czy krol nie wejdzie na szach
							else return false;
							
						} else return true;
					} else return false;
				}
			}
		}
			
		// + Roszada
		return false;

	}
	
	public Pole pobierzPole(int pozycjaX, int pozycjaY){
		return pola.get((pozycjaY - 1) * 8 + pozycjaX - 1);
	}
	

	
	@Override
	public void zmianaWybranegoPola(int nowyX, int nowyY) {
		if(focusedX != 0 && focusedY != 0){
			pobierzPole(focusedX, focusedY).pobierzImagePanel().setWybrany(false);
			pobierzPole(nowyX, nowyY).pobierzImagePanel().setWybrany(false);
			int pozycja_1 = (focusedY-1) * 8 + focusedX-1;
			int pozycja_2 = (nowyY-1) * 8 + nowyX-1;
			
			//POMOC//
			//System.out.println("UI DLA PUNKTU STARTOWEGO");
			//wypiszPomoc(pozycja_1, pobierzPole(focusedX,focusedY));
			//System.out.println(" ");
			//System.out.println("UI DLA PUNKTU KONCOWEGO");
			//wypiszPomoc(pozycja_2, pobierzPole(nowyX,nowyY));
			//System.out.println(" ");
			
			
			if(sprawdzRuch(pozycja_1, pozycja_2))
			{
				zamien(pobierzPole(focusedX, focusedY), pobierzPole(nowyX, nowyY));
			}
			focusedX = 0;
			focusedY = 0;
			return;
		}
		focusedX = nowyX;
		focusedY = nowyY;
	}
}
