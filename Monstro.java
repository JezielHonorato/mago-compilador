public class Monstro extends Criatura {

	public Monstro(int ataque, int defesa, String nome, int vida, int vidaMaxima) {
		super(ataque, defesa, nome, vida, vidaMaxima);
	}

	public Monstro(int id, int ataque, int defesa, String nome, int vida, int vidaMaxima) {
		super(ataque, defesa, nome, vida, vidaMaxima);
		setId(id);
	}

	//Necessário checar a implementação
	@Override
	public int calcularAtaque(){
		return getAtaque();
	}

	@Override
	public int calcularDefesa(){
		return getDefesa();
	}
}
