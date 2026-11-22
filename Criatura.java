public class Criatura extends Entidade {
	private final String nome;
	private int vidaMaxima;
	private int vida;
	private int ataque;
	private int defesa;

	public Criatura(int ataque, int defesa, String nome, int vida, int vidaMaxima) {
		this.ataque = ataque;
		this.defesa = defesa;
		this.nome = nome;
		this.vida = vida;
		this.vidaMaxima = vidaMaxima;
	}

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

	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
}