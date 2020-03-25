package novo;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Text texto = new Text();
		Controller executor = new Controller();
		String input, msg;
		do {
			boolean hasUndo = texto.getHasUndoAction();
			boolean hasRedo = texto.getHasRedoAction();
			if (hasUndo && hasRedo) {
				msg = "Entre com o texto (digite \"z\" para desfazer, \"y\" para refazer ou \"Sair\" para encerrar):";
			} else if (hasUndo) {
				msg = "Entre com o texto (digite \"z\" para desfazer ou \"Sair\" para encerrar): ";
			} else if (hasRedo) {
				msg = "Entre com o texto (digite \"y\" para refazer ou \"Sair\" para encerrar): ";
			} else {
				msg = "Entre com o texto (digite \"Sair\" para encerrar): ";
			}
			System.out.println(msg);
			input = scan.nextLine();
			texto.add(input);
			if (hasUndo && input.equalsIgnoreCase("z")) {
				executor.executeOperation(new UndoCommand(texto));
			} else if (hasRedo && input.equalsIgnoreCase("y")) {
				executor.executeOperation(new RedoCommand(texto));
			} else if (input.equalsIgnoreCase("sair")) {
				System.out.println("Encerrado!");
			} else {
				executor.executeOperation(new SaveCommand(texto));
			}
			if (!input.equalsIgnoreCase("sair")) {
				System.out.println("Texto atual:\n" + texto.getEntireText());
			}
		} while (!input.equalsIgnoreCase("sair"));
		scan.close();
	}
}
