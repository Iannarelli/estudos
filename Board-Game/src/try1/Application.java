package try1;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Game game = new Game();
		int option = 0;
		String lixo;
		do {
			System.out.print("O que deseja fazer?\n\n"
					+ "\t1- Registrar um time\n");
			if(game.hasTeam()) {
				System.out.print("\t2- Registrar um jogador\n"
						+ "\t3- Registrar exércitos\n");
			}
			System.out.print("\t0- Ver registros e sair\n"
					+ "\nOpção: ");
			option = scan.nextInt();
			lixo = scan.nextLine();
			if (!game.hasTeam() && (option == 2 || option == 3)) {
				System.out.println("Opção inválida. Tente novamente!\n\n");
			} else {
				menu(option, scan, game);
			}
		} while (option != 0);
		scan.close();
	}

	public static void menu(int option, Scanner scan, Game game) {
		String name;
		int index;
		switch (option) {
		case 0:
			System.out.println("\n\nOs registros foram:\n\n" + game.toText());
			System.out.println("Em formato de Objeto JSon temos:\n" + game.toJSonObject());
			break;
		case 1:
			System.out.print("Informe o nome do time: ");
			name = scan.nextLine();
			game.addTeam(name);
			System.out.println("\n");
			break;
		case 2:
			System.out.print("Times existentes:\n" + game.getTeamsList());
			System.out.println((game.getNumberOfTeams() + 1) + "- Voltar ao menu inicial");
			System.out.print("\nO jogador deve integrar qual time? ");
			index = scan.nextInt();
			String lixo = scan.nextLine();
			if (index > game.getNumberOfTeams() + 1 || index < 1) {
				System.out.println("Opção inválida!");
			} else if (index > 0 && index <= game.getNumberOfTeams()) {
				System.out.print("Informe o nome do jogador: ");
				name = scan.nextLine();
				game.getTeam(index-1).addPlayer(new Player(name));
			}
			System.out.println("\n");
			break;
		case 3:
			System.out.print("Times existentes:\n" + game.getTeamsList());
			System.out.println((game.getNumberOfTeams() + 1) + "- Voltar ao menu inicial");
			System.out.print("\nA qual time pertence o jogador? ");
			index = scan.nextInt();
			lixo = scan.nextLine();
			if (index > game.getNumberOfTeams() + 1 || index < 1) {
				System.out.println("Opção inválida!");
			} else if (index > 0 && index <= game.getNumberOfTeams()) {
				Team team = game.getTeam(index-1);
				if (team.hasPlayer()) {
					System.out.print("Jogadores registrados:\n" + team.getPlayersList());
					System.out.println((team.getNumberOfPlayers() + 1) + "- Voltar");
					System.out.print("\nOs exércitos pertencerão a qual jogador? ");
					int playerIndex = scan.nextInt();
					lixo = scan.nextLine();
					if (playerIndex > team.getNumberOfPlayers() + 1 || playerIndex < 1) {
						System.out.println("Opção inválida!");
					} else if (playerIndex > 0 && playerIndex <= team.getNumberOfPlayers()) {
						System.out.print("Informe a quantidade de exércitos: ");
						int army = scan.nextInt();
						lixo = scan.nextLine();
						team.getPlayer(playerIndex-1).setArmy(army);
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
