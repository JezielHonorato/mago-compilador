import java.nio.file.Path;

public class Menu {
	private final Console console;
	Usuario usuarioLogado = null;

	private final ArquivoUsuarios arquivoUsuarios;

	public Menu(ArquivoUsuarios arquivoUsuarios) {
		this.console = new Console();
		this.arquivoUsuarios = arquivoUsuarios;
	}

	public void exibirMenu() {
		int opcao;
		do {
			console.printTitulo();
			console.println("1) Entrar");
			console.println("2) Criar nova conta de Aventureiro");
			console.println("0) Sair");

			opcao = console.lerRangeInteiro("Opção:", 0, 2);

			switch (opcao) {
				case 1 -> this.exibirMenuLogin();
				case 2 -> this.exibirMenuCriarContaAventureiro();
				case 0 -> console.println("Até a próxima!");
			}
		} while (opcao != 0);
	}

	private void exibirMenuLogin() {
		console.printTitulo();
		console.println("!===! Digite suas credenciais !===!");

		String login = console.lerLinha("Login:");
		String senha = console.lerLinha("Senha:");

		Usuario usuarioAtual = arquivoUsuarios.buscarPorLogin(login).orElse(null);

		if (usuarioAtual == null) {
			console.println("Login não encontrado.");
			return;
		}

		if (!usuarioAtual.logar(usuarioAtual.getLogin(), senha)) {
			console.println("Senha incorreta.");
			return;
		}

		this.usuarioLogado = usuarioAtual;
		console.println("Bem-vindo, " + usuarioAtual.getLogin() + "!");

		if (usuarioAtual instanceof Aventureiro) {
			this.exibirMenuAventureiro();
		} else {
			this.exibirMenuMestre();
		}
	}

	private void exibirMenuCriarContaAventureiro() {
		console.printTitulo();
		console.println("!===! Digite as credenciais do novo Aventureiro !===!");

		String login = console.lerLinha("Login:");
		String senha = console.lerLinha("Senha:");

		try {
			Aventureiro aventureiro = Aventureiro.registrarAventureiro(arquivoUsuarios, login, senha);
			console.println(
					"Usuário " + aventureiro.getLogin() + " criado com sucesso! (ID: " + aventureiro.getId() + ")");
		} catch (IllegalArgumentException e) {
			console.println("Não foi possível cadastrar: " + e.getMessage());
		}
	}

	private void exibirMenuAventureiro() {
		int opcao;
		do {
			console.printTitulo(this.usuarioLogado.getLogin());
			console.println("1) Nova Partida");
			console.println("2) Ranking");
			console.println("3) Histórico");
			console.println("0) Sair da conta");

			opcao = console.lerRangeInteiro("Opção:", 0, 3);

			switch (opcao) {
				case 1 -> this.exibirMenuPartida();
				case 2 -> console.println("Erro no servidor, tente novamente mais tarde!");
				case 3 -> console.println("Erro no servidor, tente novamente mais tarde!");
				case 0 -> {
					this.usuarioLogado = null;
					console.println("Voltando ao menu principal...");
				}
			}
		} while (opcao != 0);
	}

	private void exibirMenuMestre() {
		int opcao;
		do {
			console.printTitulo(this.usuarioLogado.getLogin());
			console.println("1) Usuários");
			console.println("2) Itens");
			console.println("3) Monstros");
			console.println("4) Relatórios");
			console.println("0) Sair da conta");

			opcao = console.lerRangeInteiro("Opção:", 0, 4);

			switch (opcao) {
				case 1 -> console.println("Erro no servidor, tente novamente mais tarde!");
				case 2 -> console.println("Erro no servidor, tente novamente mais tarde!");
				case 3 -> this.exibirMenuMonstro();
				case 4 -> console.println("Erro no servidor, tente novamente mais tarde!");
				case 0 -> {
					this.usuarioLogado = null;
					console.println("Voltando ao menu principal...");
				}
			}
		} while (opcao != 0);
	}

	private void exibirMenuMonstro() {
		int opcao;
		do {
			console.printTitulo(this.usuarioLogado.getLogin());
			console.println("!==============!  Menu de Monstros !==============!");
			console.println("1) Listar");
			console.println("2) Adicionar");
			console.println("3) Remover");
			console.println("4) Atualizar");
			console.println("0) Voltar");

			opcao = console.lerRangeInteiro("Opção:", 0, 4);

			switch (opcao) {
				case 1 -> this.exibirTodosMonstros();
				case 2 -> this.exibirMenuAdicionarMonstro();
				case 3 -> this.exibirMenuRemoverMonstro();
				case 4 -> this.exibirMenuAtualizarMonstro();
				case 0 -> console.println("Voltando ao menu do Mestre...");
			}
		} while (opcao != 0);
	}

