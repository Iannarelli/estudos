package try1;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private String name;
	private List<Player> players = new ArrayList<>();

	public Team(String name) {
		this.name = name;
	}

	public boolean hasPlayer() {
		return !players.isEmpty();
	}

	public String getName() {
		return this.name;
	}

	public String getPlayersList() {
		String players = new String();
		for (int i = 0; i < this.players.size(); i++) {
			String player = this.players.get(i).getName();
			players = players.concat((i+1) + "- " + player + "\n");
		}
		return players;
	}

	public int getNumberOfPlayers() {
		return this.players.size();
	}

	public Player getPlayer(int index) {
		return this.players.get(index);
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public String toJSonString() {
		StringBuilder team = new StringBuilder();
		team.append("{ \"nome\": \"" + this.name + "\", \"jogadores\": [ ");
		if (!this.players.isEmpty()) {
			int players = this.players.size();
			for (int i = 0; i < players; i++) {
				team.append(this.players.get(i).toJSonString());
				if (i < players - 1) {
					team.append(", ");
				}
			}
			team.append(" ] }");
		} else {
			team.append("] }");
		}
		return team.toString();
	}
}
