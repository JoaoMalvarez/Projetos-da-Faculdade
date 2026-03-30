public class Disco {
    private String forma;
    private int tamanho;

    public Disco(String forma, int tamanho) {
        this.forma = forma;
        this.tamanho = tamanho;
    }

    public String getForma() { 
        return forma; 
    }
    public int getTamanho() { 
        return tamanho; 
    }

    @Override
    public String toString() {
        return forma; // Retorna apenas o desenho do disco para a impressão
    }
}