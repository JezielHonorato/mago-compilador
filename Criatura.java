public class Criatura extends Entidade {
	private final String nome;
	private int vidaMaxima;
	private int vida;
	private int ataque;
	private int defesa;

	public boolean estaVivo() {
		return vida > 0;
	}

	public String getNome() {
		return nome;
	}

	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public int getVida() {
		return vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefesa() {
		return defesa;
	}
}