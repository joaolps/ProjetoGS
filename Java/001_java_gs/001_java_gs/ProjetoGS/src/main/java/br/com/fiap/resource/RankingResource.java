package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.ArrayList;

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

import br.com.fiap.beans.Ranking;
import br.com.fiap.bo.RankingBO;

@Path("/ranking")
public class RankingResource {

	private RankingBO rankingBO = new RankingBO();

	// Selecionar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Ranking> selecionarRs() throws ClassNotFoundException, SQLException {
		return (ArrayList<Ranking>) rankingBO.selecionarBo();
	}

	// Inserir
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(Ranking ranking, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {

		rankingBO.inserirBo(ranking);

		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(ranking.getIdUsuario()));
		return Response.created(builder.build()).build();
	}

	// Atualizar
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id_usuario}")
	public Response atualizarRs(Ranking ranking, @PathParam("id_usuario") int idUsuario)
			throws ClassNotFoundException, SQLException {
		ranking.setIdUsuario(idUsuario);
		rankingBO.atualizarBo(ranking);

		return Response.ok().build();
	}

	// Deletar
	@DELETE
	@Path("/{id_usuario}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("id_usuario") int idUsuario) throws ClassNotFoundException, SQLException {

		rankingBO.deletarBo(idUsuario);
		return Response.ok().build();
	}
}
