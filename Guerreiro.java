public class Guerreiro extends Personagem {

	public Guerreiro(String nome, int vidaMaxima, int vida, int ataque, int defesa, Inventario inventario) {
		super(nome, vidaMaxima, vida, ataque, defesa, inventario);
	}

	public Guerreiro(String nome) {
		super(nome, 60, 60, 5, 2);
	}
}
