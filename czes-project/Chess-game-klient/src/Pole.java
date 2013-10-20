import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import interfejs.ImagePanel;
import figury.Figura;

public class Pole {

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
	
	public void setZmianaWybranegoPolaListener(ZmianaWybranegoListener listener){
		this.listener = listener;
	}

	private MouseAdapter mouseListener = new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e){
			imagePanel.setWybrany(true);
			listener.zmianaWybranegoPola(wspol_x, wspol_y);
		}
	};
	
	public interface ZmianaWybranegoListener{
		public void zmianaWybranegoPola(int nowyX, int nowyY);
	}
}
