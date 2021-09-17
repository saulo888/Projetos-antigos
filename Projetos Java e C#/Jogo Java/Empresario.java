package classes;
// Herda Jogador
public class Desempregado extends Jogador {
    public Desempregado(String cor) {
        super(cor);
        super.profissao = "Desempregado";
   } 
    @Override
    public void finalizar(){
       avancar(1); // anda uma posição sempre no final do turno
    }
}
