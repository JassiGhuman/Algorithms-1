package geeks;
import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG {
		public static void main (String[] args) {
			//code
		    Scanner scr = new Scanner(System.in);
		    int t=scr.nextInt();
		    scr.nextLine();
		    for(int t_i=0;t_i<t;t_i++){
		        String s=scr.nextLine();
		        String words[]=s.split("\\.");
		        //System.out.println(words[0]+" "+words.length);
		        System.out.print(words[words.length-1]);
		        for(int i=words.length-2;i>=0;i--){
		            System.out.print("."+words[i]);    
		        }
		        System.out.println();
		    }
		    
		}
	}
 