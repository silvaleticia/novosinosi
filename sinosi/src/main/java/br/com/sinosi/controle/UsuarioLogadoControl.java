package br.com.sinosi.controle;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.sinosi.entidade.Usuario;
import br.com.sinosi.persistencia.UsuarioDao;

@Controller("UsuarioLogadoControl")
@Scope("session")
public class UsuarioLogadoControl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioDao usuarioDao;

	private Usuario usuario;

	@PostConstruct
	public void init() {
		try {
			HttpServletRequest req = UtilFaces.getRequest();
			String login = req.getUserPrincipal().getName();
			usuario = usuarioDao.consultar(login);
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
