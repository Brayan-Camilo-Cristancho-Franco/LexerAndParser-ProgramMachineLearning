package co.edu.unbosque.model.filemanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import co.edu.unbosque.model.TokenValues;

public class ReadFileTokens {

	private ArrayList<TokenValues> tokensarray;
	private TokenValues token;

	public ReadFileTokens() {

		this.tokensarray = new ArrayList<>();

	}

	public ArrayList<TokenValues> readFile(String namefile) {
		try {
			File myObj = new File(namefile);
			Scanner myReader = new Scanner(myObj);
			String data = myReader.nextLine();
			String object[] = data.split(";");
			tokensarray.add(new TokenValues(object[0], object[1], object[2]));
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
				object = data.split(";");
				tokensarray.add(new TokenValues(object[0], object[1], object[2]));

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return tokensarray;
	}
}
