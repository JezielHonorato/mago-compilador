import Excecoes.ArgumentoInvalidoException;
import Excecoes.GuildaException;
import Excecoes.ItemNaoEncontradoException;

public abstract class Personagem extends Criatura {

	private int nivel;
	private int experiencia;
	private int ouro;
	private int energia;
	private int energiaMaxima;
	private Inventario inventario;
	private Arma armaEquipada;
	private Armadura armaduraEquipada;

	public Personagem(int ataque, int defesa, String nome, int vida, int vidaMaxima, Inventario inventario) {
		super(ataque, defesa, nome, vida, vidaMaxima);
		this.nivel = 1;
		this.experiencia = 0;
		this.ouro = 0;
		this.energiaMaxima = 10;
		this.energia = this.energiaMaxima;
		this.inventario = (inventario != null) ? inventario : new Inventario();
	}

	public Personagem(int ataque, int defesa, String nome, int vida, int vidaMaxima) {
		this(ataque, defesa, nome, vida, vidaMaxima, new Inventario());
	}

	@Override
	public int calcularAtaque() {
		int bonus = (armaEquipada != null) ? armaEquipada.getDano() : 0;
		return this.getAtaque() + bonus;
	}

	@Override
	public int calcularDefesa() {
		int bonus = (armaduraEquipada != null) ? armaduraEquipada.getDefesa() : 0;
		return this.getDefesa() + bonus;
	}

	public int atacar(Criatura alvo) {
		return alvo.receberAtaque(this.calcularAtaque());
	}

	public String acharItem(Item item) {
		try {
			String resultado = this.inventario.adicionarItem(item);
			return "Você encontrou [" + item.getRaridade() + "] " + item.getNome() + "! " + resultado;
		}catch (ArgumentoInvalidoException e){
			return e.getMessage();
		}
	}

	public String usarItem(Item item) {
		try{
			if (item == null || !inventario.contem(item)) {
				throw new ItemNaoEncontradoException("Item não encontrado no inventário.");
			}
			return item.usar(this);
		}catch (GuildaException e){
			return e.getMessage();
		}
	}

	public boolean equipar(Arma arma) {
		if (arma == null || this.nivel < arma.getNivelRequerido()) {
			return false;
		}
		this.armaEquipada = arma;
		return true;
	}

	public boolean equipar(Armadura armadura) {
		if (armadura == null || this.nivel < armadura.getNivelRequerido()) {
			return false;
		}
		this.armaduraEquipada = armadura;
		return true;
	}

	public boolean consumirEnergia(int custo) {
		if (custo > this.energia) {
			return false;
		}
		this.energia -= custo;
		return true;
	}

	public void recuperarEnergia(int quantidade) {
		int novaEnergia = this.energia + quantidade;
		if (novaEnergia > this.energiaMaxima) {
			this.energia = this.energiaMaxima;
		} else {
			this.energia = novaEnergia;
		}
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
		this.aumentarAtributos(10, 2, 1);
		this.setVida(this.getVidaMaxima());
		this.energia = this.energiaMaxima;
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

	public Inventario getInventario() {
		return inventario;
	}

	public Arma getArmaEquipada() {
		return armaEquipada;
	}

	public Armadura getArmaduraEquipada() {
		return armaduraEquipada;
	}
}