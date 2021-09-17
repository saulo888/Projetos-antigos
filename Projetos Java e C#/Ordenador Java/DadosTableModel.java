package br.unip.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class DadosTableModel extends AbstractTableModel {

	private List<Dados> dados = new ArrayList<>();
	private String[] colunas = { "Codigo", "Municio", "Estado", "Codigo Prestador", "Prestador", "Sigla Prestador",
			"Tipo Serviço", "População Total", "População Total Atendida", "Consumo", "pH" };

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return dados.get(linha).getCodigo();
		case 1:
			return dados.get(linha).getMunicipio();
		case 2:
			return dados.get(linha).getEstado();
		case 3:
			return dados.get(linha).getCodigoPrestador();
		case 4:
			return dados.get(linha).getPrestador();
		case 5:
			return dados.get(linha).getSiglaPrestador();
		case 6:
			return dados.get(linha).getTipoServico();
		case 7:
			return dados.get(linha).getPopulacaoTotal();
		case 8:
			return dados.get(linha).getPopulacaoTotalAtendida();
		case 9:
			return dados.get(linha).getConsumo();
		case 10:
			return dados.get(linha).getpH();
		}

		return null;
	}
	
	@Override
	public void setValueAt(Object valor, int linha, int coluna) {

		try {
		switch (coluna) {
		case 0:
			dados.get(linha).setCodigo((String) valor);
			break;
		case 1:
			dados.get(linha).setMunicipio((String) valor);
			break;
		case 2:
			dados.get(linha).setEstado((String) valor);
			break;
		case 3:
			dados.get(linha).setCodigoPrestador((String) valor);
			break;
		case 4:
			dados.get(linha).setPrestador((String) valor);
			break;
		case 5:
			dados.get(linha).setSiglaPrestador((String) valor);
			break;
		case 6:
			dados.get(linha).setTipoServico((String) valor);
			break;
		case 7:
			dados.get(linha).setPopulacaoTotal(Integer.parseInt((String) valor));
			break;
		case 8:
			dados.get(linha).setPopulacaoTotalAtendida(Integer.parseInt((String) valor));
			break;
		case 9:
			dados.get(linha).setConsumo(Double.parseDouble((String) valor));
			break;
		case 10:
			dados.get(linha).setpH(Double.parseDouble((String) valor));
			break;
			
		}
		this.fireTableCellUpdated(linha, coluna);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO NO TIPO DE VALOR!!!");
		}
		
	}

	@Override
	public boolean isCellEditable(int linha, int coluna) {
		boolean teste = false;
		if (coluna == 0 || coluna == 3) {
			teste = false;
		}
		else {
			teste = true;
			this.fireTableCellUpdated(linha, coluna);
		}
		return teste;
	}

	public void addRow(Dados d) {
		this.dados.add(d);
		this.fireTableDataChanged();
	}

	public void removeRow(int linha) {
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

}