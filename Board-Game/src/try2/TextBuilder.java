package try2;

public class TextBuilder extends Builder_Text {

	public TextBuilder(Game game) {
		super(game);
	}

	@Override
	public String generateText() {
		StringBuilder game = new StringBuilder();
		if (this.game.getTeams().isEmpty()) {
			game.append("Não há nenhum dado registrado.\n");
		} else {
			int teams = this.game.getTeams().size();
			for (int i = 0; i < teams; i++) {
				TeamBuilder teamBuilder = new TeamBuilder(this.game.getTeams().get(i));
				game.append("Time " + (i+1) + ": " + teamBuilder.getTeam().getName() + "\nJogadores :: Exércitos\n");
				if (teamBuilder.hasPlayer()) {
					for (Player player : teamBuilder.getPlayers()) {
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
