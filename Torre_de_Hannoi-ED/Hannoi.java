import java.util.Comparator;
import java.util.Scanner;

public class Hannoi {
    private static Torre<Disco> t1, t2, t3;
    private static int numDiscos;
    private static Comparator<Disco> comp = Comparator.comparingInt(Disco::getTamanho);

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TORRE DE HANNOI ===");
        System.out.print("Digite o número de discos: ");
        numDiscos = scanner.nextInt();

        inicializarJogo();

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Mover o Disco");
            System.out.println("2 - Mostrar Torres");
            System.out.println("3 - Reiniciar o Jogo");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");
            
            int resposta = scanner.nextInt();

            switch (resposta) {
                case 1:
                    try {
                        System.out.print("Origem (1, 2, 3): ");
                        int orig = scanner.nextInt();
                        System.out.print("Destino (1, 2, 3): ");
                        int dest = scanner.nextInt();
                        executarMovimento(orig, dest);
                        System.out.println("Movido!");
                        verificarVitoria();
                    } catch (Exception e) {
                        System.out.println("ERRO: " + e.getMessage());
                    }
                    break;
                case 2:
                    exibirVisualizacao();
                    break;
                case 3:
                    inicializarJogo();
                    System.out.println("Jogo Reiniciado!");
                    break;
                case 4:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private static void inicializarJogo() throws Exception {
        t1 = new Torre<>(comp);
        t2 = new Torre<>(comp);
        t3 = new Torre<>(comp);
        // O maior (numDiscos) entra primeiro para ficar no fundo
        for (int i = numDiscos; i >= 1; i--) {
            t1.setupPush(new Disco("*".repeat(i * 2), i));
        }
    }

    private static void executarMovimento(int de, int para) throws Exception {
        Torre<Disco> origem = selecionar(de);
        Torre<Disco> destino = selecionar(para);
        if (origem.isEmpty()) throw new Exception("Torre vazia!");
        Disco d = origem.pop();
        try { destino.push(d); } catch (Exception e) { 
            origem.setupPush(d); throw e; 
        }
    }

    private static Torre<Disco> selecionar(int n) {
        return (n == 1) ? t1 : (n == 2) ? t2 : t3;
    }

    private static void exibirVisualizacao() throws Exception {
        System.out.println("\n--- TORRES ---");
        // Criar cópias para não destruir as originais
        Pilha<Disco> p1 = copiar(t1);
        Pilha<Disco> p2 = copiar(t2);
        Pilha<Disco> p3 = copiar(t3);

        for (int i = 0; i < numDiscos; i++) {
            desenharNivel(p1, i);
            desenharNivel(p2, i);
            desenharNivel(p3, i);
            System.out.println();
        }
        System.out.println("=".repeat(numDiscos * 8));
        System.out.println("Torre 1 " + " ".repeat(numDiscos) + "Torre 2 " + " ".repeat(numDiscos) + "Torre 3");
    }

    private static Pilha<Disco> copiar(Torre<Disco> t) throws Exception {
        Pilha<Disco> clone = new Pilha<>(numDiscos);
        Pilha<Disco> aux = new Pilha<>(numDiscos);
        while (!t.isEmpty()) aux.push(t.pop());
        while (!aux.isEmpty()) {
            Disco d = aux.pop();
            t.setupPush(d);
            clone.push(d);
        }
        return clone;
    }

    private static void desenharNivel(Pilha<Disco> p, int linha) throws Exception {
        int espacosVazios = numDiscos - p.sizeElements();
        if (linha < espacosVazios) {
            System.out.print(" ".repeat(numDiscos) + "|" + " ".repeat(numDiscos) + " ");
        } else {
            // Desempilha até chegar no disco desta linha
            Pilha<Disco> extra = new Pilha<>(numDiscos);
            while (p.sizeElements() > (numDiscos - linha)) extra.push(p.pop());
            Disco d = p.topo();
            int margem = (numDiscos * 2 - d.getForma().length()) / 2;
            System.out.print(" ".repeat(margem) + "[" + d.getForma() + "]" + " ".repeat(margem) + " ");
            while (!extra.isEmpty()) p.push(extra.pop());
        }
    }

    private static void verificarVitoria() {
        if (t1.isEmpty() && t2.isEmpty() && t3.sizeElements() == numDiscos) {
            System.out.println("\n*** PARABÉNS! VOCÊ VENCEU! ***");
        }
    }
}