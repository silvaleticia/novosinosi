package br.com.sinosi.persistencia;

import java.util.List;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.sinosi.entidade.Gerencia;

public interface GerenciaDao extends Persistencia<Gerencia> {

    List<Gerencia> listarPorDescricao(String descricao) throws PersistenciaException;

}