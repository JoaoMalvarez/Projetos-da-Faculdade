import java.util.Comparator;

public class Torre<T> {
    private Pilha<T> torre;
    private Comparator<T> comparator;

    public Torre(Comparator<T> comparator) {
        this.torre = new Pilha<>();
        this.comparator = comparator;
    }

    public void push(T elemento, int numDiscos) throws Exception {
        if (torre.isEmpty() || comparator.compare(elemento, torre.topo()) < 0) {
            torre.push(elemento);
        } else {
            throw new Exception ("Movimento não permitido.");
        }
    }

    public T pop() throws Exception {
        if (torre.isEmpty()) {
            throw new Exception("Torre vazia.");
        }
        return torre.pop();
    }

    public boolean isEmpty() {
        return torre.isEmpty();
    }

    public int sizeElements() {
        return torre.sizeElements();
    }
}