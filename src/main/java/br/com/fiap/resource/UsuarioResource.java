package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.to.UsuarioTO;

@Path("/usuario")
public class UsuarioResource {

	UsuarioBO usuariobo = new UsuarioBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioTO> buscarUsuarios() {
		return usuariobo.exibirDadosUsuario();
	}
	
	@GET
	@Path("/{codUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioTO buscar(@PathParam("codUsuario") int codUsuario) {
	    return usuariobo.exibirDadosUsuarioId(codUsuario);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(UsuarioTO usuario, @Context UriInfo uriInfo) throws SQLException {

		// INSERIR NA BASE
		usuariobo.inserirUsuario(usuario);

		// CONSTRUIR O PATH DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(usuario.getCodUsuario()));

		// RETORNA O PATH E O STATUS 201
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{codUsuario}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(UsuarioTO usuario, @PathParam("codUsuario") int codUsuario) throws SQLException {
		usuario.setCodUsuario(codUsuario);
		usuariobo.atualizarUsuario(usuario);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{codUsuario}")
	public void excluir(@PathParam("codUsuario") int codUsuario) throws SQLException {
		usuariobo.excluirUsuario(codUsuario);
	}

}	