
package br.unip.classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class Cliente extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	public Set<String> clientes;
	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Object msg;
	/*
	 * // Variaveis importantes:
	 * 
	 * Set<String> clientes: … praticamente uma lista, composta por nomes dos
	 * clientes conectados ao servidor, pode-se utilizar o nome do cliente para
	 * acha-lo
	 * 
	 * Socket socket: Respons·vel por estabelecer a conex„o com cliente/servidor
	 * 
	 * ObjectOutputStream out: As mensagens que ser„o enviadas para o servidor
	 * ("a rota")
	 */

	private JTextArea texto;
	private JTextField txtMsg;
	private JButton btnSend;
	private JButton btnSair;
	private JLabel lblHistorico;
	private JPanel pnlContent;
	private JTextField txtIP;
	private JTextField txtPorta;
	private JTextField txtNome;
	DefaultListModel model = new DefaultListModel();
	JList list = new JList();

	public Cliente() throws IOException {
		JLabel lblMessage = new JLabel("Verificar!");
		txtIP = new JTextField("127.0.0.1"); // aqui se bota o ip do servidor
		txtPorta = new JTextField("8888"); // aqui a porta
		txtNome = new JTextField("Cliente"); // aqui o nome
		Object[] texts = { lblMessage, txtIP, txtPorta, txtNome };
		JOptionPane.showMessageDialog(null, texts);
		pnlContent = new JPanel();
		txtMsg = new JTextField(20);
		txtMsg.setBounds(10, 297, 319, 23);
		lblHistorico = new JLabel("HistÛrico");
		lblHistorico.setBounds(198, 11, 63, 14);
		btnSend = new JButton("Enviar");
		btnSend.setBounds(339, 297, 80, 23);
		btnSend.setToolTipText("Enviar Mensagem");
		btnSair = new JButton("X");
		btnSair.setBackground(Color.WHITE);
		btnSair.setForeground(Color.RED);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSair.setBounds(520, 296, 48, 23);
		btnSair.setToolTipText("Sair do Chat");
		btnSend.addActionListener(this);
		btnSair.addActionListener(this);
		btnSend.addKeyListener(this);
		txtMsg.addKeyListener(this);
		pnlContent.setLayout(null);
		pnlContent.add(lblHistorico);
		JScrollPane scrPaneHist = new JScrollPane();
		scrPaneHist.setBounds(10, 36, 409, 250);
		pnlContent.add(scrPaneHist);
		texto = new JTextArea(10, 20);
		scrPaneHist.setViewportView(texto);
		texto.setEditable(false);
		texto.setBackground(new Color(240, 240, 240));
		texto.setLineWrap(true);
		texto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(152, 251, 152), new Color(152, 251, 152)));
		pnlContent.add(txtMsg);
		pnlContent.add(btnSair);
		pnlContent.add(btnSend);
		pnlContent.setBackground(new Color(230, 230, 250));
		txtMsg.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setTitle(txtNome.getText());
		setContentPane(pnlContent);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				texto.setText("");
			}
		});
		btnLimpar.setBounds(429, 297, 81, 23);
		pnlContent.add(btnLimpar);

		JScrollPane scrPaneConectados = new JScrollPane();
		scrPaneConectados.setBounds(429, 36, 139, 250);
		pnlContent.add(scrPaneConectados);

		list.setModel(model);
		list.setBackground(new Color(245, 245, 245));
		scrPaneConectados.setViewportView(list);

		JLabel lblConectados = new JLabel("Conectados");
		lblConectados.setBounds(463, 11, 87, 14);
		pnlContent.add(lblConectados);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(584, 362);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// A variavel cliente comeÁa aqui, quando ela da o "new Cliente()" que o mÈtodo
		// construtor È ativado

		Cliente app = new Cliente();
		app.conectar();
		// aqui a conex„o È estabelicida dependendo do ip e a porta que o usuario
		// colocou, alÈm estabele a rota de envios de mensagem e tambÈm manda o nome
		// para o servidor

		app.escutar();
		// o cliente espera mensagens do servidor para trata-las do jeito correto

	}

	public void conectar() throws IOException {

		socket = new Socket(txtIP.getText(), Integer.parseInt(txtPorta.getText())); // cria o socket para conex„o
		out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(txtNome.getText()); // manda o nome para o servidor
		out.flush();
	}

	public void escutar() throws IOException, ClassNotFoundException {

		in = new ObjectInputStream(socket.getInputStream());
		// variavel para esperar mensagens do servidor

		msg = "";
		// tudo È recebido ou enviado em formas de Object pois È f·cil de transformar em
		// outros tipos caso precise

		clientes = new HashSet<String>();
		// instancia a lista de clientes

		while (!msg.toString().equals(txtNome.getText() + "se desconectou.")) {
			// se o socket n„o estiver desconectado, ele ficar· esperando mensagens

			msg = in.readObject();
			// o cÛdigo fica parado neste ponto atÈ receber uma mensagem do servidor

			if (msg.getClass() == new HashSet<String>().getClass()) { // se a mensagem for uma lista de clientes
				atualizarClientes((HashSet<String>) msg);
				// atualiza a lista de clientes retirando ou colocando quem saiu ou entrou

			} else { // senao coloca no textarea a mensagem recebida (formato string)
				texto.append((String) msg);
			}

		}
		socket.close();
	}

	public void enviarMensagem(Object msg) throws IOException {
		// este mÈtodo È acionado quando o cliente aperta "ENTER" ou clica no bot„o de
		// enviar a mensagem

		if (msg.toString().startsWith("/sair")) {
			// se a mensagem recebida comeÁar com /sair ele envia a mensagem de desconex„o

			out.writeObject("/sair" + txtNome.getText());
			// texto.append("Desconectado \r\n");

		} else {
			// se nao ele sÛ envia a mensagem para o servidor e imprime a sua propria
			// mensagem na tela

			out.writeObject(msg);
			texto.append(txtNome.getText() + " diz: " + txtMsg.getText() + "\n");
		}
		out.flush();
		txtMsg.setText("");
	}

	public void atualizarClientes(HashSet<String> msg) {
		// este mÈtodo troca a lista atual de clientes para a lista de clientes recebida
		// do servidor
		clientes.clear();
		clientes.addAll(msg);

		model.clear();
		for (String i : clientes) {
			model.addElement(i);
			list.setModel(model);
		}
		// System.out.println(clientes);

	}

	public void sair() throws IOException, ClassNotFoundException {
		texto.append("Desconectado do servidor.\n");
		out.writeObject("/sair" + txtNome.getText());
		// quando clicar no botao de sair este mÈtodo È acionado e ele envia parao
		// servidor a string /sairNOMEDOCLIENTE

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// tratamento dos botıes

		try {
			if (e.getActionCommand().equals(btnSend.getActionCommand()))
				enviarMensagem(txtMsg.getText());
			else if (e.getActionCommand().equals(btnSair.getActionCommand())) {
				sair();
				model.clear();
				list.setModel(model);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		// tratamento de teclas pressionadas

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				enviarMensagem(txtMsg.getText());
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}
