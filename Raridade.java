public enum Raridade {
    Comum("Comum", 4, 5),
    Raro("Raro", 35, 15),
    Epico("Épico", 100,25 ),
    Lendario("Lendario", 325, 40);

    private final String nome;
    private final int valorMinimo;
    private final int poderMaximo;

    Raridade(String nome, int valorMinimo, int poderMaximo){
        this.nome = nome; this.valorMinimo = valorMinimo; this.poderMaximo = poderMaximo;

    }

    public String getNome() {
        return nome;
    }

    public int getPoderMaximo() {
        return poderMaximo;
    }

    public int getValorMinimo() {
        return valorMinimo;
    }
}
