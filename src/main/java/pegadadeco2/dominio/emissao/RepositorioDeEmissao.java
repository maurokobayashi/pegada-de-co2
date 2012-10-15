package pegadadeco2.dominio.emissao;

import pegadadeco2.infra.mongohq.MongoHQFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class RepositorioDeEmissao {
	
	public String obterEmissao(String cep) {
		
		DB db = MongoHQFactory.connect();
		DBCollection collection = db.getCollection("emissao");
		
		BasicDBObject obj = new BasicDBObject("cep", cep);
		DBObject emissao = collection.findOne(obj);
		
		if(emissao == null) {
			System.out.println("Emissao not found");
			return null;
		}
		
		System.out.println("Emissao found: " + emissao.toString());
		return emissao.toString();
	}

}
