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

import br.com.ambientinformatica.util.AmbientValidator;
import br.com.ambientinformatica.util.Entidade;

@Entity
public class ProdutoOnu extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "produto_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@Column(length = 512, nullable = true)
	@Length(min = 0, max = 512, message = "O limite do campo é de 512 caracteres.", groups = AmbientValidator.class)
	private String descricao;
	
	private Integer numeroOnu;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeCadastro;

	@Override
	public Integer getId() {
		return id;
	}
	
	@PrePersist
    private void insereDataCadastro() {
		setDataDeCadastro(new Date());
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

	public Integer getNumeroOnu() {
		return numeroOnu;
	}

	public void setNumeroOnu(Integer numeroOnu) {
		this.numeroOnu = numeroOnu;
	}

	
}
