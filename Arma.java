public class Arma extends Item{
    private int dano;
    private int nivelRequerido;

    public Arma(String nome, int valor, int dano, int nivelRequerido){
        super(nome, valor);
        setDano(dano);
        setNivelRequerido(nivelRequerido);
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getNivelRequerido() {
        return nivelRequerido;
    }

    public void setNivelRequerido(int nivelRequerido) {
        this.nivelRequerido = nivelRequerido;
    }

    @Override
    public String usar(Personagem personagem){
        personagem.equipar(this);
        return "Você empulhou " + getNome() + ".";
    }

    @Override
    public String descricao(){
        return getNome() + " (" + getTipo() + "), " + dano + " (dano), "
                + nivelRequerido + " nível, " + getValor() + " (Valor em Ouro).";
    }
}
