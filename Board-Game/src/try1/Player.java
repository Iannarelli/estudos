package try1;

public class Player {

	private String name;
	private int army;

	public Player(String name) {
		this.name = name;
		this.army = 0;
	}

	public String getName() {
		return name;
	}

	public int getArmy() {
		return army;
	}

	public void setArmy(int army) {
		this.army = army;
	}

	public String toJSonString() {
		return "{ \"nome\": \"" + this.name + "\", \"exercitos\": " + this.army + " }";
	}
}
