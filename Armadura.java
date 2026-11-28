import excecoes.EquipamentoInvalidoException;

public class Armadura extends Item {
    private final int defesa;
    private final int nivelRequerido;

    public Armadura(String nome, int valor, int defesa, int nivelRequerido, Raridade raridade) {
        super(nome, valor, raridade);
        if (defesa > getRaridade().getPoderMaximo()) {
            this.defesa = getRaridade().getPoderMaximo();
        } else {
            this.defesa = defesa;
        }
        this.nivelRequerido = nivelRequerido;
    }

    public Armadura(String nome, int valor, int defesa, int nivelRequerido) {
        this(nome, valor, defesa, nivelRequerido, Raridade.determinarPorPoder(defesa));
    }

    public int getDefesa() {
        return defesa;
    }

    public int getNivelRequerido() {
        return nivelRequerido;
    }

    @Override
    public String usar(Personagem personagem) {
        if (!personagem.equipar(this)) {
            throw new EquipamentoInvalidoException("Nível insuficiente para vestir " + getNome()
                    + " (requer nível " + nivelRequerido + ").");
        }
        return "Você vestiu " + this.getNome() + " [" + getRaridade() + "].";
    }

    @Override
    public String descricao() {
        return getNome() + " [" + getRaridade() + "] (" + getTipo() + "), " + defesa + " (Defesa), "
                + nivelRequerido + " (Nível Necessário), " + getValor() + " (Valor em Ouro).";
    }
}