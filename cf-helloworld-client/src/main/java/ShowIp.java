import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;


public class ShowIp {
   String GlobalIp=null;
    public static void main(String[] args) throws SocketException {
        NetworkInterface ni = NetworkInterface.getByName("cl");
        Enumeration<InetAddress> inetAddresses =  ni.getInetAddresses();


        while(inetAddresses.hasMoreElements()) {
            InetAddress ia = inetAddresses.nextElement();
            if(!ia.isLinkLocalAddress()) {
            
                System.out.println("IP: " + ia.getHostAddress());
            }
        }
    }

}