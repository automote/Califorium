package org.eclipse.californium.examples;

import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.Code;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.LinkFormat;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.network.CoAPEndpoint;
import org.eclipse.californium.core.server.ServerInterface;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.core.server.resources.Resource;
import org.eclipse.californium.core.server.resources.ResourceAttributes;
import org.eclipse.californium.core.test.ResourceTreeTest;


/*import org.eclipse.californium.elements.*;*/
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;


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
            
        	
            //create server SHANKAR
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
            ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
            
            //Get the URLs
            URL[] urls = ((URLClassLoader)sysClassLoader).getURLs();
     
            for(int i=0; i< urls.length; i++)
            {
                System.out.println(urls[i].getFile());
            }          
            
            
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
        
        add(new Light());
       
    
    }
    
    
	

	/*
     * Definition of the Hello-World Resource
     */
    class HelloWorldResource extends CoapResource
    {
        
        private static final String rt = "Shankar";


		public HelloWorldResource() {
            
            // set resource identifier
            super("Shankar");
            
            
            
            // set display name
            getAttributes().addContentType(getObserverCount());
            getAttributes().addResourceType(rt);
            getAttributes().setTitle("Hello-World Resource");
            
         }
        	    
        
        @Override
        public void handleGET(CoapExchange exchange) {
            
            // respond to the request
            exchange.respond("Hi HomeAutomation Team \n I Created One resource and changed the port no to 5683\nCHANGED");
  
           System.out.println(exchange.getSourceAddress());
        }
        @Override
        public void handlePOST(CoapExchange exchange){
        	
            
           exchange.accept();
           exchange.advanced();
           InetAddress test= exchange.getSourceAddress();
           Code grc=exchange.getRequestCode();
           OptionSet are= exchange.getRequestOptions();
          try
          {
          byte[] arr=exchange.getRequestPayload();
          String resourceid="";
          for(int i=0;i<arr.length;i++)
          {
        	  resourceid += (char) arr[i];
          }
          
          FileWriter fw=new FileWriter("C:\\receivedresponse.txt",true);
          BufferedWriter bw=new BufferedWriter(fw);
			bw.write(resourceid); 
			bw.newLine();
			bw.close();
         
          exchange.respond(CoAP.ResponseCode.CREATED, "Hai");
          System.out.println(test);
          System.out.println(grc+"\n"+are);
            
           // exchange.respond("Post Request Received"); 
          }
          catch(IOException ioe)
          {
        	  
          }
        } 
        
        
        @Override
        public void handlePUT(CoapExchange exchange){
            
            exchange.accept();
            
            String putres= exchange.getRequestText();
            System.out.println(putres);
            System.out.print(putres);
            String xyz1="Xyz";
            String iot1="IOT";
            int xyz=putres.compareTo(xyz1);
            int iot=putres.compareTo(iot1);
            if(xyz==0)
            {
                   this.add(new Xyz());
                   exchange.respond(CoAP.ResponseCode.CHANGED,"Xyz Resource Created");
            }
            else if(iot==0)
            {
            	this.add(new IOT());
            	exchange.respond(CoAP.ResponseCode.CHANGED,"IOT Resource Created");
            }
            else
            {
            	exchange.respond(CoAP.ResponseCode.BAD_REQUEST,"Undefined Resources Requested");
            }
            
        }
    }
        
    
    class IOT extends CoapResource
    {

		public IOT() {
			super("IOT");
			// TODO Auto-generated constructor stub
		}
		 @Override
	        public void handleGET(CoapExchange exchange) {
	            
	            // respond to the request
	            exchange.respond("Created IOT Resource");
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
		 
		
		}
    
}

class Light extends CoapResource
{
	public Light() {
		super("Light");
		// TODO Auto-generated constructor stub
		getAttributes().setTitle("Light_Status");
	}
	@Override
	public void handleGET(CoapExchange exchange) {
		
    
          exchange.respond("You will receive status of LIGHT ");
	}
}
	
	/*class Resource_Discovery extends CoapResource
	{
		private static final int APPLICATION_LINK_FORMAT = 0;
		public Resource_Discovery()
		{
			super("Resource_Discovery");
			//getAttributes().getTitle();	
			getAttributes().setTitle("Resource_Discovery");
			getAttributes().addContentType(APPLICATION_LINK_FORMAT);
		getAttributes().setObservable();	
		
		}
		@Override
		public void handleGET(CoapExchange exchange) 
		{
			exchange.respond(LinkFormat.serializeTree(this));
		}
		
		}*/

 class DiscoveryResource extends CoapResource {

	/** The Constant CORE. */
	public static final String CORE = "core";
	
	/** The root of the server's resource tree */
	private final Resource root;
	
	/**
	 * Instantiates a new discovery resource.
	 *
	 * @param root the root resource of the server
	 */
	public DiscoveryResource(Resource root) {
		this(CORE, root);
	}
	
	/**
	 * Instantiates a new discovery resource with the specified name.
	 *
	 * @param name the name
	 * @param root the root resource of the server
	 */
	public DiscoveryResource(String name, Resource root) {
		super(name);
		this.root = root;
	}
	
	/**
	 * Responds with a list of all resources of the server, i.e. links.
	 * 
	 * @param exchange the exchange
	 */
	@Override
	public void handleGET(CoapExchange exchange) {
		String tree = discoverTree(root, exchange.getRequestOptions().getUriQuery());
		exchange.respond(ResponseCode.CONTENT, tree, MediaTypeRegistry.APPLICATION_LINK_FORMAT);
		System.out.println(tree);
	}
	
	/**
	 * Builds up the list of resources of the specified root resource. Queries
	 * serve as filter and might prevent undesired resources from appearing on
	 * the list.
	 * 
	 * @param root the root resource of the server
	 * @param queries the queries
	 * @return the list of resources as string
	 */
	public String discoverTree(Resource root, List<String> queries) {
		StringBuilder buffer = new StringBuilder();
		for (Resource child:root.getChildren()) {
			LinkFormat.serializeTree(child, queries, buffer);
		}
		
		// remove last comma ',' of the buffer
		if (buffer.length()>1)
			buffer.delete(buffer.length()-1, buffer.length());
		
		return buffer.toString();
	}
}
	
	
	
	
	





