import java.nio.file.Path;

public class Main {
	public void main(String[] args) {
		ArquivoUsuarios arquivoUsuarios = new ArquivoUsuarios(Path.of("data"));
		arquivoUsuarios.carregarArquivo();
		Menu menu = new Menu(arquivoUsuarios);
		menu.exibirMenu();
		
		/*ArquivoMonstro arquivoMonstro = new ArquivoMonstro(Path.of("data"));
		arquivoMonstro.carregarArquivo();
		arquivoMonstro.adicionar(new Monstro(10, 5, "Monstro Teste", 20, 20));
		*/
	}
}