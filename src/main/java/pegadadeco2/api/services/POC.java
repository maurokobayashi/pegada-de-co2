package pegadadeco2.api.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class POC {

    @GET
    @Path("/{atividade}")
    public String obterAtividade(@PathParam("atividade") String atividade) {
    	
        return "Parabéns por clicar no link. Se eu fosse legal, te daria um cupom para um '" + atividade + "'";
    }

}

