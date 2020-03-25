package try1;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Game {

	private List<Team> teams = new ArrayList<>();

	public void addTeam(String name) {
		teams.add(new Team(name));
	}

	public boolean hasTeam() {
		return !teams.isEmpty();
	}

	public String getTeamsList() {
		String teams = new String();
		for (int i = 0; i < this.teams.size(); i++) {
			String team = this.teams.get(i).getName();
			teams = teams.concat((i+1) + "- " + team + "\n");
		}
		return teams;
	}

	public int getNumberOfTeams() {
		return this.teams.size();
	}

	public Team getTeam(int index) {
		return this.teams.get(index);
	}

	public String toJSonString() {
		StringBuilder game = new StringBuilder();
		game.append("{ \"game\": [ ");
		if (this.teams.isEmpty()) {
			game.append("] }");
		} else {
			int teams = this.teams.size();
			for (int i = 0; i < teams; i++) {
				game.append(this.teams.get(i).toJSonString());
				if (i < teams - 1) {
					game.append(", ");
				}
			}
			game.append(" ] }");
		}
		return game.toString();
	}

	public JsonObject toJSonObject() {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(this.toJSonString()).getAsJsonObject();
		return json;
	}

	public String toText() {
		StringBuilder game = new StringBuilder();
		if (this.teams.isEmpty()) {
			System.out.println("Não há nenhum dado registrado.");
		} else {
			int teams = this.teams.size();
			for (int i = 0; i < teams; i++) {
				Team team = this.getTeam(i);
				game.append("Time " + (i+1) + ": " + team.getName() + "\nJogadores :: Exércitos\n");
				if (team.hasPlayer()) {
					int players = team.getNumberOfPlayers();
					for (int j = 0; j < players; j++) {
						Player player = team.getPlayer(j);
						game.append(player.getName() + " :: " + player.getArmy() + "\n");
					}
				} else {
					game.append("Nenhum jogador registrado para este time.\n");
				}
				game.append("\n");
			}
		}
		return game.toString();
	}
}
