
package MongoConnect;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
public interface Mongo {
    public static MongoClient Connector() {
	try {	
		MongoClient c = new MongoClient(new MongoClientURI("mongodb://hanami:hanami02@ds247223.mlab.com:47223/ebook"));
		System.out.println("Connection success");
		return c;
	} 
	catch(Exception eX) {
		System.err.println("Connection error");
		eX.printStackTrace();
	}
	return null;
    }
    
}
