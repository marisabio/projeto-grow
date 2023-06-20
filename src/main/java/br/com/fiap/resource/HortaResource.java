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

import br.com.fiap.bo.HortaBO;
import br.com.fiap.to.HortaTO;

@Path("/horta")
public class HortaResource {

	HortaBO hortabo = new HortaBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<HortaTO> buscarUsuarios() {
		return hortabo.exibirDadosHorta();
	}

	@GET
	@Path("/{codHorta}")
	@Produces(MediaType.APPLICATION_JSON)
	public HortaTO buscar(@PathParam("codHorta") int codHorta) {
		return hortabo.exibirDadosHortaId(codHorta);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(HortaTO horta, @Context UriInfo uriInfo) throws SQLException {

		// INSERIR NA BASE
		hortabo.inserirHorta(horta);

		// CONSTRUIR O PATH DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(horta.getCodHorta()));

		// RETORNA O PATH E O STATUS 201
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{codHorta}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(HortaTO horta, @PathParam("codHorta") int codHorta) throws SQLException {
		horta.setCodHorta(codHorta);
		hortabo.atualizarHorta(horta);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{codHorta}")
	public void excluir(@PathParam("codHorta") int codHorta) throws SQLException {
		hortabo.excluirHorta(codHorta);
	}

}
