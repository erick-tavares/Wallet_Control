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

import br.com.proway.api.dao.DespesaDAO;
import br.com.proway.api.model.Despesa;
import br.com.proway.api.model.util.Status;

@Path("despesas")
public class DespesaController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Despesa> listDespesas() {
		try {
			DespesaDAO DespesaDAO = new DespesaDAO();
			return DespesaDAO.listar();
		} catch (Exception ex) {
			Logger.getLogger(DespesaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Despesa getDespesa(@PathParam("id") long id) {
		try {
			DespesaDAO DespesaDAO = new DespesaDAO();
			return DespesaDAO.selecionar(id);
		} catch (Exception ex) {
			Logger.getLogger(DespesaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Despesa despesa) {
		try {
			DespesaDAO DespesaDAO = new DespesaDAO();
			DespesaDAO.inserir(despesa);

			return Response.status(Response.Status.CREATED).build();
		} catch (Exception ex) {
			Logger.getLogger(DespesaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Despesa despesa) {
		try {
			despesa.setStatus(Status.PENDENTE);

			DespesaDAO DespesaDAO = new DespesaDAO();
			DespesaDAO.alterar(despesa);
			return Response.status(Response.Status.NO_CONTENT).build();
		} catch (Exception ex) {
			Logger.getLogger(DespesaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("{id}/")
	public Response delete(@PathParam("id") long id) {
		try {
			DespesaDAO DespesaDAO = new DespesaDAO();
			DespesaDAO.excluir(id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(DespesaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Path("{id}/")
	public Response concluir(@PathParam("id") long id) {
		try {
			DespesaDAO DespesaDAO = new DespesaDAO();

			Despesa d = DespesaDAO.selecionar(id);
			
			DespesaDAO.alterar(d);
			return Response.status(Response.Status.ACCEPTED).build();
		} catch (Exception ex) {
			Logger.getLogger(DespesaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}
