import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Console {
	private final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

	public void println(String texto) {
		System.out.println(texto);
	}

	public String lerLinha(String label) {
		System.out.print(label + " ");
		scanner.nextLine();
		String entrada = scanner.nextLine();
		return entrada;
	}

	public int lerInteiro(String label) {
		System.out.print(label + " ");
		scanner.nextLine();
		int entrada = scanner.nextInt();
		return entrada;
	}
}
