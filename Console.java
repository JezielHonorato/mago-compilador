import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Console {
	private final Scanner scan = new Scanner(System.in, StandardCharsets.UTF_8);

	public void println(String texto) {
		System.out.println(texto);
	}

	public void printTitulo() {
		this.println("");
		this.println("!====! RPG - Mago Compilador !====!");
	}

	public void printTitulo(String usuario) {
		System.out.println("");
		this.println("!====! RPG - Mago Compilador (" + usuario + ") !====!");
	}

	public String lerLinha(String label) {
		System.out.print(label + " ");
		String entrada = scan.nextLine();
		while (entrada.trim().isEmpty()) {
			entrada = scan.nextLine();
		}
		return entrada;
	}

	public int lerInteiro(String label) {
		while (true) {
			System.out.print(label + " ");
			String linha = scan.nextLine().trim();
			try {
				return Integer.parseInt(linha);
			} catch (NumberFormatException e) {
				this.println("Digite um número inteiro válido!");
			}
		}
	}

	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public int lerRangeInteiro(String label, int min, int max) {
		int n = this.lerInteiro(label);
		if (n < min || n > max) {
			this.println("\nEscolha uma opção válida!");
			this.sleep(1000);
			this.println("");
		}
		return n;
	}
}