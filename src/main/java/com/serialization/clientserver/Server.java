package com.serialization.clientserver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/** Server class Which accept the response from the 
 *  Client and made some manipulation and send it 
 *  back to the client.
 * @author webwerks
 *
 */
public class Server {

	public static void main(String[] args) {
		Employee employee = null;
		try {
			ServerSocket socketConnection = new ServerSocket(11111);
			System.out.println("Server waiting...");
			Socket pipe = socketConnection.accept();
			
			ObjectInputStream serverInputStream = new ObjectInputStream(pipe.getInputStream());
			ObjectOutputStream serverOutputStream = new ObjectOutputStream(pipe.getOutputStream());
			
			employee = (Employee)serverInputStream.readObject();
			System.out.println("Emp client Name:"+employee.getEmployeeName());
			System.out.println("Emp client No:"+employee.getEmployeeNumber());
			
			employee.setEmployeeNumber(256);
			employee.setEmployeeName("Mohit");
			serverOutputStream.writeObject(employee);
			
			serverInputStream.close();
			serverOutputStream.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
