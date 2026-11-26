import java.util.Scanner;

public class Menu {
	Scanner scanner = new Scanner(System.in);
	private final ArquivoUsuarios arquivoUsuarios;

	public Menu(ArquivoUsuarios arquivoUsuarios) {
		this.arquivoUsuarios = arquivoUsuarios;
	}

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

		Usuario usuarioAtual = arquivoUsuarios.buscarPorLogin(login).orElse(null);

		if (usuarioAtual == null) {
			System.out.println("Login não encontrado."); //implementar mensagem de erro
			return;
		}

		System.out.println("Bem-vindo, " + usuarioAtual.getLogin() + "!");

		if (usuarioAtual instanceof Aventureiro) {
			this.exibirMenuAventureiro(); //resolver depois
		} else{
			this.exibirMenuMestre();
		}
		
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

		try {
			Aventureiro aventureiro = Aventureiro.registrarAventureiro(arquivoUsuarios, login, senha);
			System.out.println(
					"Usuário \"" + aventureiro.getLogin() + "\" criado com sucesso! (ID: " + aventureiro.getId() + ")");
		} catch (IllegalArgumentException e) {
			System.out.println("Não foi possível cadastrar: " + e.getMessage());
		}

	}

	private void exibirMenuAventureiro() {
		System.out.println("!===! RPG - Mago Compilador ( nome do login ) !===!"); // editar dps;
		System.out.println("1) Nova Partida");
		System.out.println("2) Ranking");
		System.out.println("3) Histórico");
		System.out.println("0) Sair");

		System.out.print("opção: ");
		int opcEscolhida = scanner.nextInt();
		System.out.println("");

		switch (opcEscolhida) {
			case 1 -> System.out.println("Erro no servidor, tente novamente mais tarde!");
			case 2 -> System.out.println("Erro no servidor, tente novamente mais tarde!");
			case 3 -> System.out.println("Erro no servidor, tente novamente mais tarde!");
			case 0 -> System.out.println("Erro no servidor, tente novamente mais tarde!");
			default -> System.out.println("Escolha uma opção válida");
		}
	}

	private void exibirMenuMestre() {
		System.out.println("!===! RPG - Mago Compilador ( nome do login ) !===!"); // editar dps;
		System.out.println("1) Usuários");
		System.out.println("2) Itens");
		System.out.println("3) Monstros");
		System.out.println("4) Relatórios");
		System.out.println("0) Sair");

		System.out.print("opção: ");
		int opcEscolhida = scanner.nextInt();
		System.out.println("");

		switch (opcEscolhida) {
			case 1 -> System.out.println("Erro no servidor, tente novamente mais tarde!");
			case 2 -> System.out.println("Erro no servidor, tente novamente mais tarde!");
			case 3 -> System.out.println("Erro no servidor, tente novamente mais tarde!");
			case 4 -> System.out.println("Erro no servidor, tente novamente mais tarde!");
			case 0 -> System.out.println("Erro no servidor, tente novamente mais tarde!");
			default -> System.out.println("Escolha uma opção válida");
		}
	}

}
