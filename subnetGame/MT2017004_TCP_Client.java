
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MT2017004_TCP_Client {

	private Socket socket = null;
    private DataInputStream  input = null;
    private DataOutputStream out = null;
    private DataInputStream  ip=null;
    @SuppressWarnings("deprecation")
	public MT2017004_TCP_Client(String address,int port) {
    	try {
    		 socket = new Socket(address, port);
             System.out.println("Connection Established");
             
             // takes input from terminal
             input  = new DataInputStream(System.in);
             
             //takes input from socket
             ip=new DataInputStream(socket.getInputStream());
            
             // sends output to the socket
             out    = new DataOutputStream(socket.getOutputStream());
    	
    	// string to read message from input
             System.out.println("Enter 5 nos to sort");
             String line="";
             for(int i=0;i<5;i++) {
	    		line = input.readLine();
	    		out.writeUTF(line);
             }
             System.out.println("Data Sent");
    	
    		 	String s =ip.readUTF(); 
    		 	System.out.println(s);
    	
    		 	// close the connection
    		    input.close();
		        ip.close();
    		    out.close();
		        socket.close();
		        System.out.println("Connection Closed");
        }
    	catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i.getMessage());
        }
    	
    }
    	
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MT2017004_TCP_Client client = new MT2017004_TCP_Client("127.0.0.1", 5000);
	}

}
