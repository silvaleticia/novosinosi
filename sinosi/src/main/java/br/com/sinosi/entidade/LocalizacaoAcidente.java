package br.com.sinosi.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.ambientinformatica.util.AmbientValidator;
import br.com.ambientinformatica.util.Entidade;

@Entity
public class LocalizacaoAcidente extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "localizacao_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "localizacao_seq", sequenceName = "localizacao_seq", allocationSize = 1, initialValue = 1)
	private Long id;

	@Column(nullable = true, length = 10)
	@Length(min = 0, max = 10, message = "O limite do campo latitude é de 255 caracteres.", groups = AmbientValidator.class)
	private String latitude;

	@Column(nullable = true, length = 10)
	@Length(min = 0, max = 10, message = "O limite do campo longitude é de 255 caracteres.", groups = AmbientValidator.class)
	private String longitude;

	@NotEmpty(message = "Informe o endereço", groups = AmbientValidator.class)
	@Column(nullable = true, length = 255)
	@Length(min = 0, max = 255, message = "O limite do campo endereço é de 255 caracteres.", groups = AmbientValidator.class)
	private String endereco;

	@ManyToOne(optional = false)
	@NotNull(message = "Informe o municipio", groups = AmbientValidator.class)
	private Municipio municipio;

	@Column(nullable = true)
	private String cep;

	@Column(length = 512)
	@Length(min = 0, max = 512, message = "O limite do campo complemento é de 512 caracteres.", groups = AmbientValidator.class)
	private String complemento;

	public LocalizacaoAcidente() {
	}

	public LocalizacaoAcidente(String endereco, Municipio municipio, String cep) {
		super();
		this.endereco = endereco;
		this.municipio = municipio;
		this.cep = cep;
	}
	
	@Override
	public String toString() {
		return "LocalizacaoAcidente [latitude=" + latitude + ", longitude=" + longitude + ", endereco=" + endereco
				+ ", municipio=" + municipio + ", cep=" + cep + ", complemento=" + complemento + "]";
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
