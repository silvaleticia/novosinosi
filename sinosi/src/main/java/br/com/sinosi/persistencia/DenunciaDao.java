package br.com.sinosi.persistencia;

import java.util.Date;
import java.util.List;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.sinosi.entidade.Denuncia;
import br.com.sinosi.entidade.EnumCategoria;
import br.com.sinosi.entidade.EnumUf;
import br.com.sinosi.entidade.Municipio;

public interface DenunciaDao extends Persistencia<Denuncia> {

	List<Denuncia> listarPorUfMunicipioDataSolicitacaoEmailCategoria(EnumUf uf, Municipio municipio, Date dataDenuncia, Date dataFim, String emailUsuario, EnumCategoria categoria)
			throws PersistenciaException;
	
	
	
	

	Denuncia consultarPorId(Integer id) throws PersistenciaException;

}
