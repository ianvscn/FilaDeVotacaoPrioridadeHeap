import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int tamFila = 5;
        //Traz a fila criada para ordenar no main
        int[][] fila = new CriaFila().geraFila();

        System.out.print("Fila desordenada: ");
        for(int i = 0; i<tamFila; i++){
            System.out.print(fila[i][0]+" ");
            System.out.print(fila[i][1]+" / ");
        }

        System.out.println();

        int[] vetor = new int[tamFila];

        for(int i=0; i<tamFila; i++){
            vetor[i] = fila[i][1];
        }

        System.out.println("Desordenado");
        for(int i = 0; i < vetor.length; i++){
            System.out.print(vetor[i] + " ");
            
        }

        int n = vetor.length;

        for(int i = n / 2 - 1; i >= 0; i--){
            aplicarHeap(vetor, n, i);
        }

        System.out.println("\n\nQuase ordenado");
        for(int i = 0; i < vetor.length; i++){
            System.out.print(vetor[i] + " ");
        }

        for(int j = n-1; j > 0; j--){
            int aux = vetor[0];
            vetor[0] = vetor[j];
            vetor[j] = aux;

            aplicarHeap(vetor, j, 0);
        }

        System.out.println("\n\nOrdenado");
        for(int i = 0; i < vetor.length; i++){
            System.out.print(vetor[i] + " ");
        }

        //Pedindo votos na ordem da fila
        System.out.println();
        System.out.println("-----------");

        Scanner ler = new Scanner(System.in);

        int candA = 0;
        int candB = 0;
        int nulo = 0;

        int[] votos = new int[vetor.length];
        System.out.println();
        
        for(int i=0;i<vetor.length;i++){
            int p = 0;
            while(vetor[i]!=fila[p][1]){
                p++;
            }
            System.out.println(fila[p][0]+", insira seu voto (1 para A ou 2 para B): ");
            votos[i] = ler.nextInt();
            if(votos[i]==1){
                candA++;
            }if(votos[i]==2){
                candB++;
            }if(votos[i]!=2 && votos[i]!=1){
                nulo++;
            }
        }

        System.out.println();
        System.out.println("-----------");
        System.out.println("Quantidade de votos anulados: "+nulo);
        
        //Resultado dos votos
        if(candA>candB){
            System.out.println("A venceu!");
        }if(candB>candA){
            System.out.println("B venceu!");
        }if(candB==candA){
            System.out.println("Empate!");
        }

    }

    private static void aplicarHeap(int[] vetor, int n, int i){
        int raiz = i;
        int esquerda = 2*i + 1;
        int direita = 2*i + 2;

        if (esquerda < n && vetor[esquerda] < vetor[raiz]){
            raiz = esquerda;
        }
        if (direita < n && vetor[direita] < vetor[raiz]){
            raiz = direita;
        }

        if (raiz != i){
            int aux = vetor[i];
            vetor[i] = vetor[raiz];
            vetor[raiz] = aux;

            aplicarHeap(vetor, n, raiz);
        }
    }
}