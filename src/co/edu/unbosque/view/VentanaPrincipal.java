package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class VentanaPrincipal extends JFrame {

	private PanelPrincipal principal;

	public VentanaPrincipal() {

		setTitle("PROGRAM");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.darkGray);

		inicializarComponentes();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void inicializarComponentes() {

		principal = new PanelPrincipal();
		principal.setBounds(5, 5, 475, 350);
		principal.setOpaque(false);
		getContentPane().add(principal);

	}

	public PanelPrincipal getPrincipal() {
		return principal;
	}

	public void setPrincipal(PanelPrincipal principal) {
		this.principal = principal;
	}

}
