package co.edu.unbosque.model.filemanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperationCode {

	private ArrayList<String> code = new ArrayList();

	public ArrayList<String> ReadFile(String name) {

		try {
			File myObj = new File(name);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				code.add(myReader.nextLine());

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return code;
	}
}
