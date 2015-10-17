import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;
import java.sql.*;

public class Test {
	
	public static void main(String[] args)
	{
		
 // URI parameter of the request
		
		
			CoapClient client;
			try {
				client = new CoapClient(new URI("coap://192.168.0.100:5683/.well-known/core"));
			
        	CoapResponse response=client.get();
        	System.out.println(response.getResponseText());
        	
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


