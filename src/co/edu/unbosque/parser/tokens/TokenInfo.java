package co.edu.unbosque.parser.tokens;

import java.util.regex.Pattern;

public class TokenInfo {
	public final int token;
	public final Pattern regex;
	public final String name;

	public TokenInfo(int token, String name, Pattern regex) {
		this.name= name;
		this.regex = regex;
		this.token = token;
	}
}
