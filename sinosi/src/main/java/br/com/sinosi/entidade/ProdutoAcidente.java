package br.com.sinosi.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ambientinformatica.util.AmbientValidator;

@Entity
public class ProdutoAcidente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "produto_acidente_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "produto_acidente_seq", sequenceName = "produto_acidente_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeCadastro;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ProdutoOnu produtoOnu;

	@NotNull(message = "Informe a Unidade de Medida.", groups = AmbientValidator.class)
	@Enumerated(EnumType.STRING)
	private EnumUnidadeMedida unidadeMedida;

	@Column(precision = 19, scale = 2)
	private BigDecimal quantidadeProduto = BigDecimal.ZERO;
	
	@Column(length = 512)
	@Length(min = 0, max = 512, message = "O limite do campo é de 512 caracteres.", groups = AmbientValidator.class)
	private String produtoNaoOnu;
	
	private boolean onu = true;
	
	@ManyToOne
	private Notificacao notificacao;

	public String getQuantidadeFormatada() {

		return new java.text.DecimalFormat("#,###,##0.00").format(this.quantidadeProduto);
	}

	
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public ProdutoOnu getProdutoOnu() {
		return produtoOnu;
	}

	public void setProdutoOnu(ProdutoOnu produtoOnu) {
		this.produtoOnu = produtoOnu;
	}

	public EnumUnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(EnumUnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public BigDecimal getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(BigDecimal quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Notificacao getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}

	public Integer getId() {
		return id;
	}

	public void setOnu(boolean onu) {
		this.onu = onu;
	}


	public boolean isOnu() {
		return onu;
	}


	public String getProdutoNaoOnu() {
		return produtoNaoOnu;
	}


	public void setProdutoNaoOnu(String produtoNaoOnu) {
		this.produtoNaoOnu = produtoNaoOnu;
	}
	
	

}
