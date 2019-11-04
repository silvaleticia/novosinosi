package br.com.sinosi.servico;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.sinosi.entidade.Denuncia;
import br.com.sinosi.persistencia.DenunciaDao;

@Service
public class DenunciaServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private DenunciaDao denunciaDao;

	public List<Denuncia> listar() throws PersistenciaException {
		return denunciaDao.listar();
	}

	public Denuncia consultar(Integer id) throws PersistenciaException {
		return denunciaDao.consultarPorId(id);
	}
	
	public void inserir(Denuncia denuncia) throws PersistenciaException {
		 denunciaDao.incluir(denuncia);
	}
	
	

}