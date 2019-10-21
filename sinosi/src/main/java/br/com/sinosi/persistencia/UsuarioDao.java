package br.com.sinosi.persistencia;

import java.util.List;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.sinosi.entidade.Usuario;

public interface UsuarioDao extends Persistencia<Usuario>{

    List<Usuario> listarPorNome(String nome) throws PersistenciaException;

	Usuario consultarPorCpfSemValidacao(String string) throws PersistenciaException;

}
