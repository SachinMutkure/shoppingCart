package com.serialization.clientserver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/** Create the client program using the socket and the
 *  ObjectOutputStream object and InputOutputStream 
 *  object.
 * @author webwerks
 */
public class Client {

	public static void main(String[] args) {
		try{
			Employee joe = new Employee(150, "Sachin");
			
			System.out.println("Emp No:"+joe.getEmployeeNumber());
			System.out.println("Emp Name:"+joe.getEmployeeName());
			
			Socket socketConnection = new Socket("127.0.0.1", 11111);
			
			//Set the Object from Client to Server.
			ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
			//Get the Object from Server to Client.
			ObjectInputStream clientInputStream = new ObjectInputStream(socketConnection.getInputStream());
			
			//this will be write the stream of object on server
			clientOutputStream.writeObject(joe);
			
			//this will retrieve the updated object from server 
			joe = (Employee)clientInputStream.readObject();
			
			System.out.println("Emp No:"+joe.getEmployeeNumber());
			System.out.println("Emp Name:"+joe.getEmployeeName());
			
			clientOutputStream.close();
			clientInputStream.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
