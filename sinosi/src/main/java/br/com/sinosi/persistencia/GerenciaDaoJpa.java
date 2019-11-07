package br.com.sinosi.persistencia;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.util.UtilLog;
import br.com.sinosi.entidade.Gerencia;

@Repository("gerenciaDao")
public class GerenciaDaoJpa extends PersistenciaJpa<Gerencia> implements GerenciaDao {

	private static final long serialVersionUID = 1L;

	public List<Gerencia> listarPorDescricao(String descricao ) throws PersistenciaException {
        try {
        	String sql = "select distinct g from Gerencia G where 1=1 ";

            if(descricao != null && !descricao.isEmpty()){
                sql += " and upper(i.descricao) like upper(:descricao)";
            }
            sql += " order by g.descricao";

            TypedQuery<Gerencia> query = em.createQuery(sql, Gerencia.class);

            if(descricao != null && !descricao.isEmpty()){
                query.setParameter("descricao", "%" + descricao + "%");
            }

            return query.getResultList();

        	

        } catch (Exception e) {
            UtilLog.getLog().error(e.getMessage(), e);
            throw new PersistenciaException("Erro ao listar Gerencias por descrição.", e);
        }
    }

}