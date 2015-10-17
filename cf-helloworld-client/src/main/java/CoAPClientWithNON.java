
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
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

public class CoAPClientWithNON {
	
	public static void main(String args[]) throws IOException, SQLException, InterruptedException 
	{
		while(true)
		{
		 Request request=new Request(Code.PUT);
  		 request.setURI("coap://coap.me:5683/sink?mode=on");
		 request.send().setConfirmable(false);
		 Response response;
		 response = request.waitForResponse();
	     //response.setType(Type.NON);
	     System.out.println("YOU REQUESTED FOR PUT Request-1 METHOD");
	    	System.out.println(response.getPayloadString());
			Thread.sleep(5000);
	    
			System.out.println("YOU REQUESTED FOR PUT Request-2 METHOD");
			request=new Request(Code.PUT);
			 request.setURI("coap://coap.me:5683/sink?mode=off");
			 request.send().setConfirmable(false);
			 
			 response = request.waitForResponse();
			// response.setType(Type.NON);
			
			 System.out.println(response.getPayloadString());
			 Thread.sleep(5000);
		
	}

	}

}
