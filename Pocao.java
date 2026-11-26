public class Pocao extends Item {
    private final int cura;

    public Pocao(String nome, int valor, int cura, Raridade raridade) {
        super(nome, valor, raridade);
        if (cura > getRaridade().getPoderMaximo()) {
            this.cura = getRaridade().getPoderMaximo();
        } else {
            this.cura = cura;
        }
    }

    public Pocao(String nome, int valor, int cura) {
        this(nome, valor, cura, Raridade.determinarPorPoder(cura));
    }

    public int getCura() {
        return cura;
    }

    @Override
    public String usar(Personagem personagem) {
        if (personagem.getVida() >= personagem.getVidaMaxima()) {
            return "Sua vida já está cheia! " + getNome() + " não foi consumida.";
        }

        int curou = personagem.curar(this.getCura());
        personagem.getInventario().removerItem(this);
        return "Você bebeu " + getNome() + " [" + getRaridade() + "] e recuperou " + curou + " pontos de vida.";
    }

    @Override
    public String descricao() {
        return getNome() + " [" + getRaridade() + "] (" + getTipo() + "), " + cura + " (Pontos de Cura), "
                + getValor() + " (Valor em Ouro).";
    }
}