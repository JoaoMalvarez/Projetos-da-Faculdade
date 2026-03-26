public class Pilha <T> {
    // Atributos:
    private static final int TAM = 100;
    private int topoPilha;
    private T elementos[];
    // Construtores:

    public Pilha(int tamanho) {
        this.elementos = (T[]) new Object[tamanho];
        this.topoPilha = -1; 
    }

    public Pilha() {
        this(TAM);
    }
    // Métodos:

    public boolean isEmpty() {
        return this.topoPilha == -1;
    }

    public boolean isFull() {
        return this.topoPilha == elementos.length -1;
    }

    public void push(T e) throws Exception {
        if(!this.isFull()) {
            topoPilha++;
            this.elementos[topoPilha] = e;
        }       
        else {
            throw new Exception("Overflow: Pilha está cheia"); //talvez mude
        }
    }

    public T pop() throws Exception{
        if(!this.isEmpty()) {
            T temp = this.elementos[topoPilha];
            topoPilha--;
            return temp;
        }
        else {
            throw new Exception("Underflow: Pilha já está vazia"); //talvez mude
        }
    }

    public T topo() throws Exception {
        if (!this.isEmpty()) {
            return this.elementos[topoPilha];
        }
        else {
            throw new Exception("Underflow: A pilha está vazia");
        }
    }

    public int sizeElements() {
        return topoPilha + 1;
    }
}