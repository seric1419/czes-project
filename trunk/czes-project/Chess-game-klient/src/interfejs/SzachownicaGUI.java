package interfejs;

import interfejs.ImagePanel.ZmianaWybranegoListener;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import commons.Constants;

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
			getPole(0,0).setImage(Constants.czarnaWieza);
			getPole(1,0).setImage(Constants.czarnyKon);
			getPole(2,0).setImage(Constants.czarnyGoniec);
			getPole(3,0).setImage(Constants.czarnaKrolowa);
			getPole(4,0).setImage(Constants.czarnyKrol);
			getPole(5,0).setImage(Constants.czarnyGoniec);
			getPole(6,0).setImage(Constants.czarnyKon);
			getPole(7,0).setImage(Constants.czarnaWieza);
			getPole(0,1).setImage(Constants.czarnyPion);
			getPole(1,1).setImage(Constants.czarnyPion);
			getPole(2,1).setImage(Constants.czarnyPion);
			getPole(3,1).setImage(Constants.czarnyPion);
			getPole(4,1).setImage(Constants.czarnyPion);
			getPole(5,1).setImage(Constants.czarnyPion);
			getPole(6,1).setImage(Constants.czarnyPion);
			getPole(7,1).setImage(Constants.czarnyPion);
			
			getPole(0,6).setImage(Constants.bialyPion);
			getPole(1,6).setImage(Constants.bialyPion);
			getPole(2,6).setImage(Constants.bialyPion);
			getPole(3,6).setImage(Constants.bialyPion);
			getPole(4,6).setImage(Constants.bialyPion);
			getPole(5,6).setImage(Constants.bialyPion);
			getPole(6,6).setImage(Constants.bialyPion);
			getPole(7,6).setImage(Constants.bialyPion);
			getPole(0,7).setImage(Constants.bialaWieza);
			getPole(1,7).setImage(Constants.bialyKon);
			getPole(2,7).setImage(Constants.bialyGoniec);
			getPole(3,7).setImage(Constants.bialaKrolowa);
			getPole(4,7).setImage(Constants.bialyKrol);
			getPole(5,7).setImage(Constants.bialyGoniec);
			getPole(6,7).setImage(Constants.bialyKon);
			getPole(7,7).setImage(Constants.bialaWieza);
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
