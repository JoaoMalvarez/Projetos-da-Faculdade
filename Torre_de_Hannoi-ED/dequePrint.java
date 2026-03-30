public class dequePrint<T> {
    private static final int TAM_DEQUE = 100;
    private int inicio, fim, qtde, tamanho;
    private T e[];

    @SuppressWarnings("unchecked")
    public dequePrint(int tamanho) {
        this.inicio = 0; this.fim = 0; this.qtde = 0;
        this.tamanho = tamanho;
        this.e = (T[]) new Object[tamanho];
    }

    public dequePrint() {
		this(TAM_DEQUE); 
	}
    
	public boolean qisEmpty() {
		return qtde == 0; 
	}
    
	public boolean qisFull() {
		return qtde == this.tamanho; 
	}

    public void enqueueLeft(T item) throws Exception {
        if (qisFull()) throw new Exception("Full");
        inicio = (inicio - 1 + tamanho) % tamanho;
        e[inicio] = item;
        qtde++;
    }

    public T dequeueLeft() throws Exception {
        if (qisEmpty()) throw new Exception("Empty");
        T aux = e[inicio];
        inicio = (inicio + 1) % tamanho;
        qtde--;
        return aux;
    }
}