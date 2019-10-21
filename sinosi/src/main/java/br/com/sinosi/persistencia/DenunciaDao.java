package br.com.sinosi.persistencia;

import java.util.Date;
import java.util.List;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.sinosi.entidade.Denuncia;
import br.com.sinosi.entidade.EnumUf;
import br.com.sinosi.entidade.Municipio;

public interface DenunciaDao extends Persistencia<Denuncia> {

	List<Denuncia> listarPorUfMunicipioDataSolicitacao(EnumUf uf, Municipio municipio, Date dataDenuncia, Date dataFim)
			throws PersistenciaException;

	Denuncia consultarPorId(Integer id) throws PersistenciaException;

}
