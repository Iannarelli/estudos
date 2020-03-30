package try2;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		GameBuilder gameBuilder = new GameBuilder(new Game());
		int option = 0;
		String lixo;
		do {
			System.out.print("O que deseja fazer?\n\n"
					+ "\t1- Registrar um time\n");
			if(gameBuilder.hasTeam()) {
				System.out.print("\t2- Registrar um jogador\n"
						+ "\t3- Registrar exércitos\n");
			}
			System.out.print("\t0- Ver registros e sair\n"
					+ "\nOpção: ");
			option = scan.nextInt();
			lixo = scan.nextLine();
			if (!gameBuilder.hasTeam() && (option == 2 || option == 3)) {
				System.out.println("Opção inválida. Tente novamente!\n\n");
			} else {
				menu(option, scan, gameBuilder);
			}
		} while (option != 0);
		scan.close();
	}

	public static void menu(int option, Scanner scan, GameBuilder gameBuilder) {
		String name;
		int index;
		switch (option) {
		case 0:
			TextBuilder textGenerator = new TextBuilder(gameBuilder.getGame());
			JSONBuilder jsonGenerator = new JSONBuilder(gameBuilder.getGame());
			System.out.println("\n\nOs registros foram:\n" + textGenerator.generateText());
			System.out.println("Em formato de Objeto JSon temos:\n" + jsonGenerator.generateText());
			break;
		case 1:
			System.out.print("Informe o nome do time: ");
			name = scan.nextLine();
			gameBuilder.addTeam(name);
			System.out.println("\n");
			break;
		case 2:
			System.out.print("Times existentes:\n" + gameBuilder.getTeamsList());
			System.out.println((gameBuilder.getNumberOfTeams() + 1) + "- Voltar ao menu inicial");
			System.out.print("\nO jogador deve integrar qual time? ");
			index = scan.nextInt();
			String lixo = scan.nextLine();
			if (index > gameBuilder.getNumberOfTeams() + 1 || index < 1) {
				System.out.println("Opção inválida!");
			} else if (index > 0 && index <= gameBuilder.getNumberOfTeams()) {
				System.out.print("Informe o nome do jogador: ");
				name = scan.nextLine();
				TeamBuilder teamBuilder = new TeamBuilder(gameBuilder.getTeam(index-1));
				teamBuilder.addPlayer(name);
			}
			System.out.println("\n");
			break;
		case 3:
			System.out.print("Times existentes:\n" + gameBuilder.getTeamsList());
			System.out.println((gameBuilder.getNumberOfTeams() + 1) + "- Voltar ao menu inicial");
			System.out.print("\nA qual time pertence o jogador? ");
			index = scan.nextInt();
			lixo = scan.nextLine();
			if (index > gameBuilder.getNumberOfTeams() + 1 || index < 1) {
				System.out.println("Opção inválida!");
			} else if (index > 0 && index <= gameBuilder.getNumberOfTeams()) {
				TeamBuilder teamBuilder = new TeamBuilder(gameBuilder.getTeam(index-1));
				if (teamBuilder.hasPlayer()) {
					System.out.print("Jogadores registrados:\n" + teamBuilder.getPlayersList());
					System.out.println((teamBuilder.getNumberOfPlayers() + 1) + "- Voltar");
					System.out.print("\nOs exércitos pertencerão a qual jogador? ");
					int playerIndex = scan.nextInt();
					lixo = scan.nextLine();
					if (playerIndex > teamBuilder.getNumberOfPlayers() + 1 || playerIndex < 1) {
						System.out.println("Opção inválida!");
					} else if (playerIndex > 0 && playerIndex <= teamBuilder.getNumberOfPlayers()) {
						System.out.print("Informe a quantidade de exércitos: ");
						int army = scan.nextInt();
						lixo = scan.nextLine();
						PlayerBuilder playerBuilder = new PlayerBuilder(teamBuilder.getPlayer(playerIndex-1));
						playerBuilder.setArmy(army);
					}
				} else {
					System.out.println("O time escolhido ainda não possui jogador para reigstro de seus exércitos.");
				}
			}
			System.out.println("\n");
			break;
		default:
			System.out.println("Opção inválida! Tente novamente.");
		}
	}
}
