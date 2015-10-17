package org.eclipse.californium.examples;

import java.io.File;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.Code;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.network.CoAPEndpoint;
import org.eclipse.californium.core.server.resources.CoapExchange;


public class HelloWorldServer extends CoapServer {
    
    /*
     * Application entry point.
     * 
     */
	
	public static final String path = null;
	//private static final int port = NetworkConfig.getStandard().getInt(NetworkConfig.Keys.COAP_PORT);
    static int port=5683;
    public static void main(String[] args) {
        
        try {
            
        	
            //create server
            CoapServer server = new HelloWorldServer();
            server.addEndpoint(new CoAPEndpoint(new InetSocketAddress(port)));
           //server.bind();
            server.start();
            /*
            for (Endpoint ep:server.getEndpoints()) {
            	ep.addInterceptor(new MessageTracer());
            	// Eclipse IoT metrics
            	ep.addInterceptor(new OriginTracer());
            	System.out.println("Trace in for loop:" + ep.toString());
            }
            */
            System.out.println(HelloWorldServer.class.getSimpleName()+" listening on port " + port);
              
            
            
        } catch (SocketException e) {
            
            System.err.println("Failed to initialize server: " + e.getMessage());
        }
    }
    
    /*
     * Constructor for a new Hello-World server. Here, the resources
     * of the server are initialized.
     */
    public HelloWorldServer() throws SocketException {
        
        // provide an instance of a Hello-World resource
        add(new HelloWorldResource());
        add(new Xyz());
        
    }
    
    
	

	/*
     * Definition of the Hello-World Resource
     */
    class HelloWorldResource extends CoapResource {
        
        public HelloWorldResource() {
            
            // set resource identifier
            super("Shankar");
            
            
            
            // set display name
            getAttributes().setTitle("Hello-World Resource");
         }
        	    
        
        @Override
        public void handleGET(CoapExchange exchange) {
            
            // respond to the request
            exchange.respond("Hi HomeAutomation Team \n I Created One resource and changed the port no to 5683");
        }
        @Override
        public void handlePOST(CoapExchange exchange){
        	
            
           exchange.accept();
           exchange.advanced();
           
            InetAddress test= exchange.getSourceAddress();
            Code grc=exchange.getRequestCode();
          OptionSet are= exchange.getRequestOptions();
          
          File file = new File("test.txt");
          String absolutePath = file.getAbsolutePath();
         // System.out.println(absolutePath);
          //exchange.setLocationPath();
          //exchange.setLocationQuery(absolutePath);
         
          exchange.respond(CoAP.ResponseCode.CREATED, absolutePath);
          System.out.println(test);
          System.out.println(grc+"\n"+are);
            
           // exchange.respond("Post Request Received"); 
        } 
        
        
        @Override
        public void handlePUT(CoapExchange exchange){
            
            exchange.accept();
            exchange.respond("PUT Request Received"); 
        }       
        
        
        
    }
    class Xyz extends CoapResource
    {

		public Xyz() {
			super("Xyz");
			// TODO Auto-generated constructor stub
		}
		 @Override
	        public void handleGET(CoapExchange exchange) {
	            
	            // respond to the request
	            exchange.respond("Getting Payload from Xyz Resource");
	        }
		 public void handleDelete(CoapExchange exchange) {
			 
		 }
		}
}