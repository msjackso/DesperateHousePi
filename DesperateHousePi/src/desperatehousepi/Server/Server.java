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
	static Crust myCrust;
	int mySocket;
	
	public Server(Crust c, int socketNum){
		myCrust = c;
		mySocket = socketNum;
	}
	
	
	
	public static int interact(Relationship rel, int socketNum){
		
		System.out.println("Start interaction.");
		
		Package sendPackage = new Package(rel.getContactName(), rel.getContactAddress());
		Integer receivePackage = null;
		
		//Create the socket
		try {
			interactSocket = new Socket(InetAddress.getByName(rel.getContactAddress()), socketNum);
		} catch (Exception e){ e.printStackTrace(); }
		System.out.println("Socket made.");
		
		//Create the output stream to write to server
		try {
			intOutStream = new ObjectOutputStream(interactSocket.getOutputStream());
		} catch (IOException e) { e.printStackTrace(); }
		System.out.println("Output made.");
		
		//Write the object to the server
		try {
			intOutStream.writeObject(sendPackage);
		} catch (IOException e) { e.printStackTrace(); }
		System.out.println("Object written.");
		
		//Create the input stream to read from the server
		try {
			intInStream = new ObjectInputStream(interactSocket.getInputStream());
		} catch (IOException e) { e.printStackTrace(); }
		System.out.println("Input made.");
		
		//Read from the server
		try {
			receivePackage = (Integer) intInStream.readObject();
		} catch (Exception e){ e.printStackTrace(); }
		System.out.println("Object read.");
		
		//Print the received package
		System.out.println("CLIENT: "+receivePackage.toString());
		
		//Close all of the streams
		try {
			intInStream.close();
			intOutStream.close();
			interactSocket.close();
		} catch (IOException e) { e.printStackTrace(); }
		
		return 1;
	}

	public int conversate(){
		return 4;
	}

	@Override
	public void run() {
		
		System.out.println("Starting run.");
		
		try{
			myServer = new ServerSocket(mySocket);
		}catch (IOException e){
			System.out.println(e);
		}
		try{
			
			while(true){
				
				System.out.println("Accepting socket.");
				
				clientSocket = myServer.accept();
				
				inputStream = new ObjectInputStream(clientSocket.getInputStream());
				outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
				
				try {
					recvPackage = (Package) inputStream.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("SERVER: "+recvPackage.toString());
				
				//Generate return package
				outputStream.writeObject(new Integer(conversate()));
				
				inputStream.close();
				outputStream.close();
				clientSocket.close();
				
			}
		}
		catch (IOException e){
			System.out.println(e);
			
		}
	}
	
}
