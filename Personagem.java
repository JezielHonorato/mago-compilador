public abstract class Personagem extends Criatura {
	private int nivel;
	private int experiencia;
	private int ouro;
	private int energia;
	private int energiaMaxima;

	public Personagem(int ataque, int defesa, String nome, int vida, int vidaMaxima) {
		super(ataque, defesa, nome, vida, vidaMaxima);
		this.nivel = 1;
		this.experiencia = 0;
		this.ouro = 0;
		this.energiaMaxima = 10;
		this.energia = this.energiaMaxima;
	}

	public int atacar(Criatura alvo) {
		int dano = maior(1, this.getAtaque() - alvo.getDefesa());
		alvo.setVida(maior(0, alvo.getVida() - dano));
		return dano;
	}

	public void receberDano(int dano) {
		int danoFinal = maior(1, dano - this.getDefesa());
		this.setVida(maior(0, this.getVida() - danoFinal));
	}

	public void curar(int quantidade) {
		int novaVida = menor(this.getVidaMaxima(), this.getVida() + quantidade);
		this.setVida(novaVida);
	}

	public void ganharExperiencia(int xp) {
		this.experiencia += xp;
		while (this.experiencia >= this.nivel * 100) {
			this.experiencia -= this.nivel * 100;
			subirNivel();
		}
	}

	private void subirNivel() {
		this.nivel++;
		this.setVidaMaxima(this.getVidaMaxima() + 10);
		this.setVida(this.getVidaMaxima());
		this.setAtaque(this.getAtaque() + 2);
		this.setDefesa(this.getDefesa() + 1);
	}

	public void adicionarOuro(int quantidade) {
		this.ouro += quantidade;
	}

	public boolean gastarOuro(int quantidade) {
		if (quantidade > this.ouro) {
			return false;
		}
		this.ouro -= quantidade;
		return true;
	}

	private int maior(int a, int b) {
		if (a > b) {
			return a;
		}
		return b;
	}

	private int menor(int a, int b) {
		if (a < b) {
			return a;
		}
		return b;
	}

	public int getNivel() {
		return nivel;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public int getOuro() {
		return ouro;
	}

	public int getEnergia() {
		return energia;
	}

	public int getEnergiaMaxima() {
		return energiaMaxima;
	}
}
