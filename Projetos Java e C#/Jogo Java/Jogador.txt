package classes;
// Classe abstrata
public abstract class Jogador {
    protected int qntdEmpresa, pontosAmbientais, posicao;
    protected String cor, profissao;
    protected int dinheiro;
    protected boolean endividado, preso;
    public Jogador(String cor) {
        this.cor = cor;
        posicao = 1;
        dinheiro = 20;
        qntdEmpresa = 0;
        pontosAmbientais = 0;
        endividado = false;
        preso = false;
    }
    // o método avancar(x) serve para modificar sua posição, porém se estiver preso você não anda.
    // não usamos no jogo final (ser preso), mas num futuro próximo talvez seja implementado
    public void avancar(int qntdDeCasas) {
        if (!preso) {
            if (!endividado) {
                posicao += qntdDeCasas;
            } else {
               posicao += qntdDeCasas - 2;  // Caso a pessoa esteja endividada irá andar menos casas.
            }
        }
    }
    // comentado pois, mesmo existindo a classe Empresa, ela não foi implementada no jogo.
    /*public void venderEmpresa(Empresa nomeEmpresa) {
    qntdEmpresa -= 1;
    nomeEmpresa.setPropietario("Nenhum");
    }
    public void comprarEmpresa(Empresa nomeEmpresa) {
    qntdEmpresa += 1;
    nomeEmpresa.setPropietario(getCor());
    }
    public void pagarFianca() {
    if (dinheiro >= 30 && preso) {
    dinheiro -= 30;
    preso = false;
    }
    }*/
    // método para ganhar ou perder dinheiro
    public void receber(int valor) {
        dinheiro += valor;
    }
    // método para ganhar ou perder´pontos ambientais
    public void ganharPontos(int valor) {
        pontosAmbientais += valor;
    }
    // método finalizar() é o disparador quando termina o turno do jogador
    // cada profissão ganha ou perde algo quando finaliza um turno (ver nas regras)
    abstract public void finalizar();
    public int getDinheiro() {
        return dinheiro;
    }
    public int getPontosAmbientais() {
        return pontosAmbientais;
    }
    public int getQntdEmpresa() {
        return qntdEmpresa;
    }
    public String getCor() {
        return cor;
    }
    public void setEndividado(boolean endividado) {
        this.endividado = endividado;
    }
    public String getProfissao() {
        return profissao;
    }
    public int getPosicao() {
       return posicao;
    }
}
