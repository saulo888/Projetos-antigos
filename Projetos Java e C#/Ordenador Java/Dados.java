package br.unip.model;
public class Dados {
	private String Codigo, Municipio, Estado, CodigoPrestador;
	private String prestador, siglaPrestador, tipoServico;
	private int populacaoTotal, populacaoTotalAtendida;
	private double consumo, pH;
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getMunicipio() {
		return Municipio;
	}
	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getCodigoPrestador() {
		return CodigoPrestador;
	}
	public void setCodigoPrestador(String codigoPrestador) {
		CodigoPrestador = codigoPrestador;
	}
	public String getSiglaPrestador() {
		return siglaPrestador;
	}
	public void setSiglaPrestador(String siglaPrestador) {
		this.siglaPrestador = siglaPrestador;
	}
	public String getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}
	public int getPopulacaoTotal() {
		return populacaoTotal;
	}
	public void setPopulacaoTotal(int populacaoTotal) {
		this.populacaoTotal = populacaoTotal;
	}
	public int getPopulacaoTotalAtendida() {
		return populacaoTotalAtendida;
	}
	public void setPopulacaoTotalAtendida(int populacaoTotalAtendida) {
		this.populacaoTotalAtendida = populacaoTotalAtendida;
	}
	public double getConsumo() {
		return consumo;
	}
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}
	public double getpH() {
		return pH;
	}
	public void setpH(double pH) {
		this.pH = pH;
	}
	public String getPrestador() {
		return prestador;
	}
	public void setPrestador(String prestador) {
		this.prestador = prestador;
	}
}