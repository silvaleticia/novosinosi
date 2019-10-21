package br.com.sinosi.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import br.com.ambientinformatica.util.AmbientValidator;
import br.com.ambientinformatica.util.Entidade;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Municipio extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Length(min = 0, max = 255, message = "O limite do campo descrição é de 255 caracteres.", groups = AmbientValidator.class)
	@Column(length = 255, nullable = false)
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(length = 255, nullable = false)
	@NotNull(message = "Informe a UF do município", groups = AmbientValidator.class)
	private EnumUf uf;

	@Column(nullable = false)
	private Integer codigoIbge;

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

	public EnumUf getUf() {
		return uf;
	}

	public void setUf(EnumUf uf) {
		this.uf = uf;
	}

	public Integer getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(Integer codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	@Override
	public String toString() {
		return String.format("%s (%s)", descricao, uf);
	}
}