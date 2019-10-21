package br.com.sinosi.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.sinosi.entidade.Instituicao;
import br.com.sinosi.persistencia.InstituicaoDao;

@Controller("InstituicaoControl")
@Scope("conversation")
public class InstituicaoControl {

    private Instituicao instituicao = new Instituicao();
    private Instituicao instituicaoExcluir;
    private String nome;
    private List<Instituicao> instituicoes = new ArrayList<>();

    @Autowired
    private InstituicaoDao instituicaoDao;

    public void confirmar(ActionEvent evt){
        try {
            instituicaoDao.validar(instituicao);
            instituicaoDao.alterar(instituicao);
            UtilFaces.addMensagemFaces("Instituição Cadastrada com sucesso!");
            instituicao = new Instituicao();
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

    public void listarPorNome(){
        try {
            instituicoes = instituicaoDao.listarPorNome(this.nome);
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

    public void excluir(){
        try {
            instituicaoDao.excluirPorId(instituicaoExcluir.getId());
            listarPorNome();
            UtilFaces.addMensagemFaces("Excluído com sucesso!");
        } catch (Exception e) {
            UtilFaces.addMensagemFaces(e);
        }
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Instituicao> getInstituicoes() {
        return instituicoes;
    }

    public Instituicao getInstituicaoExcluir() {
        return instituicaoExcluir;
    }

    public void setInstituicaoExcluir(Instituicao instituicaoExcluir) {
        this.instituicaoExcluir = instituicaoExcluir;
    }

}
