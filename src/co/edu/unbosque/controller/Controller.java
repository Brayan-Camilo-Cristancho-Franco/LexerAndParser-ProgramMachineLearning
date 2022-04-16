package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.ClaseY;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.VentanaTokenizar;
import co.edu.unbosque.view.ViewGeneral;

public class Controller implements ActionListener {
	private ClaseY y;
	private VentanaPrincipal vprincipal;
	private VentanaTokenizar vtokenizar;
	private ViewGeneral vgeneral;
	private String namefiletoken = "";
	private String namefilecode = "";

	public Controller() {
		y = new ClaseY();
		//
		vprincipal = new VentanaPrincipal();
		vtokenizar = new VentanaTokenizar();
		vgeneral = new ViewGeneral();
		assignListeners();

	}

	public void assignListeners() {
		vprincipal.getPrincipal().getB_codigofuente().addActionListener(this);
		vprincipal.getPrincipal().getB_codigotokens().addActionListener(this);
		vprincipal.getPrincipal().getB_tokenizar().addActionListener(this);
		vtokenizar.getPtokenizar().getB_volver().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("CODIGO")) {

			namefilecode = vgeneral.guardarDireccionArchivo();
		} else if (arg0.getActionCommand().equals("TOKENS")) {

			namefiletoken = vgeneral.guardarDireccionArchivo();
		} else if (arg0.getActionCommand().equals("TOKENIZAR")) {

			if (namefiletoken.isEmpty() == false && namefilecode.isEmpty() == false) {
				vprincipal.setVisible(false);
				vtokenizar.setVisible(true);
				ArrayList<String> code = new ArrayList<>();
				code = y.getOpcode().ReadFile(namefilecode);
				String code1 = "";
				for (int i = 0; i < code.size(); i++) {
					code1 = code1 + "\n" + code.get(i);
				}
				vtokenizar.getPtokenizar().getCodigo2().setText(code1);
				vtokenizar.getPtokenizar().getCodigo1()
						.setText(y.getTokentest().tokenizationProcess(namefiletoken, namefilecode));
				vtokenizar.getPtokenizar().getCodigo3().setText(y.getTokentest().parser(namefiletoken));

			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar los archivos");
			}
		} else if (arg0.getActionCommand().equals("VOLVERINICIO")) {
			vprincipal.setVisible(true);
			vtokenizar.setVisible(false);

		}
	}

}
