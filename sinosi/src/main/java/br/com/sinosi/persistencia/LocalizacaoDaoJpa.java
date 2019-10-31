package br.com.sinosi.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.sinosi.entidade.LocalizacaoAcidente;

@Repository("localizacaoDao")
public class LocalizacaoDaoJpa extends PersistenciaJpa<LocalizacaoAcidente> implements LocalizacaoDao{

    private static final long serialVersionUID = 1L;

}
