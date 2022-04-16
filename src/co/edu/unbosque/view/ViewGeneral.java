package co.edu.unbosque.view;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ViewGeneral {
	private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo txt", "txt");

	public String guardarDireccionArchivo() {

		Scanner entrada = null;
		String ruta = "";
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(fileChooser);
		try {
			ruta = fileChooser.getSelectedFile().getAbsolutePath();
			File f = new File(ruta);

		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Hubo un error");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error");
		} finally {
			if (entrada != null) {
				entrada.close();
			}
		}

		return ruta;
	}
}
