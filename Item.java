public abstract class Item extends Entidade {
    private final String nome;
    private final int valor;
    private final Raridade raridade;

    protected Item(String nome, int valor, Raridade raridade) {
        this.nome = nome;
        this.raridade = (raridade != null) ? raridade : Raridade.COMUM;
        if (valor < this.raridade.getValorMinimo()) {
            this.valor = this.raridade.getValorMinimo();
        } else {
            this.valor = valor;
        }
    }

    protected Item(String nome, int valor) {
        this(nome, valor, Raridade.COMUM);
    }

    public String getNome() {
        return nome;
    }

    public int getValor() {
        return valor;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public abstract String usar(Personagem personagem);

    public abstract String descricao();

    public String getTipo() {
        return this.getClass().getSimpleName();
    }
}