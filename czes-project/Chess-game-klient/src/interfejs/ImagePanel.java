package interfejs;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{

	private static final long serialVersionUID = 7345075863374459440L;
	private BufferedImage image;
	private int pozycjaX;
	private int pozycjaY;

    public ImagePanel(int pozycjaX, int pozycjaY) {
       super();
       this.pozycjaX = pozycjaX;
       this.pozycjaY = pozycjaY;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);            
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
}
