

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpRPLBRDiscovery {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		HttpRPLBRDiscovery http = new HttpRPLBRDiscovery();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();
	}


	private void sendGet() throws Exception {

		String url = "http://[aaaa::212:7400:137e:6fa4]";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		
		//con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		
		//System.out.println(response.toString());
		
		final Pattern TAG_REGEX = Pattern.compile("<pre>(aaaa....................)");
		String ServerIPAddress=response.toString();
		//String ServerIPAddress= "<html><head><title>ContikiRPL</title></head><body>Neighbors<pre></pre>Routes<pre>aaaa::212:4b00:89ab:cdef</pre><pre>aaaa::212:4b00:89ab:efgh</pre><pre>aaaa::212:4b00:89ab:defg</pre><pre>fe80::212:4b00:89ab:cdef</pre></body></html>";
		final List<String> tagValues = new ArrayList<String>();
	    final Matcher matcher = TAG_REGEX.matcher(ServerIPAddress);
	     
	    while (matcher.find()) {
	        tagValues.add(matcher.group(1));
	    }

	for(String s:tagValues)
	{ 
		
		System.out.println("coap://["+s+"]/128:5683");
			
	}
		

	}
	
	
	


}