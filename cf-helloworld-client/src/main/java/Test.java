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
	
	public static void main(String[] args) throws IOException
	{
		InputStream is = null;
		int i;
		char c;
 // URI parameter of the request
		
		try
		{
 				
					is = new FileInputStream("C:\\status.txt");
					
        		    while((i=is.read())!=-1)
					{
						
						c=(char)i;
            			System.out.print(c);
						
					}
					if((i=is.read())==-1)
					{
						PrintWriter out = new PrintWriter("C:\\status.txt");
						out.print("SANKAR");
						out.close();
						//new FileOutputStream("C:\\status.txt").close();
					}
					
				Thread.sleep(500);
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
       			if(is!=null)
			is.close();
		}	
		
	}
}


