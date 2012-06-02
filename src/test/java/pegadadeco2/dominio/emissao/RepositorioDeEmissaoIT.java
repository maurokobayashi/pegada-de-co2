package pegadadeco2.dominio.emissao;

import org.junit.Test;

public class RepositorioDeEmissaoIT {
	
	private RepositorioDeEmissao repositorio = new RepositorioDeEmissao();
	
	@Test
	public void shouldLookForEmissaoInMongoHQ() {
		repositorio.obterEmissao("01257000");
	}

}
