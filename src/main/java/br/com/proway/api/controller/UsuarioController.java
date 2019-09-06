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

import br.com.proway.api.dao.UsuarioDAO;
import br.com.proway.api.model.Usuario;

@Path("usuarios")
public class UsuarioController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Usuario> listUsuarios() {
		try {
			UsuarioDAO UsuarioDAO = new UsuarioDAO();
			return UsuarioDAO.listar();
		} catch (Exception ex) {
			Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{ID}/")
	public Usuario getUsuario(@PathParam("ID") long id) {
		try {
			UsuarioDAO UsuarioDAO = new UsuarioDAO();
			return UsuarioDAO.selecionar(id);
		} catch (Exception ex) {
			Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Usuario usuario) {
		try {
			UsuarioDAO UsuarioDAO = new UsuarioDAO();
			UsuarioDAO.inserir(usuario);

			return Response.status(Response.Status.CREATED).build();
		} catch (Exception ex) {
			Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Usuario usuario) {
		try {
			UsuarioDAO UsuarioDAO = new UsuarioDAO();
			UsuarioDAO.alterar(usuario);
			return Response.status(Response.Status.NO_CONTENT).build();
		} catch (Exception ex) {
			Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("{ID}/")
	public Response delete(@PathParam("ID") long id) {
		try {
			UsuarioDAO UsuarioDAO = new UsuarioDAO();
			UsuarioDAO.excluir(id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Path("{ID}/")
	public Response concluir(@PathParam("ID") long id) {
		try {
			UsuarioDAO UsuarioDAO = new UsuarioDAO();

			Usuario c = UsuarioDAO.selecionar(id);

			UsuarioDAO.alterar(c);
			return Response.status(Response.Status.ACCEPTED).build();
		} catch (Exception ex) {
			Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}
