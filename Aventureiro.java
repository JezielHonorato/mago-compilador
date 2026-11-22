public class Aventureiro extends Usuario {
	private int pontuacaMaxima;
	private int partidasJogadas;

	public Aventureiro(String login, String senha) {
		super(login, senha);
		this.pontuacaMaxima = 0;
		this.partidasJogadas = 0;
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
}
