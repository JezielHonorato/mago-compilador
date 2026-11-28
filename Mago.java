public class Mago extends Personagem {

	public Mago(String nome, int vidaMaxima, int vida, int ataque, int defesa, Inventario inventario) {
		super(nome, vidaMaxima, vida, ataque, defesa, inventario);
	}

	public Mago(String nome) {
		super(nome, 40, 40, 3, 0);
	}
}
