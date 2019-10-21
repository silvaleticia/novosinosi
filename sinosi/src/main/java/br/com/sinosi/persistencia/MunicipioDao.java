package br.com.sinosi.persistencia;

import java.util.List;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.sinosi.entidade.EnumUf;
import br.com.sinosi.entidade.Municipio;


public interface MunicipioDao extends Persistencia<Municipio>{

    List<Municipio> listarPorUfDescricaoDescentralizacao(EnumUf uf, String descricao, Boolean descentralizado) throws PersistenciaException;
    
    Municipio municipioPorCodigoIBGE(Integer codigoIbge) throws PersistenciaException;

    List<Municipio> listarPorUfNome(EnumUf uf, String descricao) throws PersistenciaException;

    Long consultarTotalDeMunicipios(Boolean descentralizado) throws PersistenciaException;

}
