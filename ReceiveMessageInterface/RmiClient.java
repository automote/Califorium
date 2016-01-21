package ReceiveMessageInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiClient {

	
	static public void main(String args[])
    {
       ReceiveMessageInterface rmiServer;
       Registry registry;
       String serverAddress="localhost";
       String serverPort="3000";
       String text="test";
       System.out.println("sending "+text+" to "+serverAddress+":"+serverPort);
       try{
          
           registry=LocateRegistry.getRegistry(
               serverAddress,
               (new Integer(serverPort)).intValue()
           );
           // look up the remote object
           rmiServer=
              (ReceiveMessageInterface)(registry.lookup("rmiServer"));
           // call the remote method
           rmiServer.receiveMessage(text);
       }
       catch(RemoteException e){
           e.printStackTrace();
       }
       catch(NotBoundException e){
           e.printStackTrace();
       }
    }
	
}
