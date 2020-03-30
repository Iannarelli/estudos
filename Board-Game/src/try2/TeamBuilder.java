package try2;

import java.util.List;

public class TeamBuilder extends Builder_Game {

	private Team team;

	public TeamBuilder(Team team) {
		this.team = team;
	}

	@Override
	public void addPlayer(String playerName) {
		this.team.getPlayers().add(new Player(playerName));
	}

	@Override
	public Team getTeam() {
		return this.team;
	}

	public boolean hasPlayer() {
		return !this.team.getPlayers().isEmpty();
	}

	public String getPlayersList() {
		String players = new String();
		for (int i = 0; i < this.team.getPlayers().size(); i++) {
			String player = this.team.getPlayers().get(i).getName();
			players = players.concat((i+1) + "- " + player + "\n");
		}
		return players;
	}

	public int getNumberOfPlayers() {
		return this.team.getPlayers().size();
	}

	public Player getPlayer(int index) {
		return this.team.getPlayers().get(index);
	}

	public List<Player> getPlayers() {
		return this.team.getPlayers();
	}	
	
	public void addPlayer(Player player) {
		this.team.getPlayers().add(player);
	}
}
