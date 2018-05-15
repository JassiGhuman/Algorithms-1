/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
class TrieNode{
    TrieNode child[];
    boolean isWord;
    TrieNode(){
        child=new TrieNode[26];
        isWord=false;
    }
}
public class Tries {
	public static void main (String[] args) {
		//code
		Scanner scr =new Scanner(System.in);
			int t=scr.nextInt();
			for(int t_i=0;t_i<t;t_i++){
			    int n =scr.nextInt();
			    String a[]=new String [n];
			    for(int i=0;i<n;i++){
			        a[i]=scr.next();
			    }
			    String x = scr.next();
			    System.out.println(create_and_find(a,x));
			}
	}
	
	public static int create_and_find(String a[],String x){
	    TrieNode root = new TrieNode() ;
	    TrieNode node = root;
	    int n = a.length;
	    for(int i=0;i<n;i++){
	        int len = a[i].length();
	        node = root;
	        for(int j = 0;j<len;j++){
	            if(node.child[a[i].charAt(j)-'a']==null)
	                node.child[a[i].charAt(j)-'a']= new TrieNode();
	            node = node.child[a[i].charAt(j)-'a'];
	            if(j==len-1)
	                node.isWord = true;
	        }
	    }
	    
	    return find(root,x);
	    
	}
	//find
	  static int find(TrieNode root,String x){
	        int n = x.length();
	        TrieNode node = root;
	        for(int j = 0;j < n ; j++){
	            if(node.child[x.charAt(j)-'a']==null)
	                return 0;
	            node = node.child[x.charAt(j)-'a'];
	            if(j==n-1){
                    if(node.isWord)
                        return 1;
                    return 0;    
	            }
	                
	        }
	        return 0;
	 }
}
