package co.edu.unbosque.parser;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.TokenValues;
import co.edu.unbosque.model.filemanagement.ReadFileTokens;
import co.edu.unbosque.parser.tokens.Lexeme;
import co.edu.unbosque.parser.tokens.ParserException;

public class Parser {

	private LinkedList<Lexeme> tokenscode;
	private Lexeme lookahead;
	private ReadFileTokens readtokens;
	private ArrayList<TokenValues> tokens = new ArrayList<>();
	private String statusparsing = "";

	public void parse(LinkedList<Lexeme> tokens, String namefile) {
		readtokens = new ReadFileTokens();
		this.tokens = readtokens.readFile(namefile);

		this.tokenscode = (LinkedList<Lexeme>) tokens.clone();
		lookahead = tokens.getFirst();

		MlDocument();

		if (lookahead.getName().equals("EPSILON")) {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void nextToken() {
		statusparsing = statusparsing + "\n" + "Proximo: " + tokenscode.getFirst().getSequence();
		tokenscode.pop();

		if (tokenscode.isEmpty()) {
			lookahead = new Lexeme(-1, "EPSILON", "", 0);
		} else {
			lookahead = tokenscode.getFirst();

		}
	}

	private void MlDocument() {
		Head();
		InputsStatement();
		OutputsStatement();
		ModelStatement();

	}

	private void Head() {
		NameModel();
		FamilyModel();
		TypeModel();
		DescriptionModel();
	}

	private void NameModel() {
		if (lookahead.getName().equals(tokens.get(3).getNametoken())) {
			nextToken();
			if (lookahead.getName().equals(tokens.get(23).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null,
						" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
				throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
			} else {
				nextToken();
			}

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void FamilyModel() {
		if (lookahead.getName().equals(tokens.get(4).getNametoken())) {
			nextToken();
			if (lookahead.getName().equals(tokens.get(12).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null,
						" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
				throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
			} else {
				nextToken();
			}

		} else {

			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");

		}
	}

	private void TypeModel() {
		if (lookahead.getName().equals(tokens.get(5).getNametoken())) {
			nextToken();
			if (lookahead.getName().equals(tokens.get(13).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null,
						" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
				throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
			} else {
				nextToken();
			}

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void DescriptionModel() {
		if (lookahead.getName().equals(tokens.get(6).getNametoken())) {
			nextToken();
			if (lookahead.getName().equals(tokens.get(23).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null,
						" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
				throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");

			} else {
				nextToken();
			}

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void InputsStatement() {

		if (lookahead.getName().equals(tokens.get(7).getNametoken())) {
			nextToken();
			InputsBody();
			if (lookahead.getName().equals(tokens.get(2).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null, "¡Error!" + "\n" + " Closing brackets expected and "
						+ lookahead.getSequence() + " found instead");
				throw new ParserException(
						" Closing brackets expected and " + lookahead.getSequence() + " found instead");
			} else {
				nextToken();
			}

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void InputsBody() {
		InputValue();
		A();
	}

	private void A() {
		if (lookahead.getName().equals(tokens.get(8).getNametoken())) {
			InputsBody();
		} else {

		}

	}

	private void InputValue() {
		if (lookahead.getName().equals(tokens.get(8).getNametoken())) {
			nextToken();
			InputBody();
			if (lookahead.getName().equals(tokens.get(2).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null, "¡Error!" + "\n" + " Closing brackets expected and "
						+ lookahead.getSequence() + " found instead");
				throw new ParserException(
						" Closing brackets expected and " + lookahead.getSequence() + " found instead");
			} else {
				nextToken();
			}

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}

	}

	private void InputBody() {
		NameInput();
		TypeInput();

	}

	private void NameInput() {
		if (lookahead.getName().equals(tokens.get(9).getNametoken())) {
			nextToken();
			if (lookahead.getName().equals(tokens.get(23).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null,
						" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
				throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
			} else {
				nextToken();
			}

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void TypeInput() {
		if (lookahead.getName().equals(tokens.get(10).getNametoken())) {
			nextToken();
			if (lookahead.getName().equals(tokens.get(11).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null,
						" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
				throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
			} else {
				nextToken();
			}

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void OutputsStatement() {

		if (lookahead.getName().equals(tokens.get(14).getNametoken())) {
			nextToken();
			OutputsBody();
			if (lookahead.getName().equals(tokens.get(2).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null, "¡Error!" + "\n" + " Closing brackets expected and "
						+ lookahead.getSequence() + " found instead");
				throw new ParserException(
						" Closing brackets expected and " + lookahead.getSequence() + " found instead");
			} else {
				nextToken();
			}

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void OutputsBody() {
		OutputValue();
		B();
	}

	private void B() {

		if (lookahead.getName().equals(tokens.get(15).getNametoken())) {
			OutputsBody();
		} else {

		}

	}

	private void OutputValue() {

		if (lookahead.getName().equals(tokens.get(15).getNametoken())) {
			nextToken();
			OutputBody();
			if (lookahead.getName().equals(tokens.get(2).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null, "¡Error!" + "\n" + " Closing brackets expected and "
						+ lookahead.getSequence() + " found instead");
				throw new ParserException(
						" Closing brackets expected and " + lookahead.getSequence() + " found instead");
			} else {
				nextToken();
			}

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void OutputBody() {
		NameOutput();
		TypeOutput();
	}

	private void NameOutput() {
		if (lookahead.getName().equals(tokens.get(16).getNametoken())) {
			nextToken();
			if (lookahead.getName().equals(tokens.get(23).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null,
						" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
				throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
			} else {
				nextToken();
			}
		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}

	}

	private void TypeOutput() {
		if (lookahead.getName().equals(tokens.get(17).getNametoken())) {
			nextToken();
			if (lookahead.getName().equals(tokens.get(11).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null,
						" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
				throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");

			} else {
				nextToken();
			}

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void ModelStatement() {
		if (lookahead.getName().equals(tokens.get(18).getNametoken())) {
			nextToken();
			ModelBody();
			if (lookahead.getName().equals(tokens.get(2).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null, "¡Error!" + "\n" + " Closing brackets expected and "
						+ lookahead.getSequence() + " found instead");
				throw new ParserException(
						" Closing brackets expected and " + lookahead.getSequence() + " found instead");
			}

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void ModelBody() {
		LayersStatement();
		C();
	}

	private void C() {
		if (lookahead.getName().equals(tokens.get(19).getNametoken())) {
			ModelBody();
		} else {

		}
	}

	private void LayersStatement() {
		if (lookahead.getName().equals(tokens.get(19).getNametoken())) {
			nextToken();
			LayersBody();
			if (lookahead.getName().equals(tokens.get(2).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null, "¡Error!" + "\n" + " Closing brackets expected and "
						+ lookahead.getSequence() + " found instead");
				throw new ParserException(
						" Closing brackets expected and " + lookahead.getSequence() + " found instead");
			} else {
				nextToken();
			}

		} else {

			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void LayersBody() {
		LayerValue();
		D();
	}

	private void D() {
		if (lookahead.getName().equals(tokens.get(20).getNametoken())) {
			LayersBody();
		} else {

		}

	}

	private void LayerValue() {
		if (lookahead.getName().equals(tokens.get(20).getNametoken())) {
			nextToken();
			LayerBody();
			if (lookahead.getName().equals(tokens.get(2).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null, "¡Error!" + "\n" + " Closing brackets expected and "
						+ lookahead.getSequence() + " found instead");
				throw new ParserException(
						" Closing brackets expected and " + lookahead.getSequence() + " found instead");
			} else {
				nextToken();
			}

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void LayerBody() {
		NameLayer();
		ParamsLayer();
	}

	private void NameLayer() {
		if (lookahead.getName().equals(tokens.get(21).getNametoken())) {
			nextToken();
			if (lookahead.getName().equals(tokens.get(23).getNametoken()) == false) {
				JOptionPane.showMessageDialog(null,
						" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
				throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");

			} else {
				nextToken();
			}

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}

	}

	private void ParamsLayer() {
		if (lookahead.getName().equals(tokens.get(22).getNametoken())) {
			nextToken();
			if (lookahead.getName().equals(tokens.get(0).getNametoken())) {
				nextToken();
				Params();
				if (lookahead.getName().equals(tokens.get(1).getNametoken()) == false) {
					JOptionPane.showMessageDialog(null, "¡Error!" + "\n" + " Closing brackets expected and "
							+ lookahead.getSequence() + " found instead");
					throw new ParserException(
							" Closing brackets expected and " + lookahead.getSequence() + " found instead");
				} else {
					nextToken();
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"¡Error!" + "\n" + " Open brackets expected and " + lookahead.getSequence() + " found instead");
				throw new ParserException(" Open brackets expected and " + lookahead.getSequence() + " found instead");
			}

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void Params() {
		if (lookahead.getName().equals(tokens.get(24).getNametoken())) {
			nextToken();
			E();

		} else {
			JOptionPane.showMessageDialog(null,
					" ¡Error! " + "\n" + "Unexpected symbol: " + lookahead.getSequence() + " found");
			throw new ParserException("Unexpected symbol " + lookahead.getSequence() + " found");
		}
	}

	private void E() {
		if (lookahead.getName().equals(tokens.get(25).getNametoken())) {
			nextToken();
			if (lookahead.getName().equals(tokens.get(24).getNametoken())) {
				Params();
			}
		} else {
		}
	}

	public String getStatusparsing() {
		return statusparsing;
	}

	public void setStatusparsing(String statusparsing) {
		this.statusparsing = statusparsing;
	}

}
