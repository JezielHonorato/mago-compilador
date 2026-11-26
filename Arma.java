public class Arma extends Item{
    private final int dano;
    private final int nivelRequerido;
    private final TipoArmas tipoArma;

    public Arma(String nome, int valor, int dano, int nivelRequerido,  TipoArmas tipoArma){
        super(nome, valor);
        this.dano = dano;
        this.nivelRequerido = nivelRequerido;
        this.tipoArma = tipoArma;
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
    public String usar(Personagem personagem){
        personagem.equipar(this);
        return "Você empulhou " + getNome() + ".";
    }

    @Override
    public String descricao(){
        return getNome() + " (" + tipoArma + "), " + dano + " (dano), "
                + nivelRequerido + " (nível necessário), " + getValor() + " (Valor em Ouro).";
    }
}
