import java.util.List;

public abstract class Personagem extends Criatura {
	private final Inventario inventario;
	private Arma arma;
	private Armadura armadura;

	public Personagem(int ataque, int defesa, String nome, int vida, int vidaMaxima, Inventario inventario) {
		super(ataque, defesa, nome, vida, vidaMaxima);
		this.inventario = inventario;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public Arma getArma() {
		return arma;
	}

	public Armadura getArmadura() {
		return armadura;
	}

	//Necessário checar a implementação
	public void equipar(Arma novaArma){
		if(arma != null) {
			inventario.adicionarItem(arma);
		}
		this.arma = novaArma;
	}

	//Necessário checar a implementação
	public void equipar(Armadura novaArmadura){
		if(armadura != null) {
			inventario.adicionarItem(armadura);
		}
		this.armadura = novaArmadura;
	}

	//Necessário checar a implementação
	@Override
	public int calcularAtaque(){
		return getAtaque() + (arma != null ? arma.getDano() : 0);
	}

	@Override
	public int calcularDefesa(){
		return getDefesa() + (armadura != null ? armadura.getDefesa() : 0);
	}
}
