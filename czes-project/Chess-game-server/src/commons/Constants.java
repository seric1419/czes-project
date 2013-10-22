package commons;

import figury.Goniec;
import figury.Hetman;
import figury.Kolor;
import figury.Krol;
import figury.Pion;
import figury.PustaFigura;
import figury.Skoczek;
import figury.Wieza;

public class Constants {

	public static final int ILOSC_POL = 64;
	
	public static final Wieza CZARNA_WIEZA = new Wieza(Kolor.CZARNY);
	public static final Wieza BIALA_WIEZA = new Wieza(Kolor.BIALY);
	public static final Skoczek CZARNY_SKOCZEK = new Skoczek(Kolor.CZARNY);
	public static final Skoczek BIALY_SKOCZEK = new Skoczek(Kolor.BIALY);
	public static final Goniec CZARNY_GONIEC = new Goniec(Kolor.CZARNY);
	public static final Goniec BIALY_GONIEC = new Goniec(Kolor.BIALY);
	public static final Hetman CZARNY_HETMAN = new Hetman(Kolor.CZARNY);
	public static final Hetman BIALY_HETMAN = new Hetman(Kolor.BIALY);
	public static final Krol CZARNY_KROL = new Krol(Kolor.CZARNY);
	public static final Krol BIALY_KROL = new Krol(Kolor.BIALY);
	public static final Pion CZARNY_PION = new Pion(Kolor.CZARNY);
	public static final Pion BIALY_PION = new Pion(Kolor.BIALY);
	public static final PustaFigura PUSTA_FIGURA = new PustaFigura();
	
}
