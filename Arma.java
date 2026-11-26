public class Arma extends Item {
    private final int dano;
    private final int nivelRequerido;
    private final TipoArmas tipoArma;

    public Arma(String nome, int valor, int dano, int nivelRequerido, TipoArmas tipoArma, Raridade raridade) {
        super(nome, valor, raridade);
        if (dano > getRaridade().getPoderMaximo()) {
            this.dano = getRaridade().getPoderMaximo();
        } else {
            this.dano = dano;
        }
        this.nivelRequerido = nivelRequerido;
        this.tipoArma = tipoArma;
    }

    public Arma(String nome, int valor, int dano, int nivelRequerido, TipoArmas tipoArma) {
        this(nome, valor, dano, nivelRequerido, tipoArma, Raridade.determinarPorPoder(dano));
    }

    public int getDano() {
        return dano;
    }

    public int getNivelRequerido() {
        return nivelRequerido;
    }

    public TipoArmas getTipoArma() {
        return tipoArma;
    }

    @Override
    public String usar(Personagem personagem) {
        if (!personagem.equipar(this)) {
            return "Nível insuficiente para equipar " + getNome() + " (requer nível " + nivelRequerido + ").";
        }
        return "Você empunhou " + getNome() + " [" + getRaridade() + "].";
    }

    @Override
    public String descricao() {
        return getNome() + " [" + getRaridade() + "] (" + tipoArma + "), " + dano + " (Dano), "
                + nivelRequerido + " (Nível Necessário), " + getValor() + " (Valor em Ouro).";
    }
}