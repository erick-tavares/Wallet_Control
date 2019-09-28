package br.com.entra21.walletControl.controller;

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

import br.com.entra21.walletControl.dao.RendaDAO;
import br.com.entra21.walletControl.model.Renda;

@Path("rendas")
public class RendaController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Renda> listRenda() {
		try {
			RendaDAO RendaDAO = new RendaDAO();
			return RendaDAO.listar();
		} catch (Exception ex) {
			Logger.getLogger(RendaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{ID}/")
	public Renda getRenda(@PathParam("ID") long ID) {
		try {
			RendaDAO RendaDAO = new RendaDAO();
			return RendaDAO.selecionar(ID);
		} catch (Exception ex) {
			Logger.getLogger(RendaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Renda renda) {
		try {
			RendaDAO RendaDAO = new RendaDAO();
			RendaDAO.inserir(renda);

			return Response.status(Response.Status.CREATED).build();
		} catch (Exception ex) {
			Logger.getLogger(RendaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Renda renda) {
		try {
			RendaDAO RendaDAO = new RendaDAO();
			RendaDAO.alterar(renda);
			return Response.status(Response.Status.NO_CONTENT).build();
		} catch (Exception ex) {
			Logger.getLogger(RendaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("{ID}/")
	public Response delete(@PathParam("ID") long ID) {
		try {
			RendaDAO RendaDAO = new RendaDAO();
			RendaDAO.excluir(ID);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(RendaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Path("{ID}/")
	public Response concluir(@PathParam("ID") long ID) {
		try {
			RendaDAO RendaDAO = new RendaDAO();

			Renda c = RendaDAO.selecionar(ID);
		

			RendaDAO.alterar(c);
			return Response.status(Response.Status.ACCEPTED).build();
		} catch (Exception ex) {
			Logger.getLogger(RendaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}
