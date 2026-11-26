public class Pocao extends Item{
    private final int cura;

    public Pocao(String nome, int valor, int cura){
        super(nome, valor);
        this.cura = cura;
    }

    public int getCura() {
        return cura;
    }

    @Override
    public String usar(Personagem personagem) {
        if(personagem.getVida() >= personagem.getVidaMaxima()){
            //exception
        }

        int curou = personagem.curar(this.getCura());
        personagem.getInventario().removerItem(this);
        return "Você bebeu " + getNome() + " e recuperou " + curou + " pontos de vida.";
    }

    @Override
    public String descricao() {
        return getNome() + " (" + getTipo() + "), " + cura + " (Pontos de Cura), "
                + getValor() + " (Valor em Ouro).";
    }
}
