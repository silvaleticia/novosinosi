package br.com.sinosi.persistencia;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.util.UtilLog;
import br.com.sinosi.entidade.EnumUf;
import br.com.sinosi.entidade.Municipio;

@Repository("municipioDao")
public class MunicipioDaoJpa extends PersistenciaJpa<Municipio> implements MunicipioDao{

    private static final long serialVersionUID = 1L;

    @Override
    public List<Municipio> listarPorUfDescricaoDescentralizacao(EnumUf uf, String descricao, Boolean descentralizado) throws PersistenciaException {
        try {
            String sql = "select distinct m from Municipio m where m.uf = :uf";

            if(descentralizado != null){
                sql += " and m.descentralizado is :descentralizado";
            }
            if(descricao != null && !descricao.isEmpty()){
                sql += " and upper(m.descricao) like upper(:descricao)";
            }

            sql += " order by m.descricao";

            TypedQuery<Municipio> query = em.createQuery(sql, Municipio.class);

            query.setParameter("uf", uf);
            if(descentralizado != null){
                query.setParameter("descentralizado",descentralizado);
            }
            if(descricao != null && !descricao.isEmpty()){
                query.setParameter("descricao", "%" + descricao + "%");
            }
            return query.getResultList();
        }catch (Exception e) {
            UtilLog.getLog().error(e.getMessage(), e);
            throw new PersistenciaException("Erro ao listar municípios", e);
        }
    }

    @Override
    public List<Municipio> listarPorUfNome(EnumUf uf, String descricao) throws PersistenciaException {
        try {
            String sql = "select distinct m from Municipio m where 1 = 1 ";

            if(uf != null){
                sql += " and m.uf = :uf";
            }
            if(descricao != null && !descricao.isEmpty()){
                sql += " and upper(m.descricao) like upper(:descricao)";
            }

            sql += " order by m.descricao";
            TypedQuery<Municipio> query = em.createQuery(sql, Municipio.class);

            if(uf != null){
                query.setParameter("uf", uf);
            }
            if(descricao != null && !descricao.isEmpty()){
                query.setParameter("descricao", descricao + "%");
            }
            return query.getResultList();
        }catch (Exception e) {
            UtilLog.getLog().error(e.getMessage(), e);
            throw new PersistenciaException("Erro ao listar municípios", e);
        }
    }

    @Override
    public Long consultarTotalDeMunicipios(Boolean descentralizado) throws PersistenciaException{
        try {
            String sql = "select distinct count(m) from Municipio m where 1 = 1 ";

            if(descentralizado != null){
                sql += " and m.descentralizado is :descentralizado";
            }

            TypedQuery<Long> query = em.createQuery(sql, Long.class);

            if(descentralizado != null){
                query.setParameter("descentralizado",descentralizado);
            }

            return query.getSingleResult();
        } catch (Exception e) {
            UtilLog.getLog().error(e.getMessage(), e);
            throw new PersistenciaException("Erro ao listar usuários", e);
        }
    }

    @Override
    public Municipio municipioPorCodigoIBGE(Integer codigoIbge) throws PersistenciaException {
        try {
            TypedQuery<Municipio> query = em.createQuery(
                    "select distinct m from Municipio m where m.codigoIbge = :codigoIbge", Municipio.class);
            query.setParameter("codigoIbge", codigoIbge);
            return query.getSingleResult();
        } catch (Exception e) {
            UtilLog.getLog().error(e.getMessage(), e);
            throw new PersistenciaException("Erro ao consultar município por código IBGE", e);
        }
    }
}
