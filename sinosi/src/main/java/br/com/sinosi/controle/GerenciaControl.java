package br.com.sinosi.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.sinosi.entidade.Gerencia;
import br.com.sinosi.persistencia.GerenciaDao;

@Scope("conversation")
@Controller("GerenciaControl")
public class GerenciaControl {

    @Autowired
    private GerenciaDao gerenciaDao;

    private Gerencia gerencia = new Gerencia();

    public void confirmar() {
        try {
            if (this.gerencia.getId() == null) {
                gerenciaDao.incluir(this.gerencia);
                this.gerencia = new Gerencia();
                UtilFaces.addMensagemFaces("Gerencia cadastrada!");
            } else {
                gerenciaDao.alterar(this.gerencia);
                UtilFaces.addMensagemFaces("Gerencia alterada!");
            }
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

	public Gerencia getGerencia() {
		return gerencia;
	}

	public void setGerencia(Gerencia gerencia) {
		this.gerencia = gerencia;
	}

    

}