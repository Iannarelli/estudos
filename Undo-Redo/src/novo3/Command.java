package novo3;

public interface Command {

	void execute(Text text, Boolean isRedo);
	void undo(Text text);
}
