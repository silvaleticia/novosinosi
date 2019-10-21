package br.com.sinosi.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.sinosi.entidade.Evento;
import br.com.sinosi.persistencia.EventoDao;

@Controller("EventoControl")
@Scope("conversation")
public class EventoControl {

	@Autowired
	private EventoDao eventoDao;

	private Evento evento = new Evento();
	private Evento eventoExcluir;
	private List<Evento> eventos = new ArrayList<>();

	public void confirmar(ActionEvent evt) {
		try {
			eventoDao.validar(evento);
			eventoDao.alterar(evento);
			UtilFaces.addMensagemFaces("Evento Cadastrado com sucesso!");
			evento = new Evento();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar() {
		try {
			setEventos(eventoDao.listar());
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void excluir() {
		try {
			eventoDao.excluirPorId(eventoExcluir.getId());
			listar();
			UtilFaces.addMensagemFaces("Excluído com sucesso!");
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void editarEvento(ActionEvent evt) {
		this.evento = (Evento) UtilFaces.getValorParametro(evt, "evento");
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Evento getEventoExcluir() {
		return eventoExcluir;
	}

	public void setEventoExcluir(Evento eventoExcluir) {
		this.eventoExcluir = eventoExcluir;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

}
