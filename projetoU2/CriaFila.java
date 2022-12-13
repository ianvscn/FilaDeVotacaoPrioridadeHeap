public class CriaFila{
    public int[][] geraFila(){
        int tamFila = 5;
        int[][] fila = new int[tamFila][2];

        for(int i = 0; i<tamFila; i++){
            int cpf = new GeraCPF().geraCPF();
            int idade = new RandomIdade().geraIdade();

            fila[i][0] = cpf;
            fila[i][1] = idade;
            
        }
        return fila;
    }
}