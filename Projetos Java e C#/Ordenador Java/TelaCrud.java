package br.unip.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.unip.model.Arquivo;
import br.unip.model.Dados;
import br.unip.model.DadosTableModel;

public class TelaCrud extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodMun;
	private JTextField txtMun;
	private JTextField txtEstado;
	private JTextField txtCodPrest;
	private JTextField txtPrestador;
	private JTextField txtSiglaPrest;
	private JTextField txtTipoServ;
	private JLabel lblPopTotal;
	private JTextField txtPopTotal;
	private JTextField txtPopTotalAten;
	private JTextField txtConsumo;
	private JTextField txtPH;
	private File arquivo;
	private BufferedReader leitor = null;
	private JTable tblTabela;
	private DadosTableModel tableModel = new DadosTableModel();
	private String linha = "";
	private String[] campos = new String[11];

	private void adicionaValores(String[] valores) {
		Dados dados = new Dados();
		dados.setCodigo(valores[0]);
		dados.setMunicipio(valores[1]);
		dados.setEstado(valores[2]);
		dados.setCodigoPrestador(valores[3]);
		dados.setPrestador(valores[4]);
		dados.setSiglaPrestador(valores[5]);
		dados.setTipoServico(valores[6]);
		dados.setPopulacaoTotal(Integer.parseInt(valores[7]));
		dados.setPopulacaoTotalAtendida(Integer.parseInt(valores[8]));
		dados.setConsumo(Double.parseDouble(valores[9]));
		dados.setpH(Double.parseDouble(valores[10]));
		tableModel.addRow(dados);
	}

	private boolean camposIsNull() { // Método para verificar há pelo menos um campo preenchido para pesquisa
		if (txtCodMun == null && txtMun == null && txtEstado == null && txtCodPrest == null && txtPrestador == null
				&& txtSiglaPrest == null && txtTipoServ == null && txtPopTotal == null && txtPopTotalAten == null
				&& txtConsumo == null && txtPH == null) {
			return true;
		} else {
			return false;
		}
	}

	public TelaCrud(TelaInicial tela, File file) {
		this.arquivo = file;
		try { // pega o arquivo dado no parâmetro e tenta lê-lo para colocar os dados na tabela
			leitor = new BufferedReader(new FileReader(arquivo));
			while ((linha = leitor.readLine()) != null) {
				String[] dado = linha.split("\t");
				adicionaValores(dado);
			}

		} catch (FileNotFoundException e) {
			System.out.println("ERRO arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO erro: " + e.getMessage());
		} finally {
			if (leitor != null) {
				try {
					leitor.close();
				} catch (IOException e) {
					System.out.println("erro de io: " + e.getMessage());
				}
			}
		}

		setTitle("Saneamento Brasil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlFiltro = new JPanel();
		pnlFiltro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlFiltro.setBounds(12, 48, 245, 482);
		contentPane.add(pnlFiltro);
		pnlFiltro.setLayout(new GridLayout(0, 2, 0, 22));

		JLabel lblCodigo = new JLabel("C\u00F3digo"); // alguns códigos vão ter uns símbolos estranhos, mas isso significa que são letras com acentuação
		pnlFiltro.add(lblCodigo);

		txtCodMun = new JTextField();
		pnlFiltro.add(txtCodMun);
		txtCodMun.setColumns(10);

		JLabel lblMunicipio = new JLabel("Municipio");
		pnlFiltro.add(lblMunicipio);

		txtMun = new JTextField();
		pnlFiltro.add(txtMun);
		txtMun.setColumns(10);

		JLabel lblEstado = new JLabel("Estado");
		pnlFiltro.add(lblEstado);

		txtEstado = new JTextField();
		pnlFiltro.add(txtEstado);
		txtEstado.setColumns(10);

		JLabel lblCodPrest = new JLabel("Cod. Prest");
		lblCodPrest.setToolTipText("C\u00F3digo do Prestador");
		pnlFiltro.add(lblCodPrest);

		txtCodPrest = new JTextField();
		pnlFiltro.add(txtCodPrest);
		txtCodPrest.setColumns(10);

		JLabel lblPrestador = new JLabel("Prestador");
		pnlFiltro.add(lblPrestador);

		txtPrestador = new JTextField();
		pnlFiltro.add(txtPrestador);
		txtPrestador.setColumns(10);

		JLabel lblSiglaPrest = new JLabel("Sigla Prest.");
		lblSiglaPrest.setToolTipText("Sigla do Prestador");
		pnlFiltro.add(lblSiglaPrest);

		txtSiglaPrest = new JTextField();
		pnlFiltro.add(txtSiglaPrest);
		txtSiglaPrest.setColumns(10);

		JLabel lblTipoServ = new JLabel("Tipo Serv.");
		lblTipoServ.setToolTipText("Tipo de Servi\u00E7o");
		pnlFiltro.add(lblTipoServ);

		txtTipoServ = new JTextField();
		pnlFiltro.add(txtTipoServ);
		txtTipoServ.setColumns(10);

		lblPopTotal = new JLabel("Popula\u00E7\u00E3o Total");
		pnlFiltro.add(lblPopTotal);

		txtPopTotal = new JTextField();
		pnlFiltro.add(txtPopTotal);
		txtPopTotal.setColumns(10);

		JLabel lblPopTotalAten = new JLabel("Popula\u00E7\u00E3o Tot. Atendida");
		lblPopTotalAten.setToolTipText("Popula\u00E7\u00E3o Total Atendida");
		pnlFiltro.add(lblPopTotalAten);

		txtPopTotalAten = new JTextField();
		pnlFiltro.add(txtPopTotalAten);
		txtPopTotalAten.setColumns(10);

		JLabel lblConsumo = new JLabel("Consumo");
		pnlFiltro.add(lblConsumo);

		txtConsumo = new JTextField();
		pnlFiltro.add(txtConsumo);
		txtConsumo.setColumns(10);

		JLabel lblPh = new JLabel("pH");
		pnlFiltro.add(lblPh);

		txtPH = new JTextField();
		pnlFiltro.add(txtPH);
		txtPH.setColumns(10);

		JTextField[] camposTextos = { txtCodMun, txtMun, txtEstado, txtCodPrest, txtPrestador, txtSiglaPrest,
				txtTipoServ, txtPopTotal, txtPopTotalAten, txtConsumo, txtPH };

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // botão buscar verifica há pelo menos um campo escrito e faz a busca na tabela 
				for (int n = 0; n < camposTextos.length; n++) {
					campos[n] = camposTextos[n].getText();
				}

				tblTabela.clearSelection();
				for (int i = 0; i < tableModel.getRowCount(); i++) {
					for (int j = 0; j < tableModel.getColumnCount(); j++) {
						if (tableModel.getValueAt(i, j).equals(campos[j])) {
							tblTabela.changeSelection(i, j, true, false);
						}
					}
				}

			}
		});
		btnBuscar.setBounds(12, 541, 75, 23);
		contentPane.add(btnBuscar);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// botao inserir tenta adicionar um dado novo 
				// na tabela lançando erro caso algum dado esteja 
				// fora dos padrões (int pra string por exemplo) 
				// ou caso os campos não foram preenchidos com alguma informação
				try {
					if (!camposIsNull()) {
						Dados dados = new Dados();
						dados.setCodigo(txtCodMun.getText());
						dados.setMunicipio(txtMun.getText());
						dados.setEstado(txtEstado.getText());
						dados.setCodigoPrestador(txtCodPrest.getText());
						dados.setPrestador(txtPrestador.getText());
						dados.setSiglaPrestador(txtSiglaPrest.getText());
						dados.setTipoServico(txtTipoServ.getText());
						dados.setPopulacaoTotal(Integer.parseInt(txtPopTotal.getText()));
						dados.setPopulacaoTotalAtendida(Integer.parseInt(txtPopTotalAten.getText()));
						dados.setConsumo(Double.parseDouble(txtConsumo.getText()));
						dados.setpH(Double.parseDouble(txtPH.getText()));
						tableModel.addRow(dados);
					} else {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos!!");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Preencha corretamente!");
				}
			}
		});
		btnInserir.setBounds(97, 541, 75, 23);
		contentPane.add(btnInserir);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() { // botão apaga o dado selecionado ( caso haja mais de um ele apaga o primeiro)
			public void actionPerformed(ActionEvent arg0) {
				if (tblTabela.getSelectedRow() != -1) {
					tableModel.removeRow(tblTabela.getSelectedRow());
				}
			}
		});
		btnApagar.setBounds(182, 541, 75, 23);
		contentPane.add(btnApagar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(267, 47, 726, 482);
		contentPane.add(scrollPane);

		tblTabela = new JTable();
		tblTabela.setModel(tableModel);
		tableModel.isCellEditable(tblTabela.getSelectedRow(), tblTabela.getSelectedColumn()); // é possível editar um dado na tabela clicando nele duas vezes
		scrollPane.setViewportView(tblTabela);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1002, 23);
		contentPane.add(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmVoltar = new JMenuItem("Voltar");
		mntmVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCrud.this.dispose();
				tela.setVisible(true);

			}
		});
		mnMenu.add(mntmVoltar);

		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() { // botão salvar altera o arquivo de texto dado como parâmetro no construtor
			public void actionPerformed(ActionEvent arg0) {
				String conteudo = "";
				for (int i = 0; i < tableModel.getRowCount(); i++) {
					for (int j = 0; j < tableModel.getColumnCount(); j++) {
						conteudo += tableModel.getValueAt(i, j);
						if (j != tableModel.getColumnCount() - 1) {
							conteudo += "\t";
						}
					}
					if (i != tableModel.getRowCount() - 1) {
						conteudo += "\n";
					}
				}
				Arquivo.write(file.getAbsolutePath(), conteudo);
			}
		});		mnMenu.add(mntmSalvar);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnMenu.add(mntmSair);

	}

}