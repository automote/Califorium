import java.net.InetAddress;
import java.net.NetworkInterface;

public class MacAddress {
  public static void main(String[] args) throws Exception {
    InetAddress address = InetAddress.getLocalHost();

    NetworkInterface ni = NetworkInterface.getByInetAddress(address);
    byte[] mac = ni.getHardwareAddress();

    for (int i = 0; i < mac.length; i++) {
      System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
    }
  }
}