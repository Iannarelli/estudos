package novo3;

public class Input implements Command {

	private String input;

	public Input(String input) {
		this.input = input;
	}

	@Override
	public void execute(Text text, Boolean isRedo) {
		String texto = text.getText();
		if (isRedo) {
			text.exec(this.input);
		} else {
			String input;
			if(texto.length() > 0) {
				input = texto.concat("\n" + this.input);
			} else {
				input = texto.concat(this.input);			
			}
			text.exec(input);
		}
		this.input = texto;
	}

	@Override
	public void undo(Text text) {
		String texto = text.getText();
		text.exec(this.input);
		this.input = texto;
	}
}
