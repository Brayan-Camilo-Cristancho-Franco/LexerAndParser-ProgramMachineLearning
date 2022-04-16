package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class PanelTokenizar extends JPanel {

	private JButton b_volver;
	private JTextArea codigo1, codigo2, codigo3;
	private JScrollPane jsp, jsp1, jsp2;
	private JLabel txtcode, txttokens, txtparser;

	public PanelTokenizar() {
		setLayout(null);
		inicializarComponentes();

	}

	public void inicializarComponentes() {
		
		setBackground(new Color(222, 222, 222));
		setBorder(new LineBorder(new Color(190, 255, 237)));

		setBorder(new LineBorder(Color.blue));
		b_volver = new JButton("Volver");
		b_volver.setBounds(540, 345, 90, 30);
		b_volver.setActionCommand("VOLVERINICIO");
		b_volver.setBackground(Color.white);
		add(b_volver);

		txtcode = new JLabel("SOURCE CODE");
		txtcode.setBounds(15, 4, 200, 30);
		txtcode.setFont(new Font("Serif", Font.PLAIN, 28));
		add(txtcode);

		txttokens = new JLabel("TOKENIZATION");
		txttokens.setBounds(247, 4, 200, 30);
		txttokens.setFont(new Font("Serif", Font.PLAIN, 28));
		add(txttokens);

		txtparser = new JLabel("PARSER STATUS");
		txtparser.setBounds(475, 4, 220, 30);
		txtparser.setFont(new Font("Serif", Font.PLAIN, 28));
		add(txtparser);

		codigo1 = new JTextArea();
		codigo1.setBackground(Color.LIGHT_GRAY);
		codigo1.setFont(new Font(getName(), 12, 12));
		codigo1.setLineWrap(true);
		codigo1.setWrapStyleWord(true);
		codigo1.setBounds(240, 36, 228, 343);
		codigo1.setEditable(false);
		add(codigo1);

		jsp1 = new JScrollPane(codigo1);
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setBounds(240, 36, 228, 340);
		add(jsp1);

		codigo2 = new JTextArea();
		codigo2.setBackground(Color.LIGHT_GRAY);
		codigo1.setFont(new Font(getName(), 12, 12));
		codigo1.setLineWrap(true);
		codigo1.setWrapStyleWord(true);
		codigo2.setBounds(5, 36, 230, 343);
		codigo2.setEditable(false);
		add(codigo2);

		jsp = new JScrollPane(codigo2);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(5, 36, 230, 340);
		add(jsp);

		codigo3 = new JTextArea();
		codigo3.setBackground(Color.LIGHT_GRAY);
		codigo3.setFont(new Font(getName(), 12, 12));
		codigo3.setLineWrap(true);
		codigo3.setWrapStyleWord(true);
		codigo3.setBounds(473, 36, 228, 300);
		codigo3.setEditable(false);
		add(codigo3);

		jsp2 = new JScrollPane(codigo3);
		jsp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp2.setBounds(473, 36, 228, 300);
		add(jsp2);

	}

	public JButton getB_volver() {
		return b_volver;
	}

	public void setB_volver(JButton b_volver) {
		this.b_volver = b_volver;
	}

	public JTextArea getCodigo1() {
		return codigo1;
	}

	public void setCodigo1(JTextArea codigo1) {
		this.codigo1 = codigo1;
	}

	public JTextArea getCodigo2() {
		return codigo2;
	}

	public void setCodigo2(JTextArea codigo2) {
		this.codigo2 = codigo2;
	}

	public JTextArea getCodigo3() {
		return codigo3;
	}

	public void setCodigo3(JTextArea codigo3) {
		this.codigo3 = codigo3;
	}

}