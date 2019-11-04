package br.com.sinosi.controle.rest;

import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.sinosi.servico.MunicipioServico;

@Component
@Path("/municipios")
public class MunicipioRestController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private MunicipioServico municipioServico;
	
	@GET
	@Produces("application/json")
	public Response getMunicipio() throws PersistenciaException {
		return Response.status(200).entity(municipioServico.listar()).build();
	}

}
