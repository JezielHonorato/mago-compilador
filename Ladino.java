public class Ladino extends Personagem {

	public Ladino(String nome, int vidaMaxima, int vida, int ataque, int defesa, Inventario inventario) {
		super(nome, vidaMaxima, vida, ataque, defesa, inventario);
	}

	public Ladino(String nome) {
		super(nome, 45, 45, 4, 1);
	}
}
