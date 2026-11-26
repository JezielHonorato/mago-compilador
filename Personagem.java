public abstract class Personagem extends Criatura {
	private Arma arma;

	public Personagem(int ataque, int defesa, String nome, int vida, int vidaMaxima) {
		super(ataque, defesa, nome, vida, vidaMaxima);
	}

	//Necessário checar a implementação
	public void equipar(Arma novaArma){
		this.arma = novaArma;
	}

	//Necessário checar a implementação
	@Override
	public int calcularAtaque(){
		return getAtaque() + (arma != null ? arma.getDano() : 0);
	}
}
