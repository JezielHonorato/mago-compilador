public class Aventureiro extends Usuario {
	private int pontuacaMaxima;
	private int partidasJogadas;

	public Aventureiro(int id, String login, String senha, int pontuacaMaxima, int partidasJogadas) {
		super(id, login, senha);
		this.pontuacaMaxima = pontuacaMaxima;
		this.partidasJogadas = partidasJogadas;
	}

	public Aventureiro(String login, String senha) {
		this(0, login, senha, 0, 0);
	}

	public static Aventureiro registrarAventureiro(ArquivoUsuarios arquivoUsuarios, String login, String senha) {
		Aventureiro aventureiro = new Aventureiro(login, senha);
		arquivoUsuarios.adicionar(aventureiro);
		return aventureiro;
	}

	public void atualizarEstatisticas(int pontuacao) {
		partidasJogadas++;
		pontuacaMaxima = Math.max(pontuacaMaxima, pontuacao);
	}

	public int getPontuacaMaxima() {
		return pontuacaMaxima;
	}

	public int getPartidasJogadas() {
		return partidasJogadas;
	}

	@Override
	public Perfil getPerfil() {
		return Perfil.AVENTUREIRO;
	}
}
