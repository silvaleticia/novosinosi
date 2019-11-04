package br.com.sinosi.servico;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.sinosi.entidade.Municipio;
import br.com.sinosi.persistencia.MunicipioDao;

@Service
public class MunicipioServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private MunicipioDao municipioDao;

	public List<Municipio> listar() throws PersistenciaException {
		return municipioDao.listar();
	}
	

}