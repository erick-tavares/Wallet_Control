package br.com.entra21.walletControl.controller;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.entra21.walletControl.dao.LoginDAO;
import br.com.entra21.walletControl.model.Usuario;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@SuppressWarnings("deprecation")
@Path("login/")
public class LoginController {
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("autenticar/")
	public LoginResponse auth(Usuario usuario) throws WebApplicationException {
		try {

			if (usuario.getEmail() == null || usuario.getSenha() == null) {
				throw new WebApplicationException("Login e senha obrigatorios");
			}
			LoginDAO usuAutenticar = new LoginDAO();
			Usuario usuarioAtenticado = usuAutenticar.autenticarLogin(usuario);

			if (usuarioAtenticado == null) {
				
				throw new WebApplicationException("Usuario não encontrado");
			}

			if (!usuarioAtenticado.getSenha().equals(usuario.getSenha())) {
				throw new WebApplicationException("Usuario ou senha inválido");
			}

			System.out.println(usuarioAtenticado.toString());
			
			final Date today = new Date(System.currentTimeMillis() + 60 * 1000);
	        final JwtBuilder jwtBuilder = Jwts.builder();
	        jwtBuilder.setSubject(usuarioAtenticado.getEmail()+usuarioAtenticado.getSenha());
	        jwtBuilder.setExpiration(today);
	        String token = jwtBuilder.signWith(
	        	    SignatureAlgorithm.HS256,
	        	    "Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
	        	   .compact();
			
			
			

			return new LoginResponse(token);
		} catch (Exception ex) {
			Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	private class LoginResponse {

		public String token;

		public LoginResponse(String token) {
			this.token = token;
		}
	}

}
