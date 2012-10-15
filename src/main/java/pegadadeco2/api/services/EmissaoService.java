package pegadadeco2.api.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import pegadadeco2.dominio.emissao.RepositorioDeEmissao;

@Path("/emissao")
@Produces(MediaType.APPLICATION_JSON)
public class EmissaoService {

    @GET
    @Path("/{cep}")
    public String obetEmissaoDeCarbono(@PathParam("cep") String cep) throws JSONException {
    	
    	RepositorioDeEmissao repositorio = new RepositorioDeEmissao();
    	String emissao = repositorio.obterEmissao(cep);
    	
    	if(emissao == null) {
    		JSONObject jsonNotFound = new JSONObject();
    		jsonNotFound.put("mensagem", "Não foram encontrados resultados para o cep '" + cep + "'");
    		return jsonNotFound.toString();
    	}
        return emissao;
    }

}

