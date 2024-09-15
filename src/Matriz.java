import java.util.Random;

public class Matriz {
    private static int[][] matriz;
    private static int linhas;
    private static int colunas;

    //criação da matriz
    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.matriz = new int[linhas][colunas];
    }

    //metodo para preencher aleatoriamente
    public void preencherAleatorio(int limite) {
        Random random = new Random();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = random.nextInt(limite); // valores aleatórios até o limite especificado
            }
        }
    }

    //inserir um elemento na matriz
    public static void inserirElemento(int linha, int coluna, int valor) {
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            matriz[linha][coluna] = valor;
            System.out.println("A matriz é:" + valor);
        } else {
            System.out.println("Posição inválida.");
        }
    }

    //metodo para remover elemento
    public void removerElemento(int linha, int coluna) {
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            matriz[linha][coluna] = 0; // Define como 0 para indicar remoção
            System.out.println("removido");
        } else {
            System.out.println("Posição inválida.");
        }
    }

    //metodo para exibir a matriz
    public void exibirMatriz() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    //metodo bubbleSort
    private void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // ordenação por linhas
    public void ordenarPorLinhas() {
        for (int i = 0; i < linhas; i++) {
            bubbleSort(matriz[i]);
        }
    }

    // ordenação com o metodo Merge
    public void ordenarPorLinhasMerge() {
        for (int i = 0; i < linhas; i++) {
            mergeSort(matriz[i], 0, matriz[i].length - 1);
        }
    }

    // ordenação por colunas
    public void ordenarPorColunas() {
        for (int j = 0; j < colunas; j++) {
            int[] coluna = new int[linhas];
            for (int i = 0; i < linhas; i++) {
                coluna[i] = matriz[i][j];
            }
            bubbleSort(coluna);
            for (int i = 0; i < linhas; i++) {
                matriz[i][j] = coluna[i];
            }
        }
    }

    //ordenação de coluna com merge
    public void ordenarPorColunasMerge() {
        for (int j = 0; j < colunas; j++) {
            int[] coluna = new int[linhas];
            for (int i = 0; i < linhas; i++) {
                coluna[i] = matriz[i][j];
            }
            mergeSort(coluna, 0, coluna.length - 1);
            for (int i = 0; i < linhas; i++) {
                matriz[i][j] = coluna[i];
            }
        }
    }

    // implementação do Merge Sort
    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    // ordenar a matriz completa, achatar e reordenar
    public void ordenarMatrizCompleta() {
        int[] vetor = new int[linhas * colunas];
        int index = 0;
        // Acha a matriz
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                vetor[index++] = matriz[i][j];
            }
        }

        // ordena o vetor
        mergeSort(vetor, 0, vetor.length - 1);

        // reconstrói a matriz
        index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = vetor[index++];
            }
        }
    }






    //implementação do merge
    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}


