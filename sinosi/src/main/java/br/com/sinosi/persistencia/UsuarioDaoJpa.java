package br.com.sinosi.persistencia;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.util.UtilLog;
import br.com.sinosi.entidade.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoJpa extends PersistenciaJpa<Usuario> implements UsuarioDao{

    private static final long serialVersionUID = 1L;

    @Override
    public List<Usuario> listarPorNome(String nome) throws PersistenciaException {
        try {
            String sql = "select distinct u from Usuario u where 1=1 ";

            if(nome != null && !nome.isEmpty()){
                sql += " and upper(u.nome) like upper(:nome)";
            }

            TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);

            if(nome != null && !nome.isEmpty()){
                query.setParameter("nome", "%" + nome + "%");
            }

            return query.getResultList();

        } catch (Exception e) {
            UtilLog.getLog().error(e.getMessage(), e);
            throw new PersistenciaException("Erro ao listar usuários", e);
        }
    }

    @Override
    public Usuario consultarPorCpfSemValidacao(String cpf) throws PersistenciaException {
        try {
            TypedQuery<Usuario> query = em.createQuery("select distinct u from Usuario u where u.cpf = :cpf", Usuario.class);
            query.setParameter("cpf", cpf);
            return query.getSingleResult();
        } catch (NoResultException ne) {
            return null;
        } catch (Exception e) {
            UtilLog.getLog().error(e.getMessage(), e);
            throw new PersistenciaException("Erro ao consultar usuário por CPF.", e);
        }
    }

}
