package ReceiveMessageInterface;

import java.rmi.*;

import java.rmi.registry.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

 

public class RmiServer extends java.rmi.server.UnicastRemoteObject implements ReceiveMessageInterface

{ 
	int thisPort=3000;
    String thisAddress;
    Registry registry;//rmi registry is the lookup for remote object
	public RmiServer() throws RemoteException

    {

        try{

            // get the address of this host.

            thisAddress= (InetAddress.getLocalHost()).toString();

        }

        catch(Exception e){

            throw new RemoteException("can't get inet address.");

        }

        thisPort=3000;  

        System.out.println("this address="+thisAddress+",port="+thisPort);

        try{

        // create the registry and bind the name and object.

        registry = LocateRegistry.createRegistry( thisPort );

            registry.rebind("rmiServer", this);

        }

        catch(RemoteException e){

        throw e;

        }

    }
	@Override
	public void receiveMessage(String query) throws RemoteException {
		
		System.out.println(query);
		
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[])
	{
		try {
			new RmiServer();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}	
	
}

