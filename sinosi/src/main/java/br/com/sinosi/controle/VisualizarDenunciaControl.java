package br.com.sinosi.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.sinosi.entidade.Denuncia;
import br.com.sinosi.persistencia.DenunciaDao;

@Controller("VisualizarDenunciaControl")
@Scope("conversation")
public class VisualizarDenunciaControl {

	@Autowired
	private DenunciaDao denunciaDao;

	private Denuncia denuncia = new Denuncia();
	

	 public void visualizarDenuncia(Denuncia denuncia) {
	        try {
	            this.denuncia = denunciaDao.consultarPorId(denuncia.getId());
	        } catch (Exception e) {
	            UtilFaces.addMensagemFaces(e);
	        }
	    }


	public Denuncia getDenuncia() {
		return denuncia;
	}


	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
	}
	
	

}
