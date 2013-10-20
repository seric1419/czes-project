package interfejs;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SzachownicaGUI extends JFrame{

	private static final long serialVersionUID = 3376616182283550890L;
	private JPanel contentPane;
	
	private JLabel imieGracza1;
	private JLabel imieGracza2;

	/**
	 * Create the frame.
	 */
	public SzachownicaGUI(String name) {
		super("Chess Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ustawFullScreen();
		inicjalizujImiona(name);
	}
	
	private void ustawFullScreen(){
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		device.setFullScreenWindow(this);
		setSize(850, getHeight());
	}
	
	private void inicjalizujImiona(String name){
		imieGracza1 = new JLabel(name);
		imieGracza1.setBounds(50, 835, 500, 20);
		imieGracza1.setFont(new Font(imieGracza1.getFont().getName(), Font.BOLD, 20));
		contentPane.add(imieGracza1);
		
		imieGracza2 = new JLabel(name);
		imieGracza2.setBounds(500, 5, 500, 20);
		imieGracza2.setFont(new Font(imieGracza2.getFont().getName(), Font.BOLD, 20));
		contentPane.add(imieGracza2);
	}
	
	public void dodajPanel(JPanel panel){
		contentPane.add(panel);
	}

	public void ustawImieGracza1(String imieGracza1) {
		this.imieGracza1.setText(imieGracza1);
	}

	public void ustawImieGracza2(String imieGracza2) {
		this.imieGracza2.setText(imieGracza2);
	}
}
