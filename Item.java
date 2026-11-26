public abstract class Item {
    private int id;
    private final String nome;
    private final int valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getValor() {
        return valor;
    }

    protected Item(String nome, int valor){
        this.nome = nome;
        this.valor = valor;
    }

    public abstract String usar(Personagem personagem);

    public abstract String descricao();

    public String getTipo(){
        return this.getClass().getSimpleName();
    }
}
