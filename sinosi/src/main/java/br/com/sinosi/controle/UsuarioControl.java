package br.com.sinosi.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.sinosi.entidade.EnumPapelUsuario;
import br.com.sinosi.entidade.EnumUf;
import br.com.sinosi.entidade.Municipio;
import br.com.sinosi.entidade.Usuario;
import br.com.sinosi.persistencia.MunicipioDao;
import br.com.sinosi.persistencia.UsuarioDao;

@Controller("UsuarioControl")
@Scope("conversation")
public class UsuarioControl {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private MunicipioDao municipioDao;
	
	private String nome;
	private String confereSenha;
	

	private Usuario usuarioExcluir;
	private EnumUf uf;
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios = new ArrayList<>();
	private List<Municipio> municipios = new ArrayList<>();

	@PostConstruct
	public void init() {
		listar();
		listaMunicipiosPorUfs();
	}

	public void confirmar() {
		try {
			if (!this.usuario.getSenha().equals(confereSenha)){
				UtilFaces.addMensagemFaces("As senhas não são iguais!");
			}else{
				usuarioDao.validar(this.usuario);
				this.usuario.setSenhaNaoCriptografada(this.usuario.getSenha());
				this.usuario.addPapel(EnumPapelUsuario.USUARIO);
				this.usuario.addPapel(EnumPapelUsuario.ADMIN);
				usuarioDao.alterar(this.usuario);
				usuario = new Usuario();
				listar();
				UtilFaces.addMensagemFaces("Usuário Salvo com sucesso!");
				
			}
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar() {
		try {
			usuarios = usuarioDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void excluir() {
		try {
			usuarioDao.excluirPorId(usuarioExcluir.getId());
			listar();
			UtilFaces.addMensagemFaces("Excluído com sucesso!");
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listaMunicipiosPorUfs() {
		try {
			this.setMunicipios(municipioDao.listarPorUfNome(uf, null));
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public List<SelectItem> getUfs() {
		return UtilFaces.getListEnum(EnumUf.values());
	}
	
	public void listarPorNome(){
        try {
            usuarios = usuarioDao.listarPorNome(this.nome);
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }
	
	public EnumUf getUf() {
		return uf;
	}

	public void setUf(EnumUf uf) {
		this.uf = uf;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioExcluir() {
		return usuarioExcluir;
	}

	public void setUsuarioExcluir(Usuario usuarioExcluir) {
		this.usuarioExcluir = usuarioExcluir;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getConfereSenha() {
		return confereSenha;
	}

	public void setConfereSenha(String confereSenha) {
		this.confereSenha = confereSenha;
	}

}
