package interfejs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

	private static final long serialVersionUID = 7345075863374459440L;
	private BufferedImage image;

    public ImagePanel(MouseAdapter mouseListener) {
       super();
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

	public void ustawObrazek(BufferedImage image) {
		this.image = image;
	}
	
	public void setWybrany(boolean wybrany){
		if(wybrany){
			setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		}
		else{
			setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
}
