package br.com.sinosi.persistencia;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.util.UtilLog;
import br.com.sinosi.entidade.Denuncia;
import br.com.sinosi.entidade.EnumUf;
import br.com.sinosi.entidade.Municipio;

@Repository("denunciaDao")
public class DenunciaDaoJpa extends PersistenciaJpa<Denuncia> implements DenunciaDao {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Denuncia> listarPorUfMunicipioDataSolicitacao(EnumUf uf, Municipio municipio, Date dataInicio,
			Date dataFim) throws PersistenciaException {
		try {

			String sql = "select distinct d from Denuncia d where 1=1";

			if (uf != null) {
				sql += " and c.localAcidente.municipio.uf = :uf";
			}
			if (municipio != null) {
				sql += " and c.localAcidente.municipio = :municipio";
			}
			if (dataInicio != null && dataFim != null) {
				sql += " and c.dataDaDenuncia between :dataInicio and :dataFim";
			}
			TypedQuery<Denuncia> query = em.createQuery(sql, Denuncia.class);

			if (uf != null) {
				query.setParameter("uf", uf);
			}
			if (municipio != null) {
				query.setParameter("municipio", municipio);
			}
			if (dataInicio != null && dataFim != null) {
				query.setParameter("dataInicio", dataInicio);
				query.setParameter("dataFim", dataFim);
			}

			return query.getResultList();

		} catch (Exception e) {
			UtilLog.getLog().error(e.getMessage(), e);
			throw new PersistenciaException("Erro ao listar Denuncias", e);
		}
	}

	public Denuncia consultarPorId(Integer id) throws PersistenciaException {
		try {
			TypedQuery<Denuncia> query = em.createQuery("select distinct d from Denuncia d where d.id = :id",
					Denuncia.class);
			query.setParameter("id", id);
			return query.getSingleResult();
		} catch (NoResultException ne) {
			return null;
		} catch (Exception e) {
			UtilLog.getLog().error(e.getMessage(), e);
			throw new PersistenciaException("Erro ao consultar Denuncia", e);
		}
	}

}
