package br.com.sinosi.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.sinosi.entidade.Gerencia;
import br.com.sinosi.persistencia.GerenciaDao;

@Scope("conversation")
@Controller("GerenciaListControl")
public class GerenciaListControl implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private GerenciaDao gerenciaDao;


    private Gerencia gerenciaExcluir;

    private String descricao;

    private List<Gerencia> gerencias = new ArrayList<>();

    public void excluir() {
        try {
            gerenciaDao.excluirPorId(this.gerenciaExcluir.getId());
            listar();
            UtilFaces.addMensagemFaces("Excluído com sucesso!");
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

    public void listar() {
        try {
            this.gerencias = gerenciaDao.listarPorDescricao(this.descricao);
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

	public Gerencia getGerenciaExcluir() {
		return gerenciaExcluir;
	}

	public void setGerenciaExcluir(Gerencia gerenciaExcluir) {
		this.gerenciaExcluir = gerenciaExcluir;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Gerencia> getGerencias() {
		return gerencias;
	}

	public void setGerencias(List<Gerencia> gerencias) {
		this.gerencias = gerencias;
	}
    
    

}