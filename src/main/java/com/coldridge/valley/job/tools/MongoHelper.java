package com.coldridge.valley.job.tools;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Administrator on 2016/3/26.
 */

public class MongoHelper {


    @Value("${mongo.host}")
    private static String host = "192.168.1.156";
    @Value("${mongo.port}")
    private static int port = 27017;

    private MongoClient client;

    private String dbName;
    private String collectionName;

    public MongoHelper(String dbName, String collectionName) {
        client = new MongoClient(host, port);
        this.dbName =dbName;
        this.collectionName=collectionName;
    }

    public FindIterable<Document> query() {
        MongoDatabase database = client.getDatabase(dbName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        FindIterable<Document> documents = collection.find();
        return documents;
    }
}
