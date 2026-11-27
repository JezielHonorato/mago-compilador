import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Console {
	private final Scanner scan = new Scanner(System.in, StandardCharsets.UTF_8);

	public void println(String texto) {
		System.out.println(texto);
	}

	public String lerLinha(String label) {
		System.out.print(label + " ");
		String entrada = scan.nextLine();
		if (entrada.trim().equals("")) {
			return scan.nextLine();
		}
		return entrada;
	}

	public int lerInteiro(String label) {
		System.out.print(label + " ");
		int entrada = scan.nextInt();
		return entrada;
	}
}
