package novo;

import java.util.Stack;

public class Text {

	private Stack<String> done;
	private Stack<String> redo;
	private String entireText;
	private String temporaryText;

	public Text() {
		this.done = new Stack<String>();
		this.redo = new Stack<String>();
		this.entireText = new String();
		this.temporaryText = new String();
	}

	public void add(String text) {
		this.temporaryText = text;
	}

	public void save() {
		if(!this.redo.empty()) {
			this.redo = new Stack<String>();
		}
		this.done.push(this.entireText);
		if(this.entireText.length() > 0) {
			this.entireText = this.entireText.concat("\n" + temporaryText);
		} else {
			this.entireText = this.entireText.concat(temporaryText);			
		}
		this.temporaryText = new String();
	}

	public void undo() {
		if(!this.done.empty()) {
			this.redo.push(this.entireText);
			this.entireText = done.pop();
		} else {
			this.save();
		}
	}

	public void redo() {
		if(!this.redo.empty()) {
			this.done.push(this.entireText);
			this.entireText = redo.pop();
		} else {
			this.save();
		}
	}

	public String getEntireText() {
		return this.entireText;
	}

	public Boolean getHasUndoAction() {
		if (this.done.empty()) {
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
