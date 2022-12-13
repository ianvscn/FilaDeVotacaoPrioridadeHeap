import java.util.Random;

public class Prioridade{

    public int prioridade(){
        Random gerador = new Random();
        return gerador.nextInt(2);
    }

}
