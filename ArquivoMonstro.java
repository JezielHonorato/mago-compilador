
import java.nio.file.Path;

public class ArquivoMonstro extends Arquivo<Monstro>{
    public ArquivoMonstro(Path pasta) {
		super(pasta.resolve("monstros.txt"), "monstro");
	}

    @Override
	protected String serializar(Monstro m) {
		return String.join("|", m.getNome(), String.valueOf(m.getId()), String.valueOf(m.getAtaque()),
				String.valueOf(m.getDefesa()), String.valueOf(m.getVidaMaxima()), String.valueOf(m.getVida()));
	}

	@Override 
	protected Monstro desserializar(String[] c) {
		String nome = c[0];
		int id = Integer.parseInt(c[1]);
		int ataque = Integer.parseInt(c[2]);
		int defesa = Integer.parseInt(c[3]);
		int vidaMaxima = Integer.parseInt(c[4]);
		int vida = Integer.parseInt(c[5]);

		return new Monstro(id, ataque, defesa, nome, vida, vidaMaxima);
	}
}
