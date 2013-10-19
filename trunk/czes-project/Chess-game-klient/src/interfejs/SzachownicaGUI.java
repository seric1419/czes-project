package interfejs;

import interfejs.ImagePanel.ZmianaWybranegoListener;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SzachownicaGUI extends JFrame implements ZmianaWybranegoListener{

	private static final long serialVersionUID = 3376616182283550890L;
	private JPanel contentPane;
	private List<ImagePanel> pola;
	
	int focusedX = 0;
	int focusedY = 0;
	
	private static final Color brown = new Color(160, 82, 45);
	private static final Color lightBrown = new Color(245, 222, 179);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SzachownicaGUI frame = new SzachownicaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SzachownicaGUI() {
		super("Chess Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 860);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rysujPola();
		inicjalizujFigury();
	}
	
	private void rysujPola(){
		pola = new ArrayList<ImagePanel>();
		boolean brazowe = false;
		int pozycjaX = 10;
		int pozycjaY = 10;
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				ImagePanel pole = new ImagePanel(j, i);
				pole.setBounds(pozycjaX, pozycjaY, 100, 100);
				pole.setBorder(BorderFactory.createLineBorder(Color.black));
				pole.setZmianaWybranegoPolaListener(this);
				
				if(brazowe){
					pole.setBackground(brown);
				}
				else{
					pole.setBackground(lightBrown);
				}
				
				pola.add(pole);
				contentPane.add(pole);
				
				pozycjaX += 100;
				brazowe = !brazowe;
			}
			
			brazowe = !brazowe;
			pozycjaX = 10;
			pozycjaY += 100;
		}
	}
	
	private void inicjalizujFigury(){
		try{
			BufferedImage czarnyPion = ImageIO.read(new File("images\\czarny_pion.png"));
			BufferedImage bialyPion = ImageIO.read(new File("images\\bialy_pion.png"));
			BufferedImage czarnaWieza = ImageIO.read(new File("images\\czarna_wieza.png"));
			BufferedImage bialaWieza = ImageIO.read(new File("images\\biala_wieza.png"));
			BufferedImage czarnyKon = ImageIO.read(new File("images\\czarny_kon.png"));
			BufferedImage bialyKon = ImageIO.read(new File("images\\bialy_kon.png"));
			BufferedImage czarnyGoniec = ImageIO.read(new File("images\\czarny_goniec.png"));
			BufferedImage bialyGoniec = ImageIO.read(new File("images\\bialy_goniec.png"));
			BufferedImage czarnaKrolowa = ImageIO.read(new File("images\\czarna_krolowa.png"));
			BufferedImage bialaKrolowa = ImageIO.read(new File("images\\biala_krolowa.png"));
			BufferedImage czarnyKrol = ImageIO.read(new File("images\\czarny_krol.png"));
			BufferedImage bialyKrol = ImageIO.read(new File("images\\bialy_krol.png"));
			
			getPole(0,0).setImage(czarnaWieza);
			getPole(1,0).setImage(czarnyKon);
			getPole(2,0).setImage(czarnyGoniec);
			getPole(3,0).setImage(czarnaKrolowa);
			getPole(4,0).setImage(czarnyKrol);
			getPole(5,0).setImage(czarnyGoniec);
			getPole(6,0).setImage(czarnyKon);
			getPole(7,0).setImage(czarnaWieza);
			getPole(0,1).setImage(czarnyPion);
			getPole(1,1).setImage(czarnyPion);
			getPole(2,1).setImage(czarnyPion);
			getPole(3,1).setImage(czarnyPion);
			getPole(4,1).setImage(czarnyPion);
			getPole(5,1).setImage(czarnyPion);
			getPole(6,1).setImage(czarnyPion);
			getPole(7,1).setImage(czarnyPion);
			
			getPole(0,6).setImage(bialyPion);
			getPole(1,6).setImage(bialyPion);
			getPole(2,6).setImage(bialyPion);
			getPole(3,6).setImage(bialyPion);
			getPole(4,6).setImage(bialyPion);
			getPole(5,6).setImage(bialyPion);
			getPole(6,6).setImage(bialyPion);
			getPole(7,6).setImage(bialyPion);
			getPole(0,7).setImage(bialaWieza);
			getPole(1,7).setImage(bialyKon);
			getPole(2,7).setImage(bialyGoniec);
			getPole(3,7).setImage(bialaKrolowa);
			getPole(4,7).setImage(bialyKrol);
			getPole(5,7).setImage(bialyGoniec);
			getPole(6,7).setImage(bialyKon);
			getPole(7,7).setImage(bialaWieza);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public ImagePanel getPole(int pozycjaX, int pozycjaY){
		return pola.get((pozycjaY) * 8 + pozycjaX);
	}

	@Override
	public void zmianaWybranegoPola(int nowyX, int nowyY) {
		getPole(focusedX, focusedY).setWybrany(false);
		focusedX = nowyX;
		focusedY = nowyY;
	}
}
