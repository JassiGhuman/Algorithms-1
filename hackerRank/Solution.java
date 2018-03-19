package hackerRank;
import java.io.*;
import java.util.*;
 
public class Solution{
	static int xor_add(int count_zero[][],int p,int q){
		int result=0;
		
		for(int j=0;j<31;j++){
			int count0=0;
			int count1=0;
			if(p==1){
				count0=count_zero[q-1][j];
			}
			else{
				count0=count_zero[q-1][j]-count_zero[p-2][j];
			}
			count1=(q-p+1)-count0;
			if(count0>count1)
				result+=(int)Math.pow(2,j);
		}
		return result;

	}
	public static void main(String args[]){
		Scanner scr =new Scanner(System.in);
		int t=scr.nextInt();
		int q=scr.nextInt();
		int a1[]=new int [t];
		String s[]=new String[t];
		int count0[][]=new int [t][31];
		for(int t_i=0;t_i<t;t_i++){
			    a1[t_i]=scr.nextInt();
			    s[t_i]=Integer.toBinaryString(a1[t_i]);
			    for(int i=0;i<31;i++)	
			    	{
			    		if(t_i==0 ){
			    			if(i<s[t_i].length() &&  s[t_i].charAt(s[t_i].length()-1-i)=='0'){
			    				count0[t_i][i]=1;
			    			}
			    			if(i>=s[t_i].length())
			    				count0[t_i][i]++;
			    		}
			    		else{
			    			count0[t_i][i]=count0[t_i-1][i];
			    			if(i<s[t_i].length() &&  s[t_i].charAt(s[t_i].length()-1-i)=='0'){
			    				count0[t_i][i]+=1;
			    			}
			    			if(i>=s[t_i].length())
			    				count0[t_i][i]++;
			    		}
			    	}
			    	
				}
		for(int i=0;i<q;i++){ 
    		int p=scr.nextInt();
    		int r=scr.nextInt();   		
    		System.out.println(xor_add(count0,p, r));
		}
		
		
	}
 
}