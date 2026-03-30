import java.util.Comparator;

public class Torre<T> {
    private Pilha<T> torre;
    private Comparator<T> comparator;

    public Torre(Comparator<T> comparator) {
        this.torre = new Pilha<>();
        this.comparator = comparator;
    }

    // Regra do jogo: só entra se for menor que o topo
    public void push(T elemento) throws Exception {
        if (torre.isEmpty() || comparator.compare(elemento, torre.topo()) < 0) {
            torre.push(elemento);
        } else {
            throw new Exception("Movimento Proibido: Disco maior sobre disco menor!");
        }
    }

    // Usado apenas para criar o jogo no início
    public void setupPush(T elemento) throws Exception {
        torre.push(elemento);
    }

    public T pop() throws Exception { 
        return torre.pop(); 
    }
    
    public boolean isEmpty() { 
        return torre.isEmpty(); 
    }
    
    public int sizeElements() { 
        return torre.sizeElements(); 
    }
    
    public T topo() throws Exception { 
        return torre.topo(); 
    }
}