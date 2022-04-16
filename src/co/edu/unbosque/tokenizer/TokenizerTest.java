package co.edu.unbosque.tokenizer;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.parser.Parser;

import co.edu.unbosque.model.RemoveComments;
import co.edu.unbosque.model.TokenValues;
import co.edu.unbosque.model.filemanagement.FileOperationCode;
import co.edu.unbosque.model.filemanagement.ReadFileTokens;
import co.edu.unbosque.parser.tokens.ParserException;
import co.edu.unbosque.parser.tokens.Lexeme;
import co.edu.unbosque.parser.tokens.Tokenizer;

public class TokenizerTest {

	private Tokenizer tokenizer;
	private ArrayList<TokenValues> tokenValues;
	private ReadFileTokens readfiletokens;
	private RemoveComments remove;

	public TokenizerTest() {

		this.tokenizer = new Tokenizer();
		this.tokenValues = new ArrayList<>();
		this.readfiletokens = new ReadFileTokens();
		this.remove = new RemoveComments();
	}

	public String tokenizationProcess(String namefile, String namefilecode) {
		String code = "";
		String resul = "";
		tokenValues = readfiletokens.readFile(namefile);
		for (int i = 0; i < tokenValues.size(); i++) {
			tokenizer.add(Integer.parseInt(tokenValues.get(i).getId()), tokenValues.get(i).getNametoken(),
					tokenValues.get(i).getRegex());
		}
		code = remove.remove(namefilecode);

		try {
			tokenizer.tokenize(code);

			for (Lexeme tok : tokenizer.getTokens()) {
				resul = resul + "\n" + "|-------------------------------------------------|" + "\n"
						+ "Code token: " + tok.token + "\n" + "Token name: " + tok.name + "\n" + "Token sequence: "
						+ tok.sequence + "\n" + "Token pos: " + tok.pos;
			}
		} catch (ParserException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return resul;
	}

	public String parser(String namefile) {
		Parser p = new Parser();
		p.parse(tokenizer.getTokens(), namefile);
		return p.getStatusparsing();
	}

}
