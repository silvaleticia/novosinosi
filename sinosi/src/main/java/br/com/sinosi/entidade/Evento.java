package br.com.sinosi.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.ambientinformatica.util.AmbientValidator;
import br.com.ambientinformatica.util.Entidade;

@Entity
public class Evento extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "evento_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "evento_seq", sequenceName = "evento_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@NotEmpty(message = "Informe o Tipo de Evento Ocorrido ", groups = AmbientValidator.class)
	@Column(length = 512, nullable = false)
	@Length(min = 0, max = 512, message = "O limite do campo evento é de 512 caracteres.", groups = AmbientValidator.class)
	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeCadastro;

	@PrePersist
	private void insereDataCadastro() {
		setDataDeCadastro(new Date());
	}

	@Override
	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

}
