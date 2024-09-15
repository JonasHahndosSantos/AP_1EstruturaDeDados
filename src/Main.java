import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //matriz é gerada uma unica vez
         Matriz matriz = new Matriz(5,5); // Cria a matriz com dimensões fixas

         matriz.preencherAleatorio(10); // Preenche a matriz com valores aleatórios até 10
        
        while(true) {

            int opcao = 0;

            int linha = 0;

            int coluna = 0;

            int valor = 0;

            int escolha = 0;

            Scanner scanner = new Scanner(System.in);

            System.out.println("\nMENU");
            System.out.println(("Digite 1 para exibir"));
            System.out.println(("Digite 2 para inserir um novo elemento"));
            System.out.println(("Digite 3 para para excluir um elemento"));
            System.out.println(("Digite 4 para ordenar por linha"));
            System.out.println(("Digite 5 para ordenar por coluna"));
            System.out.println(("Digite 6 para ordenar matriz completa"));
            System.out.println(("Digite 0 para sair \n"));
            System.out.println("O que deseja fazer? \n");

            opcao = scanner.nextInt();

            //usuario sai do loop
            if(opcao == 0){

                System.out.println("Encerrando...");
                break;

            }

            switch (opcao){

                case 1: //usuario exibe a matriz

                    System.out.println("A sua matriz é: \n");
                    matriz.exibirMatriz();
                    break;

                case 2: //usuario consegue inserir os elementos na matriz

                    System.out.println("digite o numero da linha");
                    linha = scanner.nextInt();
                    System.out.println("digite o numero da coluna");
                    coluna = scanner.nextInt();
                    System.out.println("digite o numero do valor");
                    valor = scanner.nextInt();
                    matriz.inserirElemento(linha, coluna, valor);
                    System.out.println("Matriz após inserção: \n");
                    matriz.exibirMatriz();
                    break;

                case 3: //usuario exclui um elemento da matriz

                    System.out.println("digite o numero da linha: ");
                    linha = scanner.nextInt();
                    System.out.println("digite o numero da coluna:");
                    coluna = scanner.nextInt();
                    matriz.removerElemento(linha, coluna);
                    System.out.println("Matriz após excluir: \n");
                    matriz.exibirMatriz();
                    break;

                case 4: //usuario ordena por linha
                    System.out.println("digite 1 para blubesort \n digete 2 para merge:");
                    escolha = scanner.nextInt();
                    if(escolha == 1) {
                        System.out.println("A sua matriz antes da ordenação por linha é: \n");
                        matriz.exibirMatriz();
                        matriz.ordenarPorLinhas();
                        System.out.println("\nA sua matriz após a ordenação por linha é: \n");
                        matriz.exibirMatriz();
                        break;
                    }if(escolha == 2) {
                    System.out.println("A sua matriz antes da ordenação por linha é: \n");
                    matriz.exibirMatriz();
                    matriz.ordenarPorLinhasMerge();
                    System.out.println("\nA sua matriz após a ordenação por linha é: \n");
                    matriz.exibirMatriz();
                    break;
                }else{System.out.println("numero invalido\n");
                        break;
                    }
                case 5: //usuario ordena por coluna
                    System.out.println("digite 1 para blubesort \n digete 2 para merge:");
                    escolha = scanner.nextInt();
                    if(escolha == 1) {
                    System.out.println("A sua matriz antes da ordenação por coluna é: \n");
                    matriz.exibirMatriz();
                    matriz.ordenarPorColunas();
                    System.out.println("\nA sua matriz após a ordenação por coluna é: \n");
                    matriz.exibirMatriz();
                    break;
                    }else if(escolha == 2){
                        System.out.println("A sua matriz antes da ordenação por coluna é: \n");
                        matriz.exibirMatriz();
                        matriz.ordenarPorColunasMerge();
                        System.out.println("\nA sua matriz após a ordenação por coluna é: \n");
                        matriz.exibirMatriz();  
                    }else{System.out.println("numero invalido\n");
                        break;
                    }

                case 6: //usuario ordena a matriz completa
                    System.out.println("A sua matriz antes da ordenação completa é: \n");
                    matriz.exibirMatriz();
                    matriz.ordenarMatrizCompleta();
                    System.out.println("\nA sua matriz após a ordenação completa é: \n");
                    matriz.exibirMatriz();
                    break;
            }
        }
    }
}
















