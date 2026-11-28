public abstract class Criatura extends Entidade {
	private final String nome;
	private int vidaMaxima;
	private int vida;
	private int ataque;
	private int defesa;

	public Criatura(String nome, int vidaMaxima, int vida, int ataque, int defesa) {
		this.nome = nome;
		this.vidaMaxima = vidaMaxima;
		this.vida = vida;
		this.ataque = ataque;
		this.defesa = defesa;
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

	public abstract int calcularAtaque();

	public abstract int calcularDefesa();

	public final int receberAtaque(int poder, double penetracao) {
		int def = (int) Math.round(calcularDefesa() * (1.0 - penetracao));
		int dano = Math.max(1, poder - def);
		dano = absorverDano(dano);
		vida = Math.max(0, vida - dano);
		aoReceberDano(dano);
		return dano;
	}

	public int receberAtaque(int poder) {
		return receberAtaque(poder, 0.0);
	}

	public int curar(int quantidade) {
		int antes = vida;
		vida = Math.min(vidaMaxima, vida + quantidade);
		return vida - antes;
	}

	public int sofrerDanoAmbiental(int quantidade) {
		int perda = Math.max(0, Math.min(quantidade, vida - 1));
		vida -= perda;
		return perda;
	}

	protected int absorverDano(int dano) {
		return dano;
	}

	protected void aoReceberDano(int dano) {
	}

	protected void aumentarAtributos(int vida, int atk, int def) {
		vidaMaxima += vida;
		ataque += atk;
		defesa += def;
	}
}