package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fiap.bo.RelatorioBO;
import br.com.fiap.to.RelatorioTO;

@Path("/relatorio")
public class RelatorioResource {
	
	RelatorioBO relatoriobo = new RelatorioBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RelatorioTO> buscarRelatorios() {
		return relatoriobo.exibirDadosRelatorio();
	}

}
