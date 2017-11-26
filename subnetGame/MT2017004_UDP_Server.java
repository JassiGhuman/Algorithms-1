import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.io.*;

public class MT2017004_UDP_Server 
{
	static int result[]=new int[5];
	public static void main(String args[])throws IOException
	{
	DatagramSocket ds=new DatagramSocket(2111);
	byte b[]=new byte[1000];
	DatagramPacket dp=new DatagramPacket(b,b.length);
	ds.receive(dp);
	System.out.println("Connected Server");
	String msg=new String(b);
	fromString(msg);
	Arrays.sort(result);
	for(int j:result)
		System.out.println(j);
	String s=Arrays.toString(result);
	byte b1[]=s.getBytes();
	 byte [] IP= { (byte)127, (byte)0, (byte)0,(byte)1 };
	InetAddress ip=InetAddress.getByAddress(IP);
	 ds=new DatagramSocket();
	DatagramPacket ps=new DatagramPacket(b1,b1.length,ip,2111);
	ds.send(ps);
	
	
	}
	
	static void fromString(String string) {
	    String[] strings = string.replace("[", "").replace("]", "").split(", ");
	      for (int i = 0; i < result.length; i++) {
	      result[i] = Integer.parseInt(strings[i].trim());
	    }
	   
	  }
}
