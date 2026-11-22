import java.util.Scanner;

public class Menu {
	Scanner scanner = new Scanner(System.in);

	public void exibirMenu() {
		System.out.println("!===! RPG - Mago Compilador !===!");
		System.out.println("1) Entrar");
		System.out.println("2) Criar nova conta de Aventureiro");
		System.out.println("0) Sair");

		System.out.print("opção: ");
		int opcEscolhida = scanner.nextInt();
		System.out.println("");

		switch (opcEscolhida) {
			case 1 -> this.exibirMenuLogin();
			case 2 -> this.exibirMenuCriarContaAventureiro();
			case 0 -> System.out.println("Até a próxima!");
			default -> System.out.println("Escolha uma opção válida");
		}

	}

	private void exibirMenuLogin() {
		System.out.println("!====! RPG - Mago Compilador !====!");
		System.out.println("!===! Digite suas credenciais !===!");

		System.out.print("Login: ");
		scanner.nextLine(); // sem essa linha ele tava lendo o vazio;
		String login = scanner.nextLine();

		System.out.print("Senha: ");
		String senha = scanner.nextLine();
		// Usuario usuario = Usuario.logar(login, senha);

		System.out.print("Bem-vindo, " + login + " [" + senha + "]!");

		System.out.println("Erro no servidor, tente novamente mais tarde!");
	}

	private void exibirMenuCriarContaAventureiro() {
		System.out.println("!=============! RPG - Mago Compilador !=============!");
		System.out.println("!===! Digite as credenciais do novo Aventureito !===!");

		System.out.print("Login: ");
		scanner.nextLine(); // sem essa linha ele tava lendo o vazio;
		String login = scanner.nextLine();

		System.out.print("Senha: ");
		String senha = scanner.nextLine();
		Aventureiro aventureiro = new Aventureiro(login, senha);

		System.out.print("Usuário, " + aventureiro.getLogin() + " criado com sucesso!");

		System.out.println("Erro no servidor, tente novamente mais tarde!");
	}

}
