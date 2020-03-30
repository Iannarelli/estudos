package try2;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONBuilder extends Builder_Text {

	public JSONBuilder(Game game) {
		super(game);
	}

	@Override
	public String generateText() {
		StringBuilder game = new StringBuilder();
		game.append("{\"game\":[");
		if (this.game.getTeams().isEmpty()) {
			game.append("]}");
		} else {
			int teams = this.game.getTeams().size();
			for (int i = 0; i < teams; i++) {
				TeamBuilder teamBuilder = new TeamBuilder(this.game.getTeams().get(i));
				game.append("{\"nome\":\"" + teamBuilder.getTeam().getName() + "\",\"jogadores\":[");
				if (!teamBuilder.getPlayers().isEmpty()) {
					int players = teamBuilder.getPlayers().size();
					for (int j = 0; j < players; j++) {
						PlayerBuilder playerBuilder = new PlayerBuilder(teamBuilder.getPlayers().get(j));
						game.append("{\"nome\":\"" + playerBuilder.getPlayer().getName() + "\",\"exercitos\":" + playerBuilder.getPlayer().getArmy() + "}");
						if (j < players - 1) {
							game.append(",");
						}
					}
					game.append("]}");
				} else {
					game.append("]}");
				}
				if (i < teams - 1) {
					game.append(",");
				}
			}
			game.append("]}");
		}
		return game.toString();
	}

	public JsonObject toJSonObject() {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(this.generateText()).getAsJsonObject();
		return json;
	}

}
