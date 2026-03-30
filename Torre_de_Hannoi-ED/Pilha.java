public class Pilha<T> {
    private static final int TAM = 100;
    private int topoPilha;
    private T elementos[];

    @SuppressWarnings("unchecked")
    public Pilha(int tamanho) {
        this.elementos = (T[]) new Object[tamanho];
        this.topoPilha = -1;
    }

    public Pilha() { 
        this(TAM); 
    }

    public boolean isEmpty() { 
        return this.topoPilha == -1;
    }

    public boolean isFull() { 
        return this.topoPilha == elementos.length - 1; 
    }

    public void push(T e) throws Exception {
        if (!this.isFull()) {
            elementos[++topoPilha] = e;
        } else throw new Exception("Pilha cheia");
    }

    public T pop() throws Exception {
        if (!this.isEmpty()) return elementos[topoPilha--];
        else throw new Exception("Pilha vazia");
    }

    public T topo() throws Exception {
        if (!this.isEmpty()) return elementos[topoPilha];
        else throw new Exception("Pilha vazia");
    }

    public int sizeElements() { return topoPilha + 1; }
}