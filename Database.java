
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
        public static void main(String[] args) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                MongoDatabase database = mongoClient.getDatabase("company");
                MongoCollection<Document> coll =  database.getCollection("users");

                Logger logger = Logger.getLogger("org.mongodb");
                coll.drop();


                Document doc = new Document("name", "Janko Dnesny").append("age", 15).append("status", "married");

                coll.insertOne(doc);



                List<Document>arraylist = new ArrayList<>();

                Document doc2 = new Document("name", "Zdenka Zadna").append("age", 65).append("status", "single");
                arraylist.add(doc2);

                Document doc3 = new Document("name", "Jakub Nespal").append("age", 28).append("status", "divorced");
                arraylist.add(doc3);


                Document doc4 = new Document("name", "Otto Palec").append("age", 22).append("status", "single");
                arraylist.add(doc4);

                Document doc5 = new Document("name", "František Buchsanto").append("age", 34).append("status", "married");
                arraylist.add(doc5);


                Document deletedperson = new Document("name", "Branislav Bežný").append("age", 19).append("status", "single");


                coll.insertMany(arraylist);


                BasicDBObject delperson = new BasicDBObject();
                delperson.put("name","Branislav Bežný");
                coll.deleteOne(delperson);

                Bson beforeupdate = doc;
                Bson afterupdate = new Document("name","Janko Zajtrajsi");
                Bson update = new Document("$set","afterupdate");
               //coll.updateOne(beforeupdate,update)       ;

        }


}
