import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

public enum TipoPersonagem {
	GUERREIRO("Guerreiro", TipoArma.ESPADA, TipoArma.MACHADO),
	MAGO("Mago", TipoArma.CAJADO),
	LADINO("Ladino", TipoArma.ADAGA, TipoArma.ARCO);

	private final String nome;
	private final Set<TipoArma> tipos;

	TipoPersonagem(String nome, TipoArma... tipos) {
		this.nome = nome;
		this.tipos = EnumSet.copyOf(Arrays.asList(tipos));
	}

	public String getNome() {
		return nome;
	}

	public Set<TipoArma> getTipos() {
		return tipos;
	}

	public boolean aceitarArma(TipoArma tipo) {
		return tipos.contains(tipo);
	}
}
