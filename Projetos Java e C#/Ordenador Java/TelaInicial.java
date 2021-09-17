package br.unip.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.unip.model.Arquivo;

public class TelaInicial extends JFrame {
	private JPanel contentPane;
	private JLabel lblAviso = new JLabel("");
	private JToggleButton tglbtnSort = new JToggleButton("Ordernar");
	private JButton btnCrud = new JButton("CRUD");
	private File entrada;
	private Arquivo file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { // método criado pelo WindowBuilder e Swing Designer utilizado para esta classe ser a principal
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setResizable(false);
		setTitle("Saneamento Brasil");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 369);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // este item do menu irá fazer abrir a tela de seleção de arquivos lançando um erro se o usuario n escolher um arquivo com nome entrada.txt ou mergeSort.txt ou quickSort.txt
				try {
					JFileChooser escolhaArquivo = new JFileChooser();
					escolhaArquivo.showOpenDialog(null);
					if (escolhaArquivo.getSelectedFile().getName().equals("entrada.txt")
							|| escolhaArquivo.getSelectedFile().getName().equals("quicksort.txt")
							|| escolhaArquivo.getSelectedFile().getName().equals("mergesort.txt")) {
						entrada = new File(escolhaArquivo.getSelectedFile(), "");
						lblAviso.setText(entrada.getPath());
						tglbtnSort.setEnabled(true);
						btnCrud.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null,
								"Erro no nome do arquivo selecionar entrada.txt ou (algoritmo_de_ordenacao).txt");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ERRO AO ABRIR/CRIAR PROGRAMA");
				}
			}
		});
		mnFile.add(mntmOpen);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlDiretorio = new JPanel();
		pnlDiretorio.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlDiretorio.setBounds(51, 11, 348, 82);
		contentPane.add(pnlDiretorio);
		pnlDiretorio.setLayout(null);

		lblAviso = new JLabel("Não Informado");
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAviso.setBounds(10, 34, 306, 14);
		pnlDiretorio.add(lblAviso);

		JPanel pnlBotoes = new JPanel();
		pnlBotoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlBotoes.setBounds(51, 104, 348, 194);
		contentPane.add(pnlBotoes);
		pnlBotoes.setLayout(null);
		btnCrud.addActionListener(new ActionListener() { // este botão leva para a tela de CRUD do programa levando com parâmetro o arquivo selecionado
			public void actionPerformed(ActionEvent e) {
				TelaCrud crud = new TelaCrud(TelaInicial.this, entrada);
				TelaInicial.this.dispose();
				crud.setVisible(true);
			}
		});

		btnCrud.setEnabled(false);
		btnCrud.setBounds(121, 62, 89, 23);
		pnlBotoes.add(btnCrud);

		JButton btnMerge = new JButton("Merge");
		btnMerge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // este botão irá fazer a ordenação por mergeSort 
				try {
					long all_startime = System.nanoTime();
					File saida = new File(entrada.getParent() + "//mergesort.txt");
					File tempoLog = new File(entrada.getParent() +"//mergeSortTempo.txt");
					tempoLog.createNewFile();
					saida.createNewFile();
					String merge = file.read(entrada.getAbsolutePath());
					String[] mergeA = merge.split("\n");
					String[][] mergeB = new String[mergeA.length][11];
					String[][] aux = mergeB.clone();

					for (int i = 0; i < mergeA.length; i++) {
						for (int j = 0; j < mergeA.length; j++) {
							mergeB[i] = mergeA[i].split("\n");
							mergeB[j] = mergeA[j].split("\t");
						}
					}

					merge = "";
					long merge_startime = System.nanoTime();
					mergeSort(mergeB, aux, 0, mergeB.length - 1);
					long merge_time = ((System.nanoTime() - merge_startime) / 1000000);
					for (int i = 0; i < mergeB.length; i++) {
						for (int j = 0; j < 11; j++) {
							if (j != 10)
								merge += mergeB[i][j] + "\t";
							else
								merge += mergeB[i][j];
						}
						if (i != mergeB.length - 1)
							merge += "\n";
					}

					file.write(saida.getAbsolutePath(), merge);
					long all_time = ((System.nanoTime() - all_startime) / 1000000000);
					JOptionPane.showMessageDialog(null, "Ordenado com sucesso!\nDuração: " + all_time
							+ " segundos\nDuração ordernação: " + merge_time + " ms");
					Arquivo.write(tempoLog.getAbsolutePath(), Arquivo.read(tempoLog.getAbsolutePath()) + "Duração da ordenação: " + merge_time + " ms\n");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ERRO !!!");
					e.printStackTrace();
				}
			}
		});
		btnMerge.setVisible(false);
		btnMerge.setBounds(235, 12, 73, 23);
		pnlBotoes.add(btnMerge);

		JButton btnQuick = new JButton("Quick");
		btnQuick.addActionListener(new ActionListener() { // e este irá fazer por quickSort
			public void actionPerformed(ActionEvent arg0) { 
				try {
					long startime = System.nanoTime();
					File saida = new File(entrada.getParent() + "//quicksort.txt");
					File tempoLog = new File(entrada.getParent() +"//quickSortTempo.txt");
					tempoLog.createNewFile();
					saida.createNewFile();
					String quick = file.read(entrada.getAbsolutePath());
					String[] quickA = quick.split("\n");
					String[][] quickB = new String[quickA.length][11];
					for (int i = 0; i < quickA.length; i++) {
						for (int j = 0; j < quickA.length; j++) {
							quickB[i] = quickA[i].split("\n");
							quickB[j] = quickA[j].split("\t");
						}
					}
					quick = "";
					long quick_startime = System.nanoTime();
					quickSort(quickB, 0, quickB.length - 1);
					long quick_time = ((System.nanoTime() - quick_startime) / 1000000);
					for (int i = 0; i < quickB.length; i++) {
						for (int j = 0; j < 11; j++) {
							if (j != 10)
								quick += quickB[i][j] + "\t";
							else
								quick += quickB[i][j];
						}
						if (i != quickB.length - 1)
							quick += "\n";
					}
					file.write(saida.getAbsolutePath(), quick);
					long all_time = ((System.nanoTime() - startime) / 1000000000);
					JOptionPane.showMessageDialog(null, "Ordenado com sucesso!\nDuração: " + all_time
							+ " segundos\nDuração ordernação: " + quick_time + " ms");
					Arquivo.write(tempoLog.getAbsolutePath(), Arquivo.read(tempoLog.getAbsolutePath()) + "Duração da ordenação: " + quick_time + " ms\n");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ERRO !!!");
				}
			}
		});
		btnQuick.setVisible(false);
		btnQuick.setBounds(235, 46, 73, 23);
		pnlBotoes.add(btnQuick);

		tglbtnSort.setEnabled(false);
		tglbtnSort.addMouseListener(new MouseAdapter() { // caso o botao de ordenação esteja ativado, estes eventos a seguir servem para caso o mouse passe por cima e aparecer outros dois botões
														// e se clicar o botão fica pressionado deixando os dois botões a mostra até ele ser clicado de novo
			@Override
			public void mouseEntered(MouseEvent ev) {
				if (tglbtnSort.isEnabled()) {
					btnMerge.setVisible(true);
					btnQuick.setVisible(true);
				}
			}

			@Override
			public void mouseExited(MouseEvent ev) {
				if (!tglbtnSort.isSelected()) {
					btnMerge.setVisible(false);
					btnQuick.setVisible(false);
				}

			}
		});
		tglbtnSort.setBounds(121, 28, 89, 23);
		pnlBotoes.add(tglbtnSort);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tglbtnSort.setSelected(false);
				btnMerge.setVisible(false);
				btnQuick.setVisible(false);
			}
		});
	}

	private static void mergeSort(String[][] v, String[][] aux, int first, int last) {
		if (first < last) {
			int mid = (first + last) / 2;
			mergeSort(v, aux, first, mid);
			mergeSort(v, aux, mid + 1, last);
			putIn(v, aux, first, mid, last);
		}
	}

	private static void putIn(String[][] v, String[][] aux, int first, int mid, int last) {
		for (int i = first; i <= last; i++) {
			aux[i] = v[i];
		}
		int left = first;
		int right = mid + 1;
		for (int k = first; k <= last; k++) {
			if (left > mid)
				v[k] = aux[right++];
			else if (right > last)
				v[k] = aux[left++];
			else if (Integer.parseInt(aux[left][0]) < Integer.parseInt(aux[right][0])) { // 0 = coluna no qual quer
																							// ordenar
				for (int i = 0; i < aux.length; i++) {
					v[k] = aux[left];
				}
				left++;
			} else {
				for (int i = 0; i < aux.length; i++) {
					v[k] = aux[right];
				}
				right++;
			}
		}
	}

	private static void quickSort(String v[][], int l, int r) {
		int left = l;
		int right = r;
		int pivo = Integer.parseInt(v[(left + right) / 2][0]);
		while (left <= right) {
			while (Integer.parseInt(v[left][0]) < pivo) {
				left = left + 1;
			}
			while (Integer.parseInt(v[right][0]) > pivo) {
				right = right - 1;
			}
			if (left <= right) {
				swap(v, left, right);
				left = left + 1;
				right = right - 1;
			}
		}
		if (right > l)
			quickSort(v, l, right);

		if (left < r)
			quickSort(v, left, r);

	}

	private static void swap(String v[][], int n1, int n2) {
		String[] aux = v[n1];
		v[n1] = v[n2];
		v[n2] = aux;
	}
}