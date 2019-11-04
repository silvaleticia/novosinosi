package br.com.sinosi.controle.rest;

import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.sinosi.entidade.Denuncia;
import br.com.sinosi.servico.DenunciaServico;

@Component
@Path("/denuncias")
public class DenunciaRestController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private DenunciaServico denunciaServico;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getDenuncia(@PathParam("id") int id) throws PersistenciaException {
		return Response.status(200).entity(denunciaServico.consultar(id)).build();
	}

	@GET
	@Produces("application/json")
	public Response getDenuncia() throws PersistenciaException {
		return Response.status(200).entity(denunciaServico.listar()).build();
	}

	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postDenuncia(Denuncia denuncia) throws PersistenciaException {
		denunciaServico.inserir(denuncia);
		return Response.status(201).build();
	}

}
