package pegadadeco2.api.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/emissao")
@Produces(MediaType.APPLICATION_JSON)
public class EmissaoService {

    @GET
    @Path("/{email}")
    public String obetEmissaoDeCarbono(@PathParam("email") String email) {
        return "Requisição atendida";
    }

}

