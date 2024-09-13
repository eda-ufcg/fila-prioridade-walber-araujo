public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;
	private int size;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
		this.size = 0;
	}
	
	private boolean isEmpty() {
		return this.size == 0;
	}
	
	private void resize() {
		Pair[] novaFila = new Pair[this.fila.length*2];
		
		for (int i = 0; i < this.fila.length; i++) {
			novaFila[i] = this.fila[i];
		}
		this.fila = novaFila;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		if (isEmpty()) {
			this.fila[0] = new Pair(elemento, prioridade);
			this.head = 0;
			this.last = 0;
			this.size++;
			return;
		}
		int i = 0;
		
		while(i < this.size && this.fila[i].getPrioridade() > prioridade) {
			i++;
		}
		
		shift(i);
		this.fila[i] = new Pair(elemento, prioridade);
		this.last = ++this.last % this.fila.length;
		this.size++;		
	}
	
	private void shift(int i) {
		for (int j = this.size-1; j >= i; j--) {
			this.fila[j+1] = this.fila[j];
		}
	}


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		Pair toRemove = this.fila[this.head];
		this.head = ++this.head % this.fila.length;
		this.size--;
		return toRemove.getElemento();
	}

}
