package com.api.crm.model;

public class ResponsabilityLetter {
	private String razaoCliente;
	private String responsavelLegCliente;
	private String cpfLegCliente;
	private String cnpjCliente;
	private String cargoResponsavel;
	private String sistemaGestao;
	private String crcContador;
	private String cidadeCliente;
	
	public ResponsabilityLetter(
		String razaoCliente,
		String responsavelLegCliente,
		String cpfLegCliente,
		String cnpjCliente,
		String cargoResponsavel,
		String sistemaGestao,
		String crcContador,
		String cidadeCliente
	) {
		this.razaoCliente = razaoCliente;
		this.responsavelLegCliente = responsavelLegCliente;
		this.cpfLegCliente = cpfLegCliente;
		this.cnpjCliente = cnpjCliente;
		this.cargoResponsavel = cargoResponsavel;
		this.sistemaGestao = sistemaGestao;
		this.crcContador = crcContador;
		this.cidadeCliente = cidadeCliente;
	}
	
	public ResponsabilityLetter() {
		
	}
	public String getRazaoCliente() {
		return razaoCliente;
	}
	public void setRazaoCliente(String razaoCliente) {
		this.razaoCliente = razaoCliente;
	}
	public String getResponsavelLegCliente() {
		return responsavelLegCliente;
	}
	public void setResponsavelLegCliente(String responsavelLegCliente) {
		this.responsavelLegCliente = responsavelLegCliente;
	}
	public String getCpfLegCliente() {
		return cpfLegCliente;
	}
	public void setCpfLegCliente(String cpfLegCliente) {
		this.cpfLegCliente = cpfLegCliente;
	}
	public String getCnpjCliente() {
		return cnpjCliente;
	}
	public void setCnpjCliente(String cnpjCliente) {
		this.cnpjCliente = cnpjCliente;
	}
	public String getCargoResponsavel() {
		return cargoResponsavel;
	}
	public void setCargoResponsavel(String cargoResponsavel) {
		this.cargoResponsavel = cargoResponsavel;
	}
	public String getSistemaGestao() {
		return sistemaGestao;
	}
	public void setSistemaGestao(String sistemaGestao) {
		this.sistemaGestao = sistemaGestao;
	}
	public String getCrcContador() {
		return crcContador;
	}
	public void setCrcContador(String crcContador) {
		this.crcContador = crcContador;
	}
	public String getCidadeCliente() {
		return cidadeCliente;
	}
	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}
	
}
