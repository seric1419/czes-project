import java.util.ArrayList;
import java.util.List;

import figury.Figura;
import figury.PustaFigura;
import figury.Kolor;
import commons.Constants;

public class Szachownica {

	private List<Pole> pola;

	public Szachownica() {
		pola = new ArrayList<Pole>(Constants.ILOSC_POL);
	}

	public void zamien(Pole p1, Pole p2) {
		p2.ustawFigure(p1.pobierzFigure());
		p1.ustawFigure(new PustaFigura());
	}

	public void czySzach() {

	}

	public void czyMat() {

	}

	public ArrayList<Integer> sprawdzanePola(Pole pole_start) {
		return pole_start.pobierzFigure().mozliweRuchy(pole_start.pobierzX(),
				pole_start.pobierzY());
	}
	// zamienia pionek na inna figure w polu z argumentu
	public void ZamienPionek(Pole pole){
		
	}

	public boolean sprawdzRuch(int x1, int x2) {
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
			} else if(pole_start.pobierzFigure().pobierzKolor().equals(Kolor.BIALY)){
				
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
			for(int i = 1; i < tablica.size(); i++)
			{
				int temp = tablica.get(i-1);
				
				if(pole_fin == pola.get(temp)){ // sprawdzamy czy pole docelowe jest na tablicy dostepnych
					
					if(!pole_fin.pobierzFigure().pobierzKolor().equals(pola.get(temp).pobierzFigure().pobierzKolor())){ //sprawdzamy czy figury maja takie same kolory
						return true;
					} else return false;
				}
			}
		}
			
		// Tutaj jeszcze kilka rzeczy do sprawdzenia czy krol nie wystawi sie na szach czy mozliwa roszada
		return false;

	}
}
