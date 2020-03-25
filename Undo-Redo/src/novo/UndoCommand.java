package novo;

public class UndoCommand implements Command {

	private Text text;

	public UndoCommand(Text text) {
		this.text = text;
	}

	@Override
	public void execute() {
		this.text.undo();
	}

}
