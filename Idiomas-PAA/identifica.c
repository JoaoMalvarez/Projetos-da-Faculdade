/* A entrada é via teclado de uma frase em um dos dois idiomas.
 A saída é o idioma da frase de entrada.
 Comente e idente seu programa.
*/

// Carol 
// Catarina Silva e Meirelles 
//João Pedro Mazzante Alvarez

//código que pulei e fui pro main só pra não dar erro, mas depois volto e faço o código

int main () {
    printf("Digite uma frase(em inglês, português ou esperanto): ");
    char frase[100];
    scanf("%[^\n]", frase); // Lê a frase até a quebra de linha

    //aqui vamos voltar pra fazer o codigo

    printf("Frase: %s\n", frase);
    printf("O idioma da frase é: ...\n"); // Aqui deve ser a lógica para identificar o idioma
    return 0;
}