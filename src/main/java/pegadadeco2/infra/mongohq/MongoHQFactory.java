package pegadadeco2.infra.mongohq;

import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

public class MongoHQFactory {
	
	private static DB db = null;
	
	private MongoHQFactory() {
	}

	public static DB connect() {
		
		if(db == null) {
			db = connectToMongoHQ();
			return db;
		}
		else {
			System.out.println("Using an existing MongoHQ connection");
			return db;
		}
	}
	
	private static DB connectToMongoHQ() {
		
		System.out.println("Connecting to MongoDB...");

		MongoURI mongoURI = new MongoURI("mongodb://root:root@staff.mongohq.com:10027/emissao");
        DB db = null;
        
		try {
			db = mongoURI.connectDB();
			
		} catch (MongoException e) {
			e.printStackTrace();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
        db.authenticate(mongoURI.getUsername(), mongoURI.getPassword());

        Set<String> colls = db.getCollectionNames();
        System.out.println("Collections found in DB: " + colls.toString());
        
        return db;
	}

	public static void main(String[] args) {
		MongoHQFactory.connect();
		MongoHQFactory.connect();
		MongoHQFactory.connect();
	}
}
