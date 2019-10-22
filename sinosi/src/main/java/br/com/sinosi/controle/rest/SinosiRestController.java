package br.com.sinosi.controle.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.sinosi.persistencia.DenunciaDao;

@Component
@Path("sinosi")
public class SinosiRestController {

	@Autowired
	private DenunciaDao denunciaDao;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getDenuncia(@PathParam("id") int id) throws PersistenciaException {
		return Response.status(200).entity(denunciaDao.consultarPorId(id)).build();
	}

}
