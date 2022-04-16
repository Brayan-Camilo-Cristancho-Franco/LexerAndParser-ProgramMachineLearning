package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.unbosque.model.filemanagement.FileOperationCode;

public class RemoveComments {

	private FileOperationCode fileOperation;
	private ArrayList<String> code;
	private String codeaux;

	private String code2 = "";

	public RemoveComments() {
		fileOperation = new FileOperationCode();
		code = new ArrayList<String>();
	}

	public String remove(String namecode) {

		code = fileOperation.ReadFile(namecode);
		for (int i = 0; i < code.size(); i++) {
			codeaux = code.get(i);
			code2 = code2 + codeaux.replaceAll("#.+", "") + "\n";

		}

		return code2;
	}
}
