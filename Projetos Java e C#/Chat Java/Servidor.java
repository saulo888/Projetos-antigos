package br.unip.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Servidor extends Thread {
	private static Map<String, ObjectOutputStream> clientes;
	private static ServerSocket server;
	private String nome;
	private Socket con;
	private ObjectInputStream in;

	/*
	 * Variaveis importantes: Map<String, ObjectOutputStream> clientes … uma
	 * estrutura de dados como se fosse uma lista com id e o valor que ela possui o
	 * id neste caso È o nome de cada cliente e o valor È o ObjectOutputStream que
	 * serve para mandar uma mensagem para o cliente, cada cliente possui seu
	 * prÛprio OOS È como se fosse a rota pra quem o servidor deve mandar a mensagem
	 *
	 * ServerSocket server: … a variavel de abrir uma porta para a conex„o de um
	 * socket
	 * 
	 * Socket con: … a variavel responsavel por estabelecer a conex„o de um cliente
	 * com o servidor
	 * 
	 * ObjectInputStream in: O contr·rio do OOS, È a "rota" de onde CHEGA a mensagem
	 * do cliente
	 * 
	 */

	public Servidor(Socket con) {
		this.con = con;
		try {
			in = new ObjectInputStream(con.getInputStream());
			// Instancia do OIS do cliente que conectou no socket con

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) { // ao abrir o servidor ele inicia seus comandos daqui
		try {

			// cria objetos do JFrame para o visual
			JLabel lblPorta = new JLabel("Porta do servidor: ");
			JTextField txtPorta = new JTextField("8888");
			Object[] objetosSwing = { lblPorta, txtPorta };
			JOptionPane.showMessageDialog(null, objetosSwing);

			// cria socket e instancia a lista de clientes
			server = new ServerSocket(Integer.parseInt(txtPorta.getText()));
			clientes = new HashMap<String, ObjectOutputStream>();

			JOptionPane.showMessageDialog(null, "Servidor ativo na porta: " + txtPorta.getText());

			while (true) { // O servidor sempre estar· esperando um novo cliente conectar, para isso um
							// laÁo while(true) foi necess·rio
				System.out.println("Aguardando conex„o...");
				Socket con = server.accept();
				System.out.println("Cliente conectado...");
				Thread thread = new Servidor(con);
				thread.start();
				// A classe Servidor extende Thread que por vez possui os mÈtodos start e run
				// Sempre um novo "servidor" È criado para outro cliente conectar, mas na
				// realidade
				// todos clientes est„o conversando com o mesmo servidor
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void run() {
		try {
			Object mensagem;
			// a mensagem È um objeto ao inves de string, pois a troca de mensagem n„o È
			// apenas de mensagem de texto

			ObjectOutputStream out = new ObjectOutputStream(this.con.getOutputStream());
			// instancia a "rota" de mensagens do cliente que se conectou

			nome = (String) (mensagem = in.readObject().toString());
			// a primeira mensagem que o servidor recebe de um cliente È o seu nome

			clientes.put(nome, out);
			// dentro da estrutura de dados "clientes" insere o nome do cliente e a rota da
			// mensagem dele

			atualizaClientes();
			// mÈtodo que manda a lista de clientes atualizada para todos os clientes

			while (!mensagem.toString().startsWith("/sair")) {
				mensagem = in.readObject().toString();
				// o servidor nesse ponto ficara esperando mensagens de cada cliente, caso a
				// mensagem comece com
				// "/sair" ele interpreta que o cliente vai se desconectar ent„o para de esperar
				// mensagem deste
				// cliente que mandou a mensagem e passa pelo mÈtodo disconnect

				if (!mensagem.toString().startsWith("/sair")) {
					sendToAll(out, mensagem);
					// mÈtodo que envia um objeto para todas as "rotas" da lista de clientes,
					// geralmente uma mensagem string

					System.out.println(nome + ": " + mensagem);
				}
			}

			disconnect(clientes.get(mensagem.toString().substring(5)));
			// mÈtodo que ir· remover o cliente da lista de clientes e mandar a mensagem que
			// ele se desconectou

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void disconnect(ObjectOutputStream outSaida) throws IOException {
		sendToAll(outSaida, " se desconectou.");
		clientes.remove(nome);
		System.out.println(nome + " se desconectou.");
		atualizaClientes();
	}

	private void sendToAll(ObjectOutputStream outSaida, Object mensagem) throws IOException {
		ObjectOutputStream outS;
		for (Map.Entry<String, ObjectOutputStream> id : clientes.entrySet()) {
			outS = id.getValue();
			if (!(outSaida == id.getValue())) {
				id.getValue().writeObject(nome + ": " + mensagem + "\r\n");
				id.getValue().flush();
			}
		}

	}

	public void atualizaClientes() throws IOException { // atualiza clientes
		Set<String> setNomes = new HashSet<String>();
		for (Map.Entry<String, ObjectOutputStream> id : clientes.entrySet()) {
			setNomes.add(id.getKey());
		}

		for (Map.Entry<String, ObjectOutputStream> id : clientes.entrySet()) {
			id.getValue().writeObject(setNomes);
		}
	}

}