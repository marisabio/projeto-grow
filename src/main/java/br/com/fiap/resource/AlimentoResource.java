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

import br.com.fiap.bo.AlimentoBO;
import br.com.fiap.to.AlimentoTO;

@Path("/alimento")
public class AlimentoResource {
	
AlimentoBO alimentobo = new AlimentoBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AlimentoTO> buscarAlimentos() {
		return alimentobo.exibirDadosAlimento();
	}
	
	@GET
	@Path("/{codAlimento}")
	@Produces(MediaType.APPLICATION_JSON)
	public AlimentoTO buscar(@PathParam("codAlimento") int codAlimento) {
	    return alimentobo.exibirDadosAlimentoId(codAlimento);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(AlimentoTO alimento, @Context UriInfo uriInfo) throws SQLException {

		// INSERIR NA BASE
		alimentobo.inserirAlimento(alimento);

		// CONSTRUIR O PATH DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(alimento.getCodAlimento()));

		// RETORNA O PATH E O STATUS 201
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{codAlimento}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(AlimentoTO alimento, @PathParam("codAlimento") int codAlimento) throws SQLException {
		alimento.setCodAlimento(codAlimento);
		alimentobo.atualizarAlimento(alimento);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{codAlimento}")
	public void excluir(@PathParam("codUsuario") int codAlimento) throws SQLException {
		alimentobo.excluirAlimento(codAlimento);
	}

}
