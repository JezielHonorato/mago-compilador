import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("!===! RPG - Mago Compilador !===!");
		System.out.println("1) Entrar");
		System.out.println("2) Criar nova conta de Aventureiro");
		System.out.println("0) Sair");

		System.out.print("opção: ");
		int opcEscolhida = scanner.nextInt();
		System.out.println("");

		switch (opcEscolhida) {
			case 1 -> System.out.println("Erro no servidor, tente novamente mais tarde!");
			case 2 -> System.out.println("Erro no servidor, tente novamente mais tarde!");
			case 0 -> System.out.println("Até a próxima!");

		}

	}
}