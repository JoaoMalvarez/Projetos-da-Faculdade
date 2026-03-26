import java.util.Comparator;
import java.util.Scanner;
public class Hannoi {
    public static void main(String[] args) throws Exception {
        System.out.println("Torre de Hannoi");
        System.out.print("Digite o número de discos: ");
        Scanner scanner = new Scanner(System.in);
        int numDiscos = scanner.nextInt();
        //adicionar os discos na torre 1
        Comparator<Disco> comparator = Comparator.comparingInt(Disco::getTamanho);
        Torre<Disco> torre1 = new Torre<>(comparator);
        for (int i = numDiscos; i >= 1; i--) {
            torre1.push(new Disco("Disco", i), numDiscos);
        }
        //imprimir os discos da torre 1
        System.out.println("Discos na Torre 1:");
        Pilha<Disco> fila = new Pilha<>();
        while (!torre1.isEmpty()) {
            fila.push(torre1.pop());
        }   

        while (!fila.isEmpty()) {
            System.out.println(fila.pop());
        }
    scanner.close();
    }
}