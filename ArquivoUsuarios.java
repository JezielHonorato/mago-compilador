
import java.nio.file.Path;
import java.util.Optional;

public class ArquivoUsuarios extends Arquivo<Usuario> {
	public ArquivoUsuarios(Path pasta) {
		super(pasta.resolve("usuarios.txt"), "usuário");
	}

	public Optional<Usuario> buscarPorLogin(String login) {
		return listar().stream().filter(u -> u.getLogin().equalsIgnoreCase(login == null ? "" : login.trim()))
				.findFirst();
	}

	@Override
	protected String chaveUnica(Usuario u) {
		return u.getLogin();
	}

	@Override
	protected String serializar(Usuario u) {
		String base = String.join("|", u.getPerfil().name(), String.valueOf(u.getId()), u.getLogin(), u.getSenha());
		if (u instanceof Mestre)
			return base;
		Aventureiro a = (Aventureiro) u;
		return base + "|" + a.getPartidasJogadas() + "|" + a.getPontuacaMaxima();
	}

	@Override
	protected Usuario desserializar(String[] c) {
		String nome = c[0];
		int id = Integer.parseInt(c[1]);
		String login = c[2];
		String senha = c[3];
		return switch (nome) {
			case "MESTRE" -> new Mestre(id, login, senha);
			case "AVENTUREIRO" -> new Aventureiro(id, login, senha, Integer.parseInt(c[4]), Integer.parseInt(c[5]));
			default -> throw new IllegalArgumentException("perfil desconhecido: " + nome);
		};
	}
}
