package co.edu.unbosque.model;

import co.edu.unbosque.model.filemanagement.FileOperationCode;
import co.edu.unbosque.model.filemanagement.ReadFileTokens;
import co.edu.unbosque.tokenizer.TokenizerTest;

public class ClaseY {
	private TokenizerTest tokentest;
	private FileOperationCode opcode;

	public ClaseY() {

		tokentest = new TokenizerTest();
		opcode = new FileOperationCode();
	}

	public TokenizerTest getTokentest() {
		return tokentest;
	}

	public void setTokentest(TokenizerTest tokentest) {
		this.tokentest = tokentest;
	}

	public FileOperationCode getOpcode() {
		return opcode;
	}

	public void setOpcode(FileOperationCode opcode) {
		this.opcode = opcode;
	}

}
