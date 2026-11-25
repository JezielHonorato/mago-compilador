public abstract class Usuario extends Entidade {
	private final String login;
	private final String senha;

	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public Usuario(int id, String login, String senha) {
		setId(id);
		this.login = login;
		this.senha = senha;
	}

	public Usuario logar(String login, String senha) {
		// Retornar o usuario encontrado ao filtrar o nome;
		Usuario usuario = this.procurarUsuario(login);
		// colocar tudo num try pra se nao existir
		if (!usuario.checarSenha(senha)) {
			// lançar erro;
			//System.out.println("Senha errada"); //implementação temporária
		}
		return usuario;
	}

	private Usuario procurarUsuario(String login) {
		// noa uqero mexer nisso agora
	
		System.err.println(this.login);
		Usuario usuario = new Aventureiro(login, "senha");
		return usuario;
	}

	private boolean checarSenha(String senha) {
		return senha.equals(this.senha);
	}

	public String getLogin() {
		return this.login;
	}

	public String getSenha() {
		return senha;
	}

	public abstract Perfil getPerfil();
}
