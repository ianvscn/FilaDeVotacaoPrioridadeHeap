import java.util.Random;

public class GeraCPF {

    public int geraCPF(){
        Random gerador = new Random();
        return gerador.nextInt(1000000000)+999999999; 
    }
}