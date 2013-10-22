package gra;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.BorderFactory;

import interfejs.ImagePanel;
import figury.Figura;

public class Pole implements Serializable{

	private static final long serialVersionUID = -7566188556025919518L;
	private ImagePanel imagePanel;
	private ZmianaWybranegoListener listener;
	
	private Figura figura;
	private int wspol_x;
	private int wspol_y;
	
	public Pole(Figura figura, int x, int y) {
		imagePanel = new ImagePanel(mouseListener);
		imagePanel.ustawObrazek(figura.pobierzObrazek());
		this.figura = figura;
		this.wspol_x = x;
		this.wspol_y = y;
	}
	
	public ImagePanel pobierzImagePanel(){
		return imagePanel;
	}

	public void ustawFigure(Figura figura) {
		this.figura = figura;
		imagePanel.ustawObrazek(figura.pobierzObrazek());
	}

	public Figura pobierzFigure() {
		return figura;
	}

	public int pobierzX() {
		return wspol_x;
	}

	public int pobierzY() {
		return wspol_y;
	}
	
	public void zaznaczPole(){
		imagePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
	}
	
	public void odznaczPole(){
		imagePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public void setZmianaWybranegoPolaListener(ZmianaWybranegoListener listener){
		this.listener = listener;
	}

	private MouseAdapter mouseListener = new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e){
			if(Gra.getInstance().getGracz().getToken()){
				imagePanel.setWybrany(true);
				listener.zmianaWybranegoPola(wspol_x, wspol_y);
			}
		}
	};
	
	public interface ZmianaWybranegoListener{
		public void zmianaWybranegoPola(int nowyX, int nowyY);
	}
}
