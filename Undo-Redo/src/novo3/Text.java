package novo3;

public class Text {

	private String text;

	public Text() {
		this.text = new String();
	}

	public void exec(String input) {
		this.text = input;
	}

	public String getText() {
		return this.text;
	}

}
