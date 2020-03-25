package novo2;

public class Text {

	private String entireText;

	public Text() {
		this.entireText = new String();
	}

	public void exec(String input) {
		this.entireText = input;
	}

	public String getEntireText() {
		return this.entireText;
	}

}
