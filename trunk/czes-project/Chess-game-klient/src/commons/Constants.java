package commons;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Constants {

	public static final int ILOSC_POL = 64;
	public static final BufferedImage czarnyPion = getCzarnyPion();
	public static final BufferedImage bialyPion = getBialyPion();
	public static final BufferedImage czarnaWieza = getCzarnaWieza();
	public static final BufferedImage bialaWieza = getBialaWieza();
	public static final BufferedImage czarnyKon = getCzarnyKon();
	public static final BufferedImage bialyKon = getBialyKon();
	public static final BufferedImage czarnyGoniec = getCzarnyGoniec();
	public static final BufferedImage bialyGoniec = getBialyGoniec();
	public static final BufferedImage czarnaKrolowa = getCzarnaKrolowa();
	public static final BufferedImage bialaKrolowa = getBialaKrolowa();
	public static final BufferedImage czarnyKrol = getCzarnyKrol();
	public static final BufferedImage bialyKrol = getBialyKrol();
	
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
