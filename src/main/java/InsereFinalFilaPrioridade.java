import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair pair = new Pair(elemento, prioridade);
		this.fila.add(pair);
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		if (this.fila.isEmpty()) return null;
		
		Pair maxPriority = this.fila.get(0);
		for (Pair p : this.fila) {
			if (p.getPrioridade() > maxPriority.getPrioridade()) {
				maxPriority = p;
			}
		}
		
		this.fila.remove(maxPriority);
		return maxPriority.getElemento();
	}

}
