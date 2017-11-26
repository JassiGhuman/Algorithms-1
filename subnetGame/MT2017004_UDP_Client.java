import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class MT2017004_UDP_Client{

	public static void main(String [] arg)throws IOException{
      
      int a[]=new int[5];
      int i;
      
      Scanner sc=new Scanner(System.in);
      
      for(i=0;i<5;i++)
      	a[i]=sc.nextInt();
      
      String s=Arrays.toString(a);
      
      System.out.println(s);
      
      byte b[]= s.getBytes();
	  
	  byte [] IP= { (byte)127, (byte)0,(byte) 0,(byte)1 };
		
		InetAddress ip=InetAddress.getByAddress(IP);
		DatagramSocket ds=new DatagramSocket();
		DatagramPacket ps=new DatagramPacket(b,b.length,ip,2111);
		ds.send(ps);
		System.out.println("connected");

		byte b4[]=new byte[100];
		
		DatagramSocket ds2=new DatagramSocket(2111);
		
		ps=new DatagramPacket(b4,b4.length);
	
		ds2.receive(ps);

		System.out.println("Sorted array is :");

		System.out.println(new String(b4));

	}
}
