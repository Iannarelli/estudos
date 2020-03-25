package novo3;

import java.util.Stack;

public class Controller {

	private Stack<Command> undo = new Stack<>();
	private Stack<Command> redo = new Stack<>();
	private Text text;
	
	public Controller(Text text) {
		this.text = text;
	}

	public void executeOperation(Command command, Boolean isRedo) {
		if (isRedo) {
			command = redo.pop();
		} else {
			redo = new Stack<>();
		}
		undo.push(command);
		command.execute(this.text, isRedo);
	}

	public void undoOperation(Command command) {
		command = undo.pop();
		redo.push(command);
		command.undo(this.text);
	}

	public Boolean getHasUndoAction() {
		if (this.undo.empty()) {
			return false;
		} else {
			return true;
		}
	}

	public Boolean getHasRedoAction() {
		if (this.redo.empty()) {
			return false;
		} else {
			return true;
		}
	}
}
