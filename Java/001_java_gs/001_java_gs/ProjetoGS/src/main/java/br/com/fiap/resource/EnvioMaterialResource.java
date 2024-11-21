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

import br.com.fiap.beans.EnvioMaterial;
import br.com.fiap.bo.EnvioMaterialBO;

@Path("/envio-material")
public class EnvioMaterialResource {

	private EnvioMaterialBO envioMaterialBO = new EnvioMaterialBO();

	// Selecionar todos os envios
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<EnvioMaterial> selecionarRs() throws ClassNotFoundException, SQLException {
		return envioMaterialBO.selecionarBo();
	}

	// Inserir um novo envio
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(EnvioMaterial envioMaterial, @Context UriInfo uriInfo)
			throws ClassNotFoundException, SQLException {
		envioMaterialBO.inserirBo(envioMaterial);

		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(envioMaterial.getIdEnvio()));
		return Response.created(builder.build()).build();
	}

	// Atualizar um envio existente
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id_envio}")
	public Response atualizarRs(EnvioMaterial envioMaterial, @PathParam("id_envio") int idEnvio)
			throws ClassNotFoundException, SQLException {
		envioMaterial.setIdEnvio(idEnvio);
		envioMaterialBO.atualizarBo(envioMaterial);

		return Response.ok().build();
	}

	// Deletar um envio
	@DELETE
	@Path("/{id_envio}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("id_envio") int idEnvio) throws ClassNotFoundException, SQLException {
		envioMaterialBO.deletarBo(idEnvio);
		return Response.ok().build();
	}
}
