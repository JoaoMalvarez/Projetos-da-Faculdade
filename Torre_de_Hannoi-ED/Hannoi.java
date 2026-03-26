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
        //adicionar os discos na torre 1
        for (int i = numDiscos; i >= 1; i--) {
            torre1.push (new Disco("*".repeat(i), i), numDiscos); // a forma vai sair *, **, ***...
        } 
        scanner.close();


        //imprimir os discos
        for (int i = numDiscos; i >= 1; i--) {
            //coloca os valores nas torres do deque
            print.enqueueLeft(torre3.pop());
            print.enqueueLeft(torre2.pop());
            print.enqueueLeft(torre1.pop());
        }
        for (int i = numDiscos; i > 0; i--) {
            //imprime os valores nas torres
            torre1.push(print.getLeft());
            System.out.print(print.dequeueLeft());
            System.out.print("  " .repeat(i));
            torre2.push(print.getLeft());
            System.out.print(print.dequeueLeft());
            System.out.print("  " .repeat(i));
            torre3.push(print.getLeft());
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
        //Menu
        System.out.println("Menu");
        System.out.println("1 - Mover o Disco/n2 - Mostrar Torres/n3 - Reiniciar o Jogo/n4 - Sair");
        Scanner menu = new Scanner(System.in);
        int resposta = menu.nextInt();
        //código do menu
       

    }
}