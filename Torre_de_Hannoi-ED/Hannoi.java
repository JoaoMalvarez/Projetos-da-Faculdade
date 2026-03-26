import java.util.Comparator;
import java.util.Scanner;
public class Hannoi {
    public static void main(String[] args) throws Exception {
        System.out.println("Torre de Hannoi");
        System.out.print("Digite o número de discos: ");
        Scanner scanner = new Scanner(System.in);
        int numDiscos = scanner.nextInt();
        Torre<Disco> torre1 = new Torre<>(Comparator.comparingInt(Disco::getTamanho));
        Torre<Disco> torre2 = new Torre<>(Comparator.comparingInt(Disco::getTamanho));  
        Torre<Disco> torre3 = new Torre<>(Comparator.comparingInt(Disco::getTamanho));
        Print<Disco> print = new dequePrint<>();
        Reserva<Disco> reserva = new dequePrint<>();
        //adicionar os discos na torre 1
        for (int i = numDiscos; i >= 1; i--) {
            torre1.push (new Disco("*".repeat(i), i), numDiscos); // a forma vai sair *, **, ***...
        } 



        //imprimir os discos
        for (int i = numDiscos; i >= 1; i--) {
            //coloca os valores nas torres do deque
            print.enqueueLeft(torre3.pop());
            reserva.enqueueRight(print.getLeft());
            print.enqueueLeft(torre2.pop());
            reserva.enqueueRight(print.getLeft());
            print.enqueueLeft(torre1.pop());
            reserva.enqueueRight(print.getLeft());
        }
        for (int i = numDiscos; i > 0; i--) {
            //imprime os valores nas torres
            System.out.print(print.dequeueLeft());
            System.out.print("  " .repeat(i));
            System.out.print(print.dequeueLeft());
            System.out.print("  " .repeat(i));
            System.out.println(print.dequeueLeft());

            if (i == 1) {
                System.out.print("Torre 1:");
                System.out.print("  ".repeat(numDiscos - 7));
                System.out.print("Torre 2:");
                System.out.print("  ".repeat(numDiscos - 7));
                System.out.print("Torre 3:");
                System.out.print("  ".repeat(numDiscos - 7));
            }
        }
        for (int i = numDiscos; i > 0; i--) {
            //reepopulando as torres
            torre1.push(reserva.dequeueRight());
            torre2.push(reserva.dequeueRight());
            torre3.push(reserva.dequeueRight());
        }
        
        System.out.println("Torres:");
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