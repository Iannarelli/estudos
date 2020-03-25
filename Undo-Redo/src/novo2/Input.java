package novo2;

public class Input implements Command {

	private String input;
	private String previousText;
	private Text text;

	public Input(String input, Text text) {
		this.input = input;
		this.previousText = text.getEntireText();
		this.text = text;
	}

	@Override
	public void execute() {
		String input;
		if(this.previousText.length() > 0) {
			input = this.previousText.concat("\n" + this.input);
		} else {
			input = this.previousText.concat(this.input);			
		}
		this.text.exec(input);
	}

	@Override
	public void undo() {
		this.text.exec(this.previousText);
	}
}
