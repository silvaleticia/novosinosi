package br.com.sinosi.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.ambientinformatica.util.UtilLog;
import br.com.sinosi.entidade.Denuncia;
import br.com.sinosi.entidade.EnumCategoria;
import br.com.sinosi.entidade.EnumUf;
import br.com.sinosi.entidade.Municipio;
import br.com.sinosi.persistencia.DenunciaDao;
import br.com.sinosi.persistencia.MunicipioDao;

@Controller("DenunciaControl")
@Scope("conversation")
public class DenunciaControl {

	@Autowired
	private DenunciaDao denunciaDao;

	@Autowired
	private MunicipioDao municipioDao;

	private Denuncia denuncia = new Denuncia();
	private EnumUf uf;
	private List<Municipio> municipios = new ArrayList<>();

	@PostConstruct
	public void init() {
		listaMunicipiosPorUfs();
	}

	public void iniciarDenuncia(EnumCategoria categoria) {
		denuncia = new Denuncia();

		switch (categoria) {
		case VEGETACAO:
		case FAUNA:
		case AR:
		case SOLO:
		case FOGO:
		case AGUA:
		case OUTROS:
			break;
		default:
			UtilLog.getLog().error("Erro ao buscar categoria");
		}
		this.denuncia.setCategoria(categoria);
	}

	public void confirmar(ActionEvent evt) {
		try {
			denunciaDao.validar(denuncia);
			denunciaDao.alterar(denuncia);

			UtilFaces.addMensagemFaces("Denuncia Cadastrada com sucesso!");
			denuncia = new Denuncia();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void editarDenuncia(ActionEvent evt) {
		this.denuncia = (Denuncia) UtilFaces.getValorParametro(evt, "denuncia");
	}

	public void listaMunicipiosPorUfs() {
		try {
			if (this.uf != null) {
				this.municipios = this.municipioDao.listarPorUfNome(this.uf, null);
			} else {
				this.municipios = null;
			}
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public List<SelectItem> getUfs() {
		return UtilFaces.getListEnum(EnumUf.values());
	}

	public List<SelectItem> getDenuncias() {
		return UtilFaces.getListEnum(EnumCategoria.values());
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public EnumUf getUf() {
		return uf;
	}

	public void setUf(EnumUf uf) {
		this.uf = uf;
	}

	public Denuncia getDenuncia() {
		return denuncia;
	}

	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
	}

}
