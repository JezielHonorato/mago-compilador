public class Armadura extends Item{
    private final int defesa;
    private final int nivelRequerido;

    public Armadura(String nome, int valor, int defesa, int nivelRequerido){
        super(nome, valor);
        this.defesa = defesa;
        this.nivelRequerido = nivelRequerido;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getNivelRequerido() {
        return nivelRequerido;
    }

    @Override
    public String usar(Personagem personagem){
        personagem.equipar(this);
        return "Você vestiu " + this.getNome() + ".";
    }

    @Override
    public String descricao(){
        return getNome() + " (" + getTipo() + "), " + defesa + " (Defesa), "
                + nivelRequerido + " (Nível Necessário), " + getValor() + " (Valor em Ouro).";
    }
}
