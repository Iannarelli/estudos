package novo;

import java.util.Stack;

public class Controller {

	private Stack<Command> undo = new Stack<>();
	private Stack<Command> redo = new Stack<>();

	public void executeOperation(Command command) {
		command.execute();
	}
}
