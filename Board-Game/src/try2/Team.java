package try2;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private String name;
	private List<Player> players = new ArrayList<>();

	public Team(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public String getName() {
		return this.name;
	}
}
