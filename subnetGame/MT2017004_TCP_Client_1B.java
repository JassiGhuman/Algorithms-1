// A Java program for a Client

import java.net.*;
import java.io.*;
 
public class MT2017004_TCP_Client_1B
{
    // initialize socket and input output streams
    private Socket socket            = null;
    
    //input 1 to read data from the console of this machine
    private DataInputStream  input1   = null;

    //out to write data into output stream of the socket and send it to the server
    private DataOutputStream out     = null;

 	//input 2 is to read data from the server
 	private DataInputStream input2   = null;
 	
    
    
    // constructor to put ip address and port
    public MT2017004_TCP_Client_1B(String address, int port)
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected to the server");
 
            // takes input from terminal
            input1  = new DataInputStream(System.in);
           
            // sends output to the server socket 
            out    = new DataOutputStream(socket.getOutputStream());
            
            // takes input from the server socket
            input2 = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            
            
            
       	
        	try
        	{
        		
        		String s = "";
        		int n = 5;
        		System.out.println("Enter exactly 5 numbers to be sorted: ");
        		for(int i=0;i<n;i++)
        		{
        			String a = input1.readLine();
        			s = s + a;
        		}
        		out.writeUTF(s);
        		System.out.println("Integer array sent to the server to be sorted!!");
        	}
        	catch(Exception e)
        	{
        		System.out.println(e);
        	}
   			
        	
           	String result = "";
            //reading the result back from the server
        	result = input2.readUTF();
        	System.out.println("Integer array after being sorted and returned by the server -> " + result);
        }
        catch(UnknownHostException u)
        {
            System.out.println(u + " inside UnknownHostException");
        }
        catch(IOException i)
        {
            System.out.println(i + " inside IOException");
        }
   
     	// close the connection
        try
        {
            input1.close();
            input2.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
 
    public static void main(String args[])
    {
        MT2017004_TCP_Client_1B client = new MT2017004_TCP_Client_1B("127.0.0.1", 5000);
    }
}
