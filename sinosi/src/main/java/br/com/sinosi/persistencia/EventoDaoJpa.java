package br.com.sinosi.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.sinosi.entidade.Evento;

@Repository("EventoDao")
public class EventoDaoJpa extends PersistenciaJpa<Evento> implements EventoDao{

    private static final long serialVersionUID = 1L;

}
