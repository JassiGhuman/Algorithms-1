import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class MT2017004_TCP_Server {
	//initialize socket and input stream
	 private Socket          socket   = null;
	 private ServerSocket    server   = null;
	 private DataInputStream in       =  null;
	 private DataOutputStream out = null;
	 // constructor with port
	 public MT2017004_TCP_Server(int port)
	 {
	     // starts server and waits for a connection
	     try
	     {
	         server = new ServerSocket(port);
	         System.out.println("Server started");

	         System.out.println("Waiting for a client ...");

	         socket = server.accept();
	         System.out.println("Client accepted");

	         // takes input from the client socket
	         in = new DataInputStream(
	             new BufferedInputStream(socket.getInputStream()));

	             try
	             {
	                 	int a[]=new int [5];
	                 	for(int i=0;i<5;i++) {
	                 		a[i]=Integer.parseInt(in.readUTF());
	                 	}
	                 	System.out.println("Data Received");
	                 	for(int i=0;i<5;i++) {
	                 		for(int j=0;j<5-i-1;j++) {
	                 			if(a[j]>a[j+1]) {
	                 				int temp =a[j];
	                 				a[j]=a[j+1];
	                 				a[j+1]=temp;
	                 			}
	                 		}
	                 	}
	                 	String result="";
	                 	for(int i=0;i<5;i++) {
	                 		result+=" "+a[i];
	                 	}
						out = new DataOutputStream(socket.getOutputStream());
					   	out.writeUTF("Sorted nos are : "+result);
						
	             }
	             catch(IOException i)
	             {
	                 System.out.println(i);
	             }
	         
	         System.out.println("Closing connection");

	         // close connection
	         socket.close();
	         in.close();
	     }
	     catch(IOException i)
	     {
	         System.out.println(i);
	     }
	 }

	 public static void main(String args[])
	 {
	     MT2017004_TCP_Server server = new MT2017004_TCP_Server(5000);
	 }

}
