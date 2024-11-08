package database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnection {

    private String connectionString = "mongodb+srv://fjzamora93:********;@cluster0.phe4y.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private MongoClient mongoClient;
    public MongoDBConnection(){
        mongoClient = MongoClients.create(String.format(connectionString, DBScheme.USER, DBScheme.PASS));
    }

    public MongoCollection getAlumnosCollecion(){
        return mongoClient.getDatabase("centro_estudios").getCollection("alumnos");
    }

    public MongoCollection getProfesoresCollecion(){
        return mongoClient.getDatabase("centro_estudios").getCollection("profesores");
    }
}

//public class MongoClientConnectionExample {
//    public static void main(String[] args) {
//        String connectionString = "mongodb+srv://fjzamora93:<db_password>@cluster0.phe4y.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
//        ServerApi serverApi = ServerApi.builder()
//                .version(ServerApiVersion.V1)
//                .build();
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .applyConnectionString(new ConnectionString(connectionString))
//                .serverApi(serverApi)
//                .build();
//        // Create a new client and connect to the server
//        try (MongoClient mongoClient = MongoClients.create(settings)) {
//            try {
//                // Send a ping to confirm a successful connection
//                MongoDatabase database = mongoClient.getDatabase("admin");
//                database.runCommand(new Document("ping", 1));
//                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
//            } catch (MongoException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}