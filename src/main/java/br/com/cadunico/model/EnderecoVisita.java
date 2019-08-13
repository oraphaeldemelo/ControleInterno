package br.com.cadunico.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class EnderecoVisita implements Serializable {

	private static final long serialVersionUID = 1L;

	private String localidadeBairro;
	private Integer numero;
	private String localRua;
	private String complemento;
	private Zona zona;
	private String pontoReferencia; 
	
	public String getLocalidadeBairro() {
		return localidadeBairro;
	}
	public void setLocalidadeBairro(String localidadeBairro) {
		this.localidadeBairro = localidadeBairro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getLocalRua() {
		return localRua;
	}
	public void setLocalRua(String localRua) {
		this.localRua = localRua;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getPontoReferencia() {
		return pontoReferencia;
	}
	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name="zona_local")
	public Zona getZona() {
		return zona;
	}
	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
	
}
