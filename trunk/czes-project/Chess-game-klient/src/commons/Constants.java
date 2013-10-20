package commons;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import figury.Goniec;
import figury.Hetman;
import figury.Kolor;
import figury.Krol;
import figury.Pion;
import figury.Skoczek;
import figury.Wieza;

public class Constants {

	public static final int ILOSC_POL = 64;
	
	public static final BufferedImage CZARNY_PION_OBRAZEK = getCzarnyPion();
	public static final BufferedImage BIALY_PION_OBRAZEK = getBialyPion();
	public static final BufferedImage CZARNA_WIEZA_OBRAZEK = getCzarnaWieza();
	public static final BufferedImage BIALA_WIEZA_OBRAZEK = getBialaWieza();
	public static final BufferedImage CZARNY_KON_OBRAZEK = getCzarnyKon();
	public static final BufferedImage BIALY_KON_OBRAZEK = getBialyKon();
	public static final BufferedImage CZARNY_GONIEC_OBRAZEK = getCzarnyGoniec();
	public static final BufferedImage BIALY_GONIEC_OBRAZEK = getBialyGoniec();
	public static final BufferedImage CZARNA_KROLOWA_OBRAZEK = getCzarnaKrolowa();
	public static final BufferedImage BIALA_KROLOWA_OBRAZEK = getBialaKrolowa();
	public static final BufferedImage CZARNY_KROL_OBRAZEK = getCzarnyKrol();
	public static final BufferedImage BIALY_KROL_OBRAZEK = getBialyKrol();
	
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
	public static final Color BROWN = new Color(160, 82, 45);
	
	public static final Color LIGHT_BROWN = new Color(245, 222, 179);
	
	private static BufferedImage getCzarnyPion(){
		try {
			return ImageIO.read(new File("images\\czarny_pion.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static BufferedImage getBialyPion(){
		try {
			return ImageIO.read(new File("images\\bialy_pion.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static BufferedImage getCzarnaWieza(){
		try {
			return ImageIO.read(new File("images\\czarna_wieza.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static BufferedImage getBialaWieza(){
		try {
			return ImageIO.read(new File("images\\biala_wieza.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static BufferedImage getCzarnyKon(){
		try {
			return ImageIO.read(new File("images\\czarny_kon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static BufferedImage getBialyKon(){
		try {
			return ImageIO.read(new File("images\\bialy_kon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static BufferedImage getCzarnyGoniec(){
		try {
			return ImageIO.read(new File("images\\czarny_goniec.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static BufferedImage getBialyGoniec(){
		try {
			return ImageIO.read(new File("images\\bialy_goniec.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static BufferedImage getCzarnaKrolowa(){
		try {
			return ImageIO.read(new File("images\\czarna_krolowa.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static BufferedImage getBialaKrolowa(){
		try {
			return ImageIO.read(new File("images\\biala_krolowa.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static BufferedImage getCzarnyKrol(){
		try {
			return ImageIO.read(new File("images\\czarny_krol.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static BufferedImage getBialyKrol(){
		try {
			return ImageIO.read(new File("images\\bialy_krol.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
