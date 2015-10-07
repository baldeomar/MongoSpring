package com.oumar.learn.mongoUtils;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

public class Connector {

	private static final String MONGO_HOST = "localhost";
	private static final int MONGO_PORT = 27017;
    
    private MongoClient client;
    
    private Connector() {
    	try {
			client = new MongoClient(MONGO_HOST, MONGO_PORT);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
    }
    
    private static Connector INSTANCE = null;
    
    public static Connector getConnector(){
    	if(INSTANCE == null){
    		synchronized (Connector.class) {
				if(INSTANCE == null){
					INSTANCE = new Connector();
				}
			}
    	}
    	return INSTANCE;
    }
    
    public MongoClient getMongoClient(){
    	return client;
    }
}
