package interfejs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

	private static final long serialVersionUID = 7345075863374459440L;
	private BufferedImage image;
	private int pozycjaX;
	private int pozycjaY;
	private ZmianaWybranegoListener listener;

    public ImagePanel(int pozycjaX, int pozycjaY) {
       super();
       this.pozycjaX = pozycjaX;
       this.pozycjaY = pozycjaY;
       addMouseListener(mouseListener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(image != null){
        	int x = (this.getWidth() - image.getWidth(null)) / 2;
            int y = (this.getHeight() - image.getHeight(null)) / 2;
            g2d.drawImage(image, x, y, null);
        }
    }

	public Image getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getPozycjaX() {
		return pozycjaX;
	}

	public int getPozycjaY() {
		return pozycjaY;
	}
	
	public void setWybrany(boolean wybrany){
		if(wybrany){
			setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		}
		else{
			setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
	
	public void setZmianaWybranegoPolaListener(ZmianaWybranegoListener listener){
		this.listener = listener;
	}
	
	private MouseAdapter mouseListener = new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e){
			listener.zmianaWybranegoPola(pozycjaX, pozycjaY);
			setWybrany(true);
		}
	};
	
	public interface ZmianaWybranegoListener{
		public void zmianaWybranegoPola(int nowyX, int nowyY);
	}
}
