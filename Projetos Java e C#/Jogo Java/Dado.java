package classes;
import java.util.Random;
// Classe dado para gerar números aleatórios com um método construtor para saber o número máximo do dado
public class Dado {
    private Random gerador;
    private int lados, valorAtual;
    public Dado(int lados){
        this.lados = lados;
        gerador = new Random();
    }
    public Dado(){
        this.lados = 6;
        gerador = new Random();
    }
    public void rolar(){
        valorAtual = gerador.nextInt(lados)+1;
    }
    public int getValorAtual(){
        return valorAtual;
    }
    public void setValorAtual(int x){
       valorAtual = x;
    }
}