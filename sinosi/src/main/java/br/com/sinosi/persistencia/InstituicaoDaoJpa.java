package br.com.sinosi.persistencia;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.util.UtilLog;
import br.com.sinosi.entidade.Instituicao;

@Repository("InstituicaoDao")
public class InstituicaoDaoJpa extends PersistenciaJpa<Instituicao> implements InstituicaoDao{

    private static final long serialVersionUID = 1L;

    @Override
    public List<Instituicao> listarPorNome(String nome) throws PersistenciaException {
        try {
            String sql = "select distinct i from Instituicao i where 1=1 ";

            if(nome != null && !nome.isEmpty()){
                sql += " and upper(i.nome) like upper(:nome)";
            }

            TypedQuery<Instituicao> query = em.createQuery(sql, Instituicao.class);

            if(nome != null && !nome.isEmpty()){
                query.setParameter("nome", "%" + nome + "%");
            }

            return query.getResultList();

        } catch (Exception e) {
            UtilLog.getLog().error(e.getMessage(), e);
            throw new PersistenciaException("Erro ao listar instituições", e);
        }
    }

}
