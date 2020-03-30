package try2;

public class GameBuilder extends Builder_Game {

	private Game game;

	public GameBuilder(Game game) {
		this.game = game;
	}

	@Override
	public void addTeam(String teamName) {
		this.game.getTeams().add(new Team(teamName));
	}

	@Override
	public Game getGame() {
		return this.game;
	}

	public boolean hasTeam() {
		return !this.game.getTeams().isEmpty();
	}

	public String getTeamsList() {
		String teams = new String();
		for (int i = 0; i < this.game.getTeams().size(); i++) {
			String team = this.game.getTeams().get(i).getName();
			teams = teams.concat((i+1) + "- " + team + "\n");
		}
		return teams;
	}

	public int getNumberOfTeams() {
		return this.game.getTeams().size();
	}

	public Team getTeam(int index) {
		return this.game.getTeams().get(index);
	}
}
