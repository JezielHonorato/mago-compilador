public abstract class Usuario extends Entidade {
	private final String login;
	private String senha;

	public boolean checarSenha(String senha) {
		return senha.equals(senha);
	}
}
