package br.com.sinosi.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.ambientinformatica.util.AmbientValidator;
import br.com.ambientinformatica.util.Entidade;

@Entity
public class Instituicao extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "instituicao_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "instituicao_seq", sequenceName = "instituicao_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@NotEmpty(message = "Informe o nome da instituição.", groups = AmbientValidator.class)
	@Column(length = 255, nullable = false)
	@Length(min = 0, max = 255, message = "O limite do campo nome da instituição é de 255 caracteres.", groups = AmbientValidator.class)
	private String nome;

	@NotEmpty(message = "Informe o CNPJ da instituição.", groups = AmbientValidator.class)
	@Column(length = 255, nullable = false, unique = true)
	@Length(min = 0, max = 255, message = "O limite do campo CNPJ da instituição é de 255 caracteres.", groups = AmbientValidator.class)
	private String cnpj;

	@Override
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
