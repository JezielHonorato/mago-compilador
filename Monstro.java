public class Monstro extends Criatura {

	public Monstro(String nome, int vidaMaxima, int vida, int ataque, int defesa) {
		super(nome, vidaMaxima, vida, ataque, defesa);
	}

	public Monstro(int id, String nome, int vidaMaxima, int vida, int ataque, int defesa) {
		super(nome, vidaMaxima, vida, ataque, defesa);
		setId(id);
	}

	// Necessário checar a implementação
	@Override
	public int calcularAtaque() {
		return getAtaque();
	}

	@Override
	public int calcularDefesa() {
		return getDefesa();
	}
}
