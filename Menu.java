import java.util.Scanner;
import java.nio.file.Path;

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

		Usuario usuarioAtual = arquivoUsuarios.buscarPorLogin(login).orElse(null);

		if (usuarioAtual == null) {
			System.out.println("Login não encontrado."); //implementar mensagem de erro
			return;
		}

		if (!usuarioAtual.logar(usuarioAtual.getLogin(), senha)){
			System.out.println("Senha incorreta");
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
			case 3 -> this.exibirMenuMonstro();
			case 4 -> System.out.println("Erro no servidor, tente novamente mais tarde!");
			case 0 -> System.out.println("Erro no servidor, tente novamente mais tarde!");
			default -> System.out.println("Escolha uma opção válida");
		}
	}

	private void exibirMenuMonstro(){
		System.out.println("!===! RPG - Mago Compilador ( nome do login ) !===!"); // editar dps;
		System.out.println("1) Listar ");
		System.out.println("2) Adicionar");
		System.out.println("3) Remover");
		System.out.println("4) Atualizar");
		System.out.println("0) Sair");

		System.out.print("opção: ");
		int opcEscolhida = scanner.nextInt();
		System.out.println("");

		switch (opcEscolhida) {
			case 1 : this.exibirTodosMonstros();
			break;
			case 2 : this.exibirMenuAdicionarMonstro();
			break;
			case 3 : this.exibirMenuRemoverMonstro();
			break;
			case 4 : this.exibirMenuAtualizarMonstro();
			break;
			case 0 : System.out.println("Erro no servidor, tente novamente mais tarde!");
			break;
			default : System.out.println("Escolha uma opção válida");
		}
	}

	private void exibirMenuRemoverMonstro() {
		System.out.println("!===! RPG - Mago Compilador ( nome do login ) !===!"); // editar dps;
		System.out.println("!===! Remover Monstro !===!");
		System.out.print("ID do Monstro: ");
		int id = scanner.nextInt();

		ArquivoMonstro arquivoMonstro = new ArquivoMonstro(Path.of("data"));
		arquivoMonstro.carregarArquivo();
		try {
			arquivoMonstro.remover(id);
			System.out.println("Monstro com ID " + id + " removido com sucesso!");
		} catch (IllegalArgumentException e) {
			System.out.println("Não foi possível remover o monstro: " + e.getMessage());
		}
	}

	private void exibirMenuAtualizarMonstro() {
		System.out.println("!===! RPG - Mago Compilador ( nome do login ) !===!"); // editar dps;
		System.out.println("!===! Atualizar Monstro !===!");
		System.out.print("ID do Monstro: ");
		int id = scanner.nextInt();

		ArquivoMonstro arquivoMonstro = new ArquivoMonstro(Path.of("data"));
		arquivoMonstro.carregarArquivo();
		Monstro monstro = arquivoMonstro.buscar(id);

		if (monstro == null) {
			System.out.println("Monstro com ID " + id + " não encontrado.");
			return;
		}

		System.out.print("O Nome se mantém igual");
		scanner.nextLine(); // sem essa linha ele tava lendo o vazio;

		System.out.print("Novo Ataque (atual: " + monstro.getAtaque() + "): ");
		int novoAtaque = scanner.nextInt();

		System.out.print("Nova Defesa (atual: " + monstro.getDefesa() + "): ");
		int novaDefesa = scanner.nextInt();

		System.out.print("Nova Vida Máxima (atual: " + monstro.getVidaMaxima() + "): ");
		int novaVidaMaxima = scanner.nextInt();

		System.out.print("Nova Vida Atual (atual: " + monstro.getVida() + "): ");
		int novaVidaAtual = scanner.nextInt();

		monstro.setAtaque(novoAtaque);
		monstro.setDefesa(novaDefesa);
		monstro.setVidaMaxima(novaVidaMaxima);
		monstro.setVida(novaVidaAtual);

		try {
			arquivoMonstro.atualizar(monstro);
			System.out.println("Monstro \"" + monstro.getNome() + "\" atualizado com sucesso!");
		} catch (IllegalArgumentException e) {
			System.out.println("Não foi possível atualizar o monstro: " + e.getMessage());
		}
	}

	private void exibirMenuAdicionarMonstro() {
		System.out.println("!===! RPG - Mago Compilador ( nome do login ) !===!"); // editar dps;
		System.out.println("!===! Adicionar Monstro !===!");
		System.out.print("Nome: ");
		scanner.nextLine(); // sem essa linha ele tava lendo o vazio;
		String nome = scanner.nextLine();

		System.out.print("Ataque: ");
		int ataque = scanner.nextInt();

		System.out.print("Defesa: ");
		int defesa = scanner.nextInt();

		System.out.print("Vida Máxima: ");
		int vidaMaxima = scanner.nextInt();

		System.out.print("Vida Atual: ");
		int vidaAtual = scanner.nextInt();

		Monstro monstro = new Monstro(ataque, defesa, nome, vidaAtual, vidaMaxima);
		ArquivoMonstro arquivoMonstro = new ArquivoMonstro(Path.of("data"));
		arquivoMonstro.carregarArquivo();
		arquivoMonstro.adicionar(monstro);

		System.out.println("Monstro \"" + monstro.getNome() + "\" adicionado com sucesso! (ID: " + monstro.getId() + ")");
	}

	private void exibirTodosMonstros() {
		System.out.println("!===! RPG - Mago Compilador ( nome do login ) !===!"); // editar dps;
		System.out.println("!===! Lista de Monstros !===!");
		System.out.println("ID | Nome | Ataque | Defesa | Vida Máxima | Vida Atual");
		ArquivoMonstro arquivoMonstro = new ArquivoMonstro(Path.of("data"));
		arquivoMonstro.carregarArquivo();
		for (Monstro m : arquivoMonstro.listar()) {
			System.out.println(m.getId() + " | " + m.getNome() + " | " + m.getAtaque() + " | " + m.getDefesa()
					+ " | " + m.getVidaMaxima() + " | " + m.getVida());
		}
	}
}
