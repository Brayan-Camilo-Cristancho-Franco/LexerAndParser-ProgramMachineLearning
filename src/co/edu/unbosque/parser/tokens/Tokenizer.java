package co.edu.unbosque.parser.tokens;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

	private LinkedList<TokenInfo> tokenInfos;
	private LinkedList<Lexeme> tokens;

	public Tokenizer() {
		super();
		tokenInfos = new LinkedList<TokenInfo>();
		tokens = new LinkedList<Lexeme>();
	}

	public void add(int token, String name, String regex) {
		tokenInfos.add(new TokenInfo(token, name, Pattern.compile("^(" + regex + ")")));
	}

	public void tokenize(String str) {
		String s = str.trim();
		int totalLength = s.length();
		tokens.clear();
		while (!s.equals("")) {
			int remaining = s.length();
			boolean match = false;
			for (TokenInfo info : tokenInfos) {
				Matcher m = info.regex.matcher(s);
				if (m.find()) {
					match = true;
					String tok = m.group().trim();

					s = m.replaceFirst("").trim();
					tokens.add(new Lexeme(info.token, info.name, tok, totalLength - remaining));
					break;
				}
			}
			if (!match) {
				throw new ParserException("Unexpected character in input: " + s);
			}
		}
	}

	public LinkedList<Lexeme> getTokens() {
		return tokens;
	}

}
