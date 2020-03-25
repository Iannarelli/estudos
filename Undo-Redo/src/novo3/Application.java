package novo3;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Text texto = new Text();
		Controller executor = new Controller(texto);
		String input, msg;
		do {
			boolean hasUndo = executor.getHasUndoAction();
			boolean hasRedo = executor.getHasRedoAction();
			if (hasUndo && hasRedo) {
				msg = "Entre com o texto (digite \"z\" para desfazer, \"y\" para refazer ou \"Sair\" para encerrar):";
			} else if (hasUndo) {
				msg = "Entre com o texto (digite \"z\" para desfazer ou \"Sair\" para encerrar): ";
			} else if (hasRedo) {
				msg = "Entre com o texto (digite \"y\" para refazer ou \"Sair\" para encerrar): ";
			} else {
				msg = "Entre com o texto (digite \"Sair\" para encerrarrr): ";
			}
			System.out.println(msg);
			input = scan.nextLine();
			if (hasUndo && input.equalsIgnoreCase("z")) {
				executor.undoOperation(new Input(input));
			} else if (hasRedo && input.equalsIgnoreCase("y")) {
				executor.executeOperation(new Input(input), true);
			} else if (input.equalsIgnoreCase("sair")) {
				System.out.println("Encerrado!");
			} else {
				executor.executeOperation(new Input(input), false);
			}
			if (!input.equalsIgnoreCase("sair")) {
				System.out.println("Texto atual:\n" + texto.getText());
			}
		} while (!input.equalsIgnoreCase("sair"));
		scan.close();
	}
}
