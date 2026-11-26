import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventario {
    public int capacidade = 8;
    private final List<Item> itens = new ArrayList<>();

    public String adicionarItem(Item item){
        if(itens.size() >= capacidade){
            //exception
        }
        itens.add(item);
        return item.getNome() + " foi adicionado ao Inventário.";
    }

    public String removerItem(Item item){
        if(itens.isEmpty()){
            //exception
        }
        String nomeItem = item.getNome();
        itens.remove(item);
        return nomeItem + " foi removido do Inventário.";
    }

    public List<Item> getItens(){
        return Collections.unmodifiableList(itens);
    }

}
