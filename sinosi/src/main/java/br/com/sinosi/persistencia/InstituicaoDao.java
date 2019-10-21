package br.com.sinosi.persistencia;

import java.util.List;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.sinosi.entidade.Instituicao;

public interface InstituicaoDao extends Persistencia<Instituicao>{

    List<Instituicao> listarPorNome(String nome) throws PersistenciaException;

}
