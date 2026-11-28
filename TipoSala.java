import java.util.Random;

public enum TipoSala {
	COMBATE("Sala de combate"),
	CHEFE("Sala do chefe"),
	LOJA("Mercador errante"),
	DESCANSO("Fogueira de descanso"),
	TESOURO("Câmara do tesouro"),
	MISTERIOSA("Sala misteriosa");

	private final String descricao;
	private static final Random RANDOM = new Random();

	TipoSala(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public TipoSala revelarsALA() {
		if (this != MISTERIOSA) {
			return this;
		}

		int n = RANDOM.nextInt(100);

		if (n < 60) { // 60%
			return COMBATE;
		} else if (n < 75) { // 75 - 60 = 15%
			return TESOURO;
		} else if (n < 90) { // 90 - 75 = 15%
			return DESCANSO;
		} else {
			return LOJA; // 100 - 90 = 10%
		}
	}
}