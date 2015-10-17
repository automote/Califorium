
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.Code;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;

import java.sql.*;


public class ClientPUT 
{
	public static void main(String args[]) throws IOException, SQLException, InterruptedException 
	{
		
			while(true)
			{
				CoapClient client; 
				try {
					//client = new CoapClient(new URI("coap://coap.me:5683/actuators/relay?mode=off"));
					//CoAP.Type type;
				 
				String str2="";
				
				
				//CoapResponse response = client.put(str2,1);
				Request request=new Request(Code.PUT);
				
				request.setURI("coap://coap.me:5683/test");
				 request.send();
				 Response response;
				
					response = request.waitForResponse();
				
				 response.setType(Type.NON);

				
				//response=client.put(str2,0);
				System.out.println("YOU REQUESTED FOR PUT METHOD");
				if (response!=null) {
					
					System.out.println(response.getPayloadString());
					try {
						Thread.sleep(10000);
						client = new CoapClient(new URI("coap://[aaaa::212:4b00:89ab:cdef]:5683/actuators/relay?mode=on"));
						 //response = client.put(str2,1);
						 if (response!=null) {
						 System.out.println(response.getPayloadString());
						 Thread.sleep(10000);
						 }
							else {
								System.out.println("No response received.not on ");
							}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					System.out.println("No response received.");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				}
				catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
			
		}
		
		
		
	

		
		
		
		
		
			
			
		
	
	
	
			
	
	
		
		



	
			
		
	

	
	

