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

import br.com.fiap.bo.PlantacaoBO;
import br.com.fiap.to.PlantacaoTO;

@Path("/plantacao")
public class PlantacaoResource {

	PlantacaoBO plantacaobo = new PlantacaoBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PlantacaoTO> buscarPlantacoes() {
		return plantacaobo.exibirDadosPlantacao();
	}

	@GET
	@Path("/{codPlantacao}")
	@Produces(MediaType.APPLICATION_JSON)
	public PlantacaoTO buscar(@PathParam("codPlantacao") int codPlantacao) {
		return plantacaobo.exibirDadosPlantacaoId(codPlantacao);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(PlantacaoTO plantacao, @Context UriInfo uriInfo) throws SQLException {

		// INSERIR NA BASE
		plantacaobo.inserirPlantacao(plantacao);

		// CONSTRUIR O PATH DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(plantacao.getCodPlantacao()));

		// RETORNA O PATH E O STATUS 201
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{codPlantacao}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(PlantacaoTO plantacao, @PathParam("codPlantacao") int codPlantacao) throws SQLException {
		plantacao.setCodPlantacao(codPlantacao);
		plantacaobo.atualizarPlantacao(plantacao);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{codPlantacao}")
	public void excluir(@PathParam("codUsuario") int codUsuario) throws SQLException {
		plantacaobo.excluirPlantacao(codUsuario);
	}

}
