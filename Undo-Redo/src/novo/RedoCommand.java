package novo;

public class RedoCommand implements Command {

	private Text text;

	public RedoCommand(Text text) {
		this.text = text;
	}

	@Override
	public void execute() {
		this.text.redo();
	}
}
