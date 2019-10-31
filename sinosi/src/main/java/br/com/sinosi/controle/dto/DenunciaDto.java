package br.com.sinosi.controle.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.sinosi.entidade.LocalizacaoAcidente;
import br.com.sinosi.entidade.Municipio;

public class DenunciaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricaoDenuncia;
	private String foto;
	private String autorDano;
	private String emailUsuario;
	private String nomeUsuario;
	private String telefoneUsuario;

	@JsonIgnore
	private Municipio municipio;
	private LocalizacaoAcidente municipioCodIbge;
	private LocalizacaoAcidente cep;

	public DenunciaDto() {
		super();
	}

	public DenunciaDto(String descricaoDenuncia, String foto, String autorDano, String emailUsuario, String nomeUsuario,
			Municipio municipio, LocalizacaoAcidente municipioCodIbge, LocalizacaoAcidente cep,
			String telefoneUsuario) {
		super();
		this.descricaoDenuncia = descricaoDenuncia;
		this.foto = foto;
		this.autorDano = autorDano;
		this.emailUsuario = emailUsuario;
		this.nomeUsuario = nomeUsuario;
		this.municipio = municipio;
		this.municipioCodIbge = municipioCodIbge;
		this.cep = cep;
		this.telefoneUsuario = telefoneUsuario;
	}

	public String getDescricaoDenuncia() {
		return descricaoDenuncia;
	}

	public void setDescricaoDenuncia(String descricaoDenuncia) {
		this.descricaoDenuncia = descricaoDenuncia;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getAutorDano() {
		return autorDano;
	}

	public void setAutorDano(String autorDano) {
		this.autorDano = autorDano;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public LocalizacaoAcidente getMunicipioCodIbge() {
		return municipioCodIbge;
	}

	public void setMunicipioCodIbge(LocalizacaoAcidente municipioCodIbge) {
		this.municipioCodIbge = municipioCodIbge;
	}

	public LocalizacaoAcidente getCep() {
		return cep;
	}

	public void setCep(LocalizacaoAcidente cep) {
		this.cep = cep;
	}

	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}
	
	

}
