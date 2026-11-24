
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Arquivo<T extends Entidade> {
	private final Path arquivo;
	private final String nomeEntidade;
	private final Map<Integer, T> dados = new LinkedHashMap<>();
	private boolean arquivoCarregado;

	protected Arquivo(Path arquivo, String nomeEntidade) {
		this.arquivo = arquivo;
		this.nomeEntidade = nomeEntidade;
	}

	protected abstract String serializar(T entidade);

	protected abstract T desserializar(String[] campos);

	/** Chave de unicidade (nome/login) ou null se não houver. */
	protected String chaveUnica(T entidade) {
		return null;
	}

	public void carregarArquivo() {
		dados.clear();
		if (!Files.exists(arquivo))
			return;
		try {
			for (String linha : Files.readAllLines(arquivo, StandardCharsets.UTF_8)) {
				if (linha.isBlank())
					continue;
				T atributos = desserializar(linha.split("\\|", -1));
				dados.put(atributos.getId(), atributos);
			}
		} catch (IOException ex) {
			System.getLogger(Arquivo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
		} finally {
			arquivoCarregado = true;
		}
	}

	public T adicionar(T entidade) {
		carregarSeNecessario();
		validarUnicidade(entidade);
		int proximo = dados.keySet().stream().mapToInt(Integer::intValue).max().orElse(0) + 1;
		entidade.setId(proximo);
		dados.put(proximo, entidade);
		persistir();
		return entidade;
	}

	public void atualizar(T entidade) {
		carregarSeNecessario();
		buscar(entidade.getId());
		validarUnicidade(entidade);
		dados.put(entidade.getId(), entidade);
		persistir();
	}

	public void remover(int id) {
		carregarSeNecessario();
		buscar(id);
		dados.remove(id);
		persistir();
	}

	public T buscar(int id) {
		carregarSeNecessario();
		T elemento = dados.get(id);
		return elemento;
	}

	public List<T> listar() {
		carregarSeNecessario();
		return new ArrayList<>(dados.values());
	}

	private void carregarSeNecessario() {
		if (!arquivoCarregado)
			carregarArquivo();
	}

	private void validarUnicidade(T chave) {
		System.out.println(chave + "é unica");
	}

	private void persistir() {
		List<String> linhas = new ArrayList<>();
		for (T e : dados.values())
			linhas.add(serializar(e));
		Path tmp = arquivo.resolveSibling(arquivo.getFileName() + ".tmp");
		try {
			if (arquivo.getParent() != null)
				Files.createDirectories(arquivo.getParent());
			Files.write(tmp, linhas, StandardCharsets.UTF_8);
			try {
				Files.move(tmp, arquivo, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
			} catch (AtomicMoveNotSupportedException e) {
				Files.move(tmp, arquivo, StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException ex) {
			System.getLogger(Arquivo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
		}
	}
}
