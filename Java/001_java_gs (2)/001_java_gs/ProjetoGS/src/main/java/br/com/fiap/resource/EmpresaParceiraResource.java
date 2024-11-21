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

import br.com.fiap.beans.EmpresaParceira;
import br.com.fiap.bo.EmpresaParceiraBO;

@Path("/empresa-parceira")
public class EmpresaParceiraResource {

	private EmpresaParceiraBO empresaParceiraBO = new EmpresaParceiraBO();

	// Selecionar todas as empresas parceiras
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<EmpresaParceira> selecionarRs() throws ClassNotFoundException, SQLException {
		return empresaParceiraBO.selecionarBo();
	}

	// Inserir uma nova empresa parceira
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(EmpresaParceira empresaParceira, @Context UriInfo uriInfo)
			throws ClassNotFoundException, SQLException {
		empresaParceiraBO.inserirBo(empresaParceira);

		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(empresaParceira.getIdParceiro()));
		return Response.created(builder.build()).build();
	}

	// Atualizar uma empresa parceira existente
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id_parceiro}")
	public Response atualizarRs(EmpresaParceira empresaParceira, @PathParam("id_parceiro") int idParceiro)
			throws ClassNotFoundException, SQLException {
		empresaParceira.setIdParceiro(idParceiro);
		empresaParceiraBO.atualizarBo(empresaParceira);

		return Response.ok().build();
	}

	// Deletar uma empresa parceira
	@DELETE
	@Path("/{id_parceiro}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("id_parceiro") int idParceiro) throws ClassNotFoundException, SQLException {
		empresaParceiraBO.deletarBo(idParceiro);
		return Response.ok().build();
	}
}
