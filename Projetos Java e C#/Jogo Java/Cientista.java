package classes;
// Herda Jogador
public class Cientista extends Jogador {
    public Cientista(String nome) {
        super(nome);
        super.profissao = "Cientista";
    }    
    @Override
    public void finalizar(){
        Dado gerador = new Dado(2);
        if(gerador.getValorAtual() == 0)
        ganharPontos(2); // Todo cientista ganha 2 pontos ambientais por turno ou nenhum (50% de chance)       
    }
}