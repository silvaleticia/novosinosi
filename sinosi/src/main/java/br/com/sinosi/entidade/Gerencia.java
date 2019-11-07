package br.com.sinosi.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.com.ambientinformatica.util.AmbientValidator;
import br.com.ambientinformatica.util.Entidade;

@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class Gerencia extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id

	@GeneratedValue(generator = "gerencia_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerencia_seq", sequenceName = "gerencia_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@NotBlank(message = "Preencha o campo descrição.", groups = AmbientValidator.class)
	@Length(min = 0, max = 200, message = "O limite do campo descrição é de 200 caracteres.", groups = AmbientValidator.class)
	@Column(length = 200, nullable = false)
	private String descricao;
	
	@Override
	public String toString() {
		return descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}
	

}