package desperatehousepi.Server;

import desperatehousepi.Crust.Crust;
import desperatehousepi.Crust.Relationship;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class Server implements Runnable{
	
	ServerSocket myServer = null;
	Socket clientSocket = null;
	static Socket interactSocket = null;
	ObjectInputStream inputStream;
	static ObjectInputStream intInStream;
	ObjectOutputStream outputStream;
	static ObjectOutputStream intOutStream;
	static Crust crust;
	static Crust myCrust;
	
	public Server(Crust c){
		try{
			myServer = new ServerSocket(9999);
			myCrust = c;
			
		}
		catch (IOException e){
			System.out.println(e);
		}
		try{
			clientSocket = myServer.accept();
			inputStream = new ObjectInputStream(clientSocket.getInputStream());
			outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			
			while(true){
				try {
					crust = (Crust)inputStream.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				crust.print();
				outputStream.writeObject(myCrust);
			}
		}
		catch (IOException e){
			System.out.println(e);
			
		}
	
	}
	
	
	
	public static int interact(Relationship rel){
		try{
			interactSocket = new Socket(rel.getContactAddress(), 0);
			intInStream = new ObjectInputStream(interactSocket.getInputStream());
			intOutStream = new ObjectOutputStream(interactSocket.getOutputStream());
		}
		catch(UnknownHostException e){
			System.err.println("Dunno that host");
		}
		catch (IOException e){
			System.err.println(e);
		}
		try {
			intOutStream.writeObject(myCrust);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			crust = (Crust)intInStream.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		crust.print();
		return 1;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
