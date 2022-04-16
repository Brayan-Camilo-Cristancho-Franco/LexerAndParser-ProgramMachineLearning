package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class VentanaTokenizar extends JFrame {

	private PanelTokenizar ptokenizar;

	public VentanaTokenizar() {

		setTitle("PROGRAM");
		setSize(730, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);

		inicializarComponentes();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}

	private void inicializarComponentes() {
		ptokenizar = new PanelTokenizar();
		ptokenizar.setBounds(5, 5, 705, 381);
		ptokenizar.setOpaque(false);
		getContentPane().add(ptokenizar);
	}

	public void mostrarMensaje(String mensaje) {

		JOptionPane.showMessageDialog(null, mensaje);
	}

	public PanelTokenizar getPtokenizar() {
		return ptokenizar;
	}

	public void setPtokenizar(PanelTokenizar ptokenizar) {
		this.ptokenizar = ptokenizar;
	}

}
