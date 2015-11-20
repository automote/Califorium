import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;

public class RegExp
{	
	public static void main(String[] args) {

	    final String str = "<html><head><title>ContikiRPL</title></head><body>Neighbors<pre>fe80::212:4b00:89ab:cdef</pre>Routes<pre>aaaa::212:4b00:89ab:cdef/128 (via fe80::212:4b00:89ab:cdef) 16711358s</pre></body></html>";
	   String s1=Arrays.toString(getTagValues(str).toArray());
		
	}

	private static final Pattern TAG_REGEX = Pattern.compile("<pre>(aaaa....................)");
	

	private static List<String> getTagValues(final String str) 
	{
	    final List<String> tagValues = new ArrayList<String>();
	    final Matcher matcher = TAG_REGEX.matcher(str);
	     
	    while (matcher.find()) {
	        tagValues.add(matcher.group(1));
	    }

	for(String s:tagValues)
	{ 
		System.out.println("coap://["+s+"]/128:5683");
			
	}
	

    return tagValues;
	
	}
}