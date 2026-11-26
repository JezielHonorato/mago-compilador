public enum Raridade {
    COMUM("Comum", 4, 5),
    RARO("Raro", 35, 15),
    EPICO("Épico", 100, 25),
    LENDARIO("Lendário", 325, 40);

    private final String nome;
    private final int valorMinimo;
    private final int poderMaximo;

    Raridade(String nome, int valorMinimo, int poderMaximo) {
        this.nome = nome;
        this.valorMinimo = valorMinimo;
        this.poderMaximo = poderMaximo;
    }

    public String getNome() {
        return nome;
    }

    public int getValorMinimo() {
        return valorMinimo;
    }

    public int getPoderMaximo() {
        return poderMaximo;
    }

    public static Raridade determinarPorPoder(int poder) {
        if (poder <= COMUM.poderMaximo) {
            return COMUM;
        } else if (poder <= RARO.poderMaximo) {
            return RARO;
        } else if (poder <= EPICO.poderMaximo) {
            return EPICO;
        } else {
            return LENDARIO;
        }
    }

    @Override
    public String toString() {
        return nome;
    }
}