package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class PanelPrincipal extends JLabel {
	private JLabel e_titulo;
	private JButton b_codigofuente, b_codigotokens, b_tokenizar;

	public PanelPrincipal() {

		setLayout(null);
		inicializarComponentes();
	}

	public void inicializarComponentes() {

		setBackground(new Color(222, 222, 222));
		setBorder(new LineBorder(new Color(190, 255, 237)));

		e_titulo = new JLabel("PARSER AND LEXER");
		e_titulo.setForeground(Color.white);
		e_titulo.setFont(new Font("Algerian", 30, 40));
		e_titulo.setBounds(53, 100, 400, 45);
		add(e_titulo);

		b_codigofuente = new JButton("Source code");
		b_codigofuente.setActionCommand("CODIGO");
		b_codigofuente.setBounds(160, 210, 155, 30);
		b_codigofuente.setBackground(Color.white);
		add(b_codigofuente);

		b_codigotokens = new JButton("Code tokens");
		b_codigotokens.setActionCommand("TOKENS");
		b_codigotokens.setBounds(160, 170, 155, 30);
		b_codigotokens.setBackground(Color.white);
		add(b_codigotokens);

		b_tokenizar = new JButton("PARSER AND LEXER");
		b_tokenizar.setActionCommand("TOKENIZAR");
		b_tokenizar.setBounds(160, 250, 155, 30);
		b_tokenizar.setBackground(Color.white);
		add(b_tokenizar);

	}

	public JLabel getE_titulo() {
		return e_titulo;
	}

	public void setE_titulo(JLabel e_titulo) {
		this.e_titulo = e_titulo;
	}

	public JButton getB_codigofuente() {
		return b_codigofuente;
	}

	public void setB_codigofuente(JButton b_codigofuente) {
		this.b_codigofuente = b_codigofuente;
	}

	public JButton getB_codigotokens() {
		return b_codigotokens;
	}

	public void setB_codigotokens(JButton b_codigotokens) {
		this.b_codigotokens = b_codigotokens;
	}

	public JButton getB_tokenizar() {
		return b_tokenizar;
	}

	public void setB_tokenizar(JButton b_tokenizar) {
		this.b_tokenizar = b_tokenizar;
	}

}
