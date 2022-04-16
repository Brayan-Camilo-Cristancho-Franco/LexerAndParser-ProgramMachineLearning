package co.edu.unbosque.model;

public class TokenValues {
	private String id;
	private String nametoken;
	private String regex;

	public TokenValues(String id, String nametoken, String regex) {

		this.id = id;
		this.nametoken = nametoken;
		this.regex = regex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNametoken() {
		return nametoken;
	}

	public void setNametoken(String nametoken) {
		this.nametoken = nametoken;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

}
