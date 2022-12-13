import java.util.Random;

public class RandomIdade {

    public int geraIdade(){
        Random gerador = new Random();

        int aux = new Prioridade().prioridade();

        //considerando apenas voto obrigatório (18-70 anos)
        if(aux>=1){
            return gerador.nextInt(52)+118;
        }else{
            return gerador.nextInt(52)+18;
        }
    }
}