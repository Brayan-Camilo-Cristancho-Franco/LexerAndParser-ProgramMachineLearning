package co.edu.unbosque.parser.tokens;

public class Lexeme {

	public final int token;
	public final String name;
	public final String sequence;
	public final int pos;

	public Lexeme(int token, String name, String sequence, int pos) {
		super();
		this.token = token;
		this.name = name;
		this.sequence = sequence;
		this.pos = pos;
	}

	public Lexeme clone() {
		return new Lexeme(this.token, this.name, this.sequence, this.pos);
	}

	public int getToken() {
		return token;
	}

	public String getName() {
		return name;
	}

	public String getSequence() {
		return sequence;
	}

	public int getPos() {
		return pos;
	}

}