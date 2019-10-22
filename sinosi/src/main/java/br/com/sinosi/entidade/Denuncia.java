package br.com.sinosi.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import br.com.ambientinformatica.util.AmbientValidator;
import br.com.ambientinformatica.util.Entidade;

@Entity
public class Denuncia extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "denuncia_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "denuncia_seq", sequenceName = "denuncia_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@NotNull(message = "Informe o endereço", groups = AmbientValidator.class)
	private LocalizacaoAcidente localAcidente;

	@Column(length = 2048)
	@Length(min = 0, max = 2048, message = "O limite do campo descrição do acidente é de 2048 caracteres.", groups = AmbientValidator.class)
	private String descricaoDenuncia;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDenuncia;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOcorrencia;

	private String foto;
	
	@Column(length = 200)
	@Length(min = 0, max = 200, message = "O limite do campo nome do acidente é de 20 caracteres.", groups = AmbientValidator.class)
	private String autorDano;

	@Email(message = "Informe um endereço de e-mail válido", groups = AmbientValidator.class)
	private String emailUsuario;
	
	@Column(length = 200)
	@Length(min = 0, max = 200, message = "O limite do campo nome do acidente é de 20 caracteres.", groups = AmbientValidator.class)
	private String nomeUsuario;
	
	@Column(length = 20)
	@Length(min = 0, max = 20, message = "O limite do campo telefone do acidente é de 20 caracteres.", groups = AmbientValidator.class)
	private String telefoneUsuario;

	@Enumerated(EnumType.STRING)
	private EnumCategoria categoria;

	
	@PrePersist
	private void insereDatadataDenuncia() {
		setDataDenuncia(new Date());

	}

	public Denuncia() {
		localAcidente = new LocalizacaoAcidente();
		
		this.categoria = EnumCategoria.OUTROS;
	}

	public String getDescricaoDenuncia() {
		return descricaoDenuncia;
	}

	public void setDescricaoDenuncia(String descricaoDenuncia) {
		this.descricaoDenuncia = descricaoDenuncia;
	}

	public Date getDataDenuncia() {
		return dataDenuncia;
	}

	public void setDataDenuncia(Date dataDenuncia) {
		this.dataDenuncia = dataDenuncia;
	}


	public String getAutorDano() {
		return autorDano;
	}

	public void setAutorDano(String autorDano) {
		this.autorDano = autorDano;
	}

	public Integer getId() {
		return id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public LocalizacaoAcidente getLocalAcidente() {
		return localAcidente;
	}

	public void setLocalAcidente(LocalizacaoAcidente localAcidente) {
		this.localAcidente = localAcidente;
	}

	public EnumCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(EnumCategoria categoria) {
		this.categoria = categoria;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	

}
