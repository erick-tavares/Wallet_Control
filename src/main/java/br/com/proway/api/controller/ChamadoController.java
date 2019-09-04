package br.com.proway.api.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.proway.api.dao.ChamadoDAO;
import br.com.proway.api.model.Chamado;
import br.com.proway.api.model.util.Status;

@Path("chamados")
public class ChamadoController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Chamado> listChamados() {
		try {
			ChamadoDAO ChamadoDAO = new ChamadoDAO();
			return ChamadoDAO.listar();
		} catch (Exception ex) {
			Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Chamado getChamado(@PathParam("id") long id) {
		try {
			ChamadoDAO ChamadoDAO = new ChamadoDAO();
			return ChamadoDAO.selecionar(id);
		} catch (Exception ex) {
			Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Chamado chamado) {
		try {
			ChamadoDAO ChamadoDAO = new ChamadoDAO();
			ChamadoDAO.inserir(chamado);

			return Response.status(Response.Status.CREATED).build();
		} catch (Exception ex) {
			Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Chamado chamado) {
		try {
			chamado.setStatus(Status.PENDENTE);

			ChamadoDAO ChamadoDAO = new ChamadoDAO();
			ChamadoDAO.alterar(chamado);
			return Response.status(Response.Status.NO_CONTENT).build();
		} catch (Exception ex) {
			Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("{id}/")
	public Response delete(@PathParam("id") long id) {
		try {
			ChamadoDAO ChamadoDAO = new ChamadoDAO();
			ChamadoDAO.excluir(id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Path("{id}/")
	public Response concluir(@PathParam("id") long id) {
		try {
			ChamadoDAO ChamadoDAO = new ChamadoDAO();

			Chamado c = ChamadoDAO.selecionar(id);
			c.setStatus(Status.FECHADO);

			ChamadoDAO.alterar(c);
			return Response.status(Response.Status.ACCEPTED).build();
		} catch (Exception ex) {
			Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}
