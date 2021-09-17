package classes;
import java.util.ArrayList;
public class Evento {
    private String enunciado, resultadoA, resultadoB, resultadoC, respostaJogador, profissao;
    private String mensagemResultadoA, mensagemResultadoB, mensagemResultadoC;
    private int valorAmbientalA, valorAmbientalB, valorAmbientalC;
    private int valorDinheiroA, valorDinheiroB, valorDinheiroC;
    private String grave;
    private boolean exclusivo;
    private static ArrayList<Evento> eventoContagem = new ArrayList<Evento>(); 
    // O Arraylist acima serve pra guardar literalmente objetos da classe Evento para que no futuro
    // seja escolhido um desses objetos aleatoriamente
    //Construtor Evento: (Enunciado, Três resultados, Mensagem de cada resultado,
    //Valores de dinheiro e PA ganhos, se negativo então perdas, opção que é considerada)
    //grave se nenhuma então 0 e de 1 a 3 qual opção é e se for grave aumente o medidor de extinção
    // Caso seja exclusivo de uma profissao deverá colocar no primeiro parâmetro tal profissão, se não coloque "Nenhuma"
    // Exemplo jogo de nossa APS: Desempregado, Empresario e Cientista.
    public Evento(String profissao, String enunciado, String resultadoA, String resultadoB,
            String resultadoC, String mensagemResultadoA,
            String mensagemResultadoB, String mensagemResultadoC, int valorAmbientalA,
            int valorAmbientalB, int valorAmbientalC, int valorDinheiroA,
            int valorDinheiroB, int valorDinheiroC, String grave) {
        this.profissao = profissao;
        exclusivo = true;
        this.enunciado = enunciado;
        this.resultadoA = resultadoA;
        this.resultadoB = resultadoB;
        this.resultadoC = resultadoC;
        this.mensagemResultadoA = mensagemResultadoA;
        this.mensagemResultadoB = mensagemResultadoB;
        this.mensagemResultadoC = mensagemResultadoC;
        this.valorAmbientalA = valorAmbientalA;
        this.valorAmbientalB = valorAmbientalB;
        this.valorAmbientalC = valorAmbientalC;
        this.valorDinheiroA = valorDinheiroA;
        this.valorDinheiroB = valorDinheiroB;
        this.valorDinheiroC = valorDinheiroC;
        switch (grave) {
            case "1":
                this.grave = this.mensagemResultadoA;
                break;
            case "2":
                this.grave = this.mensagemResultadoB;
                break;
            case "3":
                this.grave = this.mensagemResultadoC;
                break;
            default:
                grave = "0";
        }
        eventoContagem.add(this);
    }
    public String getEnunciado() {
        return enunciado;
    }
    public String getResultadoA() {
        return resultadoA;
    }
    public String getResultadoB() {
        return resultadoB;
    }
    public String getResultadoC() {
        return resultadoC;
    }
    public String getRespostaJogador() {
        return respostaJogador;
    }
    public void setRespostaJogador(String respostaJogador) {
        this.respostaJogador = respostaJogador;
    }
    public int getValorAmbientalA() {
        return valorAmbientalA;
    }
    public int getValorAmbientalB() {
        return valorAmbientalB;
    }
    public int getValorAmbientalC() {
        return valorAmbientalC;
    }
    public int getValorDinheiroA() {
        return valorDinheiroA;
    }
    public int getValorDinheiroB() {
        return valorDinheiroB;
    }
    public int getValorDinheiroC() {
        return valorDinheiroC;
    }
    public String getProfissao() {
        return profissao;
    }
    public boolean isExclusivo() {
        return exclusivo;
    }
    public int getEventoContagemSize() {
        return eventoContagem.size();
    }
    // método static pois tanto faz o evento que for chamado, vai depender do número dado no parâmetro
    public static Evento getEvento(int x) {
        return eventoContagem.get(x);
    }
    public String getGrave() {
        return grave;
    }
    public String getMensagemResultadoA() {
        return mensagemResultadoA;
    }
    public String getMensagemResultadoB() {
        return mensagemResultadoB;
    }
    public String getMensagemResultadoC() {
        return mensagemResultadoC;
    }}