	private void exibirMenuRemoverMonstro() {
		console.printTitulo(this.usuarioLogado.getLogin());
		console.println("!===! Remover Monstro !===!");
		int id = console.lerInteiro("ID do Monstro:");

		ArquivoMonstro arquivoMonstro = new ArquivoMonstro(Path.of("data"));
		arquivoMonstro.carregarArquivo();
		try {
			arquivoMonstro.remover(id);
			console.println("Monstro com ID " + id + " removido com sucesso!");
		} catch (IllegalArgumentException e) {
			console.println("Não foi possível remover o monstro: " + e.getMessage());
		}
	}

	private void exibirMenuAtualizarMonstro() {
		console.printTitulo(this.usuarioLogado.getLogin());
		console.println("!==============! Atualizar Monstro !==============!");
		int id = console.lerInteiro("ID do Monstro:");

		ArquivoMonstro arquivoMonstro = new ArquivoMonstro(Path.of("data"));
		arquivoMonstro.carregarArquivo();
		Monstro monstro = arquivoMonstro.buscar(id);

		if (monstro == null) {
			console.println("Monstro com ID " + id + " não encontrado.");
			return;
		}

		console.println("O Nome se mantém igual");
		int novoAtaque = console.lerInteiro("Novo Ataque (atual: " + monstro.getAtaque() + "):");
		int novaDefesa = console.lerInteiro("Nova Defesa (atual: " + monstro.getDefesa() + "):");
		int novaVidaMaxima = console.lerInteiro("Nova Vida Máxima (atual: " + monstro.getVidaMaxima() + "):");
		int novaVidaAtual = console.lerInteiro("Nova Vida Atual (atual: " + monstro.getVida() + "):");

		monstro.setAtaque(novoAtaque);
		monstro.setDefesa(novaDefesa);
		monstro.setVidaMaxima(novaVidaMaxima);
		monstro.setVida(novaVidaAtual);

		try {
			arquivoMonstro.atualizar(monstro);
			console.println("Monstro \"" + monstro.getNome() + "\" atualizado com sucesso!");
		} catch (IllegalArgumentException e) {
			console.println("Não foi possível atualizar o monstro: " + e.getMessage());
		}
	}

	private void exibirMenuAdicionarMonstro() {
		console.printTitulo(this.usuarioLogado.getLogin());
		console.println("!==============! Adicionar Monstro !==============!");

		String nome = console.lerLinha("Nome:");
		int ataque = console.lerInteiro("Ataque:");
		int defesa = console.lerInteiro("Defesa:");
		int vidaMaxima = console.lerInteiro("Vida Máxima:");
		int vidaAtual = console.lerInteiro("Vida Atual:");

		Monstro monstro = new Monstro(ataque, defesa, nome, vidaAtual, vidaMaxima);
		ArquivoMonstro arquivoMonstro = new ArquivoMonstro(Path.of("data"));
		arquivoMonstro.carregarArquivo();
		arquivoMonstro.adicionar(monstro);

		console.println("Monstro " + monstro.getNome() + " adicionado com sucesso! (ID: " + monstro.getId() + ")");
	}

	private void exibirTodosMonstros() {
		console.printTitulo(this.usuarioLogado.getLogin());
		console.println("!==============! Lista de Monstros !==============!");
		console.println("ID | Nome | Ataque | Defesa | Vida Máxima | Vida Atual");
		ArquivoMonstro arquivoMonstro = new ArquivoMonstro(Path.of("data"));
		arquivoMonstro.carregarArquivo();
		for (Monstro m : arquivoMonstro.listar()) {
			console.println(m.getId() + " | " + m.getNome() + " | " + m.getAtaque() + " | " + m.getDefesa()
					+ " | " + m.getVidaMaxima() + " | " + m.getVida());
		}
	}

	private void exibirMenuPartida() {
		console.printTitulo(this.usuarioLogado.getLogin());
		console.println("!===! Nova Partida - Cadastrar Personagem !===!");

		console.println("Escolha o tipo do seu personagem");
		for (TipoPersonagem tipo : TipoPersonagem.values()) {
			console.println((tipo.ordinal() + 1) + ") " + tipo.getNome());
		}
		console.println("0) Sair");
		int opcaoClasse = console.lerRangeInteiro("Opção:", 0, TipoPersonagem.values().length);
		TipoPersonagem tipoPersonagem = TipoPersonagem.values()[opcaoClasse - 1];

		String nomePersonagem = console.lerLinha("Escolha o nome do seu personagem (digite 0 para voltar ao menu)");
		if (nomePersonagem.equals("0")) {
			this.exibirMenuAventureiro();
		}

		Personagem personagem = Personagem.criar(tipoPersonagem, nomePersonagem);
		iniciarPartida(personagem);
	}

	private void iniciarPartida(Personagem personagem) {
		console.println("Erro no servidor, tente novamente mais tarde!");
	}
}