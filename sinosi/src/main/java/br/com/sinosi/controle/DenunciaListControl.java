package br.com.sinosi.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.sinosi.entidade.Denuncia;
import br.com.sinosi.entidade.EnumCategoria;
import br.com.sinosi.entidade.EnumUf;
import br.com.sinosi.entidade.Municipio;
import br.com.sinosi.persistencia.DenunciaDao;
import br.com.sinosi.persistencia.MunicipioDao;

@Controller("DenunciaListControl")
@Scope("conversation")
public class DenunciaListControl {

	@Autowired
	private DenunciaDao denunciaDao;

	@Autowired
	private MunicipioDao municipioDao;

	private Denuncia denuncia = new Denuncia();
	private Date dataInicio;
	private Date dataFim;
	private String emailUsuario;
	private Municipio municipio;
	private EnumUf uf;
	private EnumCategoria categoria;

	private List<Municipio> municipios = new ArrayList<>();
	private List<Denuncia> denuncias = new ArrayList<>();

	@PostConstruct
	public void init() {
		try {
			this.uf = EnumUf.GO;
			municipios = municipioDao.listarPorUfNome(EnumUf.GO, null);
			filtrarMunicipios();
			listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar() {
		try {

			this.denuncias = denunciaDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void filtrarMunicipios() {
		try {
			if (this.uf != null) {
				this.municipios = this.municipioDao.listarPorUfNome(EnumUf.GO, null);
			} else {
				this.municipios = null;
			}
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
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

	public void listarDenuncias() {
		try {

			this.denuncias = denunciaDao.listarPorUfMunicipioDataSolicitacaoEmailCategoria(EnumUf.GO, this.municipio,
					this.dataInicio, this.dataFim, this.emailUsuario, this.categoria);
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public List<SelectItem> getUfs() {
		return UtilFaces.getListEnum(EnumUf.values());
	}
	
	 public List<SelectItem> getTiposCategorias() {
	        return UtilFaces.getListEnum(EnumCategoria.values());
	    }

	public Denuncia getDenuncia() {
		return denuncia;
	}

	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public List<Denuncia> getDenuncias() {
		return denuncias;
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

	public EnumCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(EnumCategoria categoria) {
		this.categoria = categoria;
	}
	
	

}
