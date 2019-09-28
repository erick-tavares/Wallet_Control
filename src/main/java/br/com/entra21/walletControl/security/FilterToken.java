package br.com.entra21.walletControl.security;

import java.io.IOException;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class FilterToken implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		//Verifica se o header AUTHORIZATION existe ou não, se existe extrai o token 
		//se não aborta a requisição retornando uma NotAuthorizedException
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);		
		
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			
			throw new NotAuthorizedException("Authorization header precisa ser provido");
		}
		
		//extrai o token do header
		String token = authorizationHeader.substring("Bearer".length()).trim();
		
		//verificamos se o método é valido ou não se não for valido a requisição é abortada e retorna uma resposta com status 401 UNAUTHORIZED se for valida modificamos o o SecurityContext da request  para que quando usarmos o getUserPrincipal retorne o login do usuario 
		
		try {
			// método que verifica se o token é valido ou não 
			Claims claims = Jwts.parser().setSigningKey("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=").parseClaimsJws(token).getBody();
	
			//Caso não for valido vai retornar um objeto nulo e executar um exception
			if(claims==null)
				throw new Exception("Token inválido");
 			
		}catch (Exception e) {
			e.printStackTrace();
			//Caso o token for invalido a requisição é abortada e retorna uma resposta com status 401 UNAUTHORIZED
			requestContext.abortWith(
					Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}

}
