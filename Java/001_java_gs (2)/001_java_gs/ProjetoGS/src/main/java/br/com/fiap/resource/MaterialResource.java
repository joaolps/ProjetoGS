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

import br.com.fiap.beans.Material;
import br.com.fiap.bo.MaterialBO;

@Path("/material")
public class MaterialResource {

	private MaterialBO materialBO = new MaterialBO();

	// Selecionar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Material> selecionarRs() throws ClassNotFoundException, SQLException {
		return (ArrayList<Material>) materialBO.selecionarBo();
	}

	// Inserir
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(Material material, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {

		materialBO.inserirBo(material);

		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(material.getIdMaterial()));
		return Response.created(builder.build()).build();
	}

	// Atualizar
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id_material}")
	public Response atualizarRs(Material material, @PathParam("id_material") int idMaterial)
			throws ClassNotFoundException, SQLException {
		material.setIdMaterial(idMaterial);
		materialBO.atualizarBo(material);

		return Response.ok().build();
	}

	// Deletar
	@DELETE
	@Path("/{id_material}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("id_material") int idMaterial) throws ClassNotFoundException, SQLException {

		materialBO.deletarBo(idMaterial);
		return Response.ok().build();
	}
}
