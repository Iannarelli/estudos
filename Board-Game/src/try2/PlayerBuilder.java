package try2;

public class PlayerBuilder extends Builder_Game {

	private Player player;

	public PlayerBuilder(Player player) {
		this.player = player;
	}

	@Override
	public void setArmy(int army) {
		this.player.setArmy(army);
	}

	@Override
	public Player getPlayer() {
		return this.player;
	}
}
