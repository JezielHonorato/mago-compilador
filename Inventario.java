import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventario {
    public int capacidade = 8;
    private final List<Item> itens = new ArrayList<>();

    public String adicionarItem(Item item) {
        if (itens.size() >= capacidade) {
            return "Inventário cheio! Não foi possível adicionar " + item.getNome() + ".";
        }
        itens.add(item);
        return item.getNome() + " [" + item.getRaridade() + "] foi adicionado ao Inventário.";
    }

    public String removerItem(Item item) {
        if (itens.isEmpty()) {
            return "O Inventário está vazio.";
        }
        String nomeItem = item.getNome();
        itens.remove(item);
        return nomeItem + " foi removido do Inventário.";
    }

    public boolean contem(Item item) {
        return itens.contains(item);
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }
}