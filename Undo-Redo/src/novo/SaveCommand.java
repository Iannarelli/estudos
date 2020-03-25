package novo;

public class SaveCommand implements Command {

	private Text text;

	public SaveCommand(Text text) {
		this.text = text;
	}

	@Override
	public void execute() {
		this.text.save();
	}
}
