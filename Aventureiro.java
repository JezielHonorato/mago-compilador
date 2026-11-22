public class Aventureiro extends Usuario {
	private int pontuacaMaxima;
	private int partidasJogadas;

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
