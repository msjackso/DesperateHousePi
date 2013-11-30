package desperatehousepi.Server;

import desperatehousepi.Crust.Crust;
import desperatehousepi.Crust.Relationship;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class Server implements Runnable{
	
	public static final int SOCKET_DEFAULT = 9999;
	public static final int SOCKET_TEST = 9998;
	
	ServerSocket myServer = null;
	Socket clientSocket = null;
	static Socket interactSocket = null;
	ObjectInputStream inputStream;
	static ObjectInputStream intInStream;
	ObjectOutputStream outputStream;
	static ObjectOutputStream intOutStream;
	Package recvPackage;
	Crust myCrust;
	int mySocket;
	boolean listening = true;
	
	public Server(Crust c, int socketNum){
		myCrust = c;
		mySocket = socketNum;
	}
	
	public int interact(Relationship rel, int socketNum){
		
		Package sendPackage = new Package(myCrust.get("fullName"));
		sendPackage.setInterests(myCrust.getInterests());
		sendPackage.setTraits(myCrust.getTraits());
		
		Integer receivePackage = null;
		
		//Create the socket
		try {
			interactSocket = new Socket(InetAddress.getByName(rel.getContactAddress()), socketNum);
		} catch (Exception e){ e.printStackTrace(); }
		
		//Create the output stream to write to server
		try {
			intOutStream = new ObjectOutputStream(interactSocket.getOutputStream());
		} catch (IOException e) { e.printStackTrace(); }
		
		//Write the object to the server
		try {
			intOutStream.writeObject(sendPackage);
		} catch (IOException e) { e.printStackTrace(); }
		
		//Create the input stream to read from the server
		try {
			intInStream = new ObjectInputStream(interactSocket.getInputStream());
		} catch (IOException e) { e.printStackTrace(); }
		
		//Read from the server
		try {
			receivePackage = (Integer) intInStream.readObject();
		} catch (Exception e){ e.printStackTrace(); }
		
		//Close all of the streams
		try {
			intInStream.close();
			intOutStream.close();
			interactSocket.close();
		} catch (IOException e) { e.printStackTrace(); }
		
		
		
		return receivePackage;
	}

	public int conversate(Package pack){
		return 4;
	}

	@Override
	public void run() {
		
		try{
			myServer = new ServerSocket(mySocket);
		}catch (IOException e){
			System.out.println(e);
		}
		try{
			
			while(true){
				while(listening){
					
					clientSocket = myServer.accept();
					
					if(!listening) return;
					
					inputStream = new ObjectInputStream(clientSocket.getInputStream());
					outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
					
					try {
						recvPackage = (Package) inputStream.readObject();
					} catch (ClassNotFoundException e) { e.printStackTrace(); }
					
					//Generate return package
					outputStream.writeObject(new Integer(conversate(recvPackage)));
					
					inputStream.close();
					outputStream.close();
					clientSocket.close();
					
				}
			}
		}
		catch (IOException e){
			System.out.println(e);
			
		}
	}
	
	public void setListening(boolean val){
		listening = val;
	}
	
}
