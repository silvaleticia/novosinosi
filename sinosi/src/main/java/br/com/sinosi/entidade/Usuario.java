package br.com.sinosi.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.ambientinformatica.jpa.util.AlfaNumerico;
import br.com.ambientinformatica.jpa.util.CpfCnpj;
import br.com.ambientinformatica.util.AmbientValidator;
import br.com.ambientinformatica.util.Entidade;
import br.com.ambientinformatica.util.UtilHash;
import br.com.ambientinformatica.util.UtilHash.Algoritimo;

@Entity
public class Usuario extends Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(message = "Login do usuário é obrigatório", groups = AmbientValidator.class)
	@NotEmpty(message = "Login do usuário é obrigatório", groups = AmbientValidator.class)
	@AlfaNumerico(message = "O login do usuário não pode conter caracteres especiais, acentos ou espaços", semAcentos = true, semEspacos = true, groups = AmbientValidator.class)
	private String login;

	@NotEmpty(message = "Erro: Informe o Senha!", groups = AmbientValidator.class)
	@Length(min = 0, max = 255, message = "O limite do campo senha é de 255 caracteres.", groups = AmbientValidator.class)
	private String senha;

	@NotEmpty(message = "Informe o nome", groups = AmbientValidator.class)
	@Length(min = 0, max = 255, message = "O limite do campo nome é de 255 caracteres.", groups = AmbientValidator.class)
	@Column(nullable = false, length = 255)
	private String nome;

	@NotEmpty(message = "Informe o CPF", groups = AmbientValidator.class)
	@CpfCnpj(message = "CPF inválido", groups = AmbientValidator.class)
	@Column(unique = true, nullable = false)
	private String cpf;

	@Column(nullable = false)
	@NotEmpty(message = "Informe o RG", groups = AmbientValidator.class)
	private String rg;

	@Column(unique = true, length = 255, nullable = false)
	@NotEmpty(message = "Informe o email", groups = AmbientValidator.class)
	@Email(message = "Informe um endereço de e-mail válido", groups = AmbientValidator.class)
	@Length(min = 0, max = 255, message = "O limite do campo e-mail é de 255 caracteres.", groups = AmbientValidator.class)
	private String email;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "Informe a data de nascimento", groups = AmbientValidator.class)
	private Date dataNascimento;

	@NotEmpty(message = "Informe o endereço", groups = AmbientValidator.class)
	@Column(nullable = false, length = 255)
	@Length(min = 0, max = 255, message = "O limite do campo endereço é de 255 caracteres.", groups = AmbientValidator.class)
	private String endereco;

	@ManyToOne(optional = false)
	@NotNull(message = "Informe o municipio", groups = AmbientValidator.class)
	private Municipio municipio;

	@Column(nullable = false)
	@NotEmpty(message = "Informe o CEP", groups = AmbientValidator.class)
	private String cep;

	@Column(nullable = false)
	@NotEmpty(message = "Informe o telefone", groups = AmbientValidator.class)
	@Length(min = 10, max = 16, message = "Informe corretamente o telefone (incluindo o prefixo)", groups = AmbientValidator.class)
	private String telefone;

	@Temporal(TemporalType.DATE)
	private Date dataAlteracaoSenha = new Date();

	@Temporal(TemporalType.DATE)
	private Date dataCriacao = new Date();

	@Temporal(TemporalType.DATE)
	private Date dataUltimoAcesso = new Date();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id")
	private Set<PapelUsuario> papeis = new HashSet<PapelUsuario>();

	public boolean isContemPapel(EnumPapelUsuario papel) {
		for (PapelUsuario p : papeis) {
			if (p.getPapel() == papel) {
				return true;
			}
		}
		return false;
	}

	public List<PapelUsuario> getPapeisList() {
		List<PapelUsuario> result = new ArrayList<PapelUsuario>(papeis);
		Collections.sort(result);
		return result;
	}

	public void addPapel(EnumPapelUsuario papel) {
		if (!isContemPapel(papel)) {
			PapelUsuario pu = new PapelUsuario();
			pu.setPapel(papel);
			papeis.add(pu);
		}
	}
	
	public void resetarSenha() {
		setSenhaNaoCriptografada("123456");
	}

	public void setSenhaNaoCriptografada(String senha) {
		this.senha = UtilHash.gerarStringHash(senha, Algoritimo.MD5);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setPapeis(Set<PapelUsuario> papeis) {
		this.papeis = papeis;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataAlteracaoSenha() {
		return dataAlteracaoSenha;
	}

	public void setDataAlteracaoSenha(Date dataAlteracaoSenha) {
		this.dataAlteracaoSenha = dataAlteracaoSenha;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	public Set<PapelUsuario> getPapeis() {
		return papeis;
	}

	public Object getId() {
		return login;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
