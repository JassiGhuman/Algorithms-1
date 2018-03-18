package arrays;

import java.util.Scanner;

public class Palindrome_Substring_Queries {
	public static void calculate_hash(String s,int prefix[],int suffix[]) {
		int n=prefix.length-1;
		for(int i=1;i<=n;i++) {
			prefix[i]=(prefix[i-1]+(s.charAt(i-1)*(int)Math.pow(101, i-1)%1000000007)%1000000007)%1000000007;
			
			suffix[i]=(suffix[i-1]+(s.charAt(n-i)*(int)Math.pow(101, i-1)%1000000007)%1000000007)%1000000007;
		}
	}
	public static boolean isPalindrome(String s,int l,int r) {
		for(int i=l;i<=r;i++) {
			System.out.println("1");
			if(s.charAt(i)!=s.charAt(l+r-i))
				return false;
		}
		return true;
	}
	public static boolean query(String s,int prefix[],int suffix[],int l,int r,int n) {
		int prefix_hash=prefix[r+1]-prefix[l];
		int suffix_hash=suffix[n-l]-suffix[n-r-1];
		if(prefix_hash==(suffix_hash* Math.pow(101, l-n+r+1))) {
			return isPalindrome(s, l, r);
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr =new Scanner(System.in);
		int t=scr.nextInt();
		int n =scr.nextInt();
	    String s= scr.next();
	    int prefix[]=new int[n+1];
	    int suffix[]=new int [n+1];
	    calculate_hash(s, prefix, suffix);
		for(int t_i=0;t_i<t;t_i++){
			int l=scr.nextInt();
			int r=scr.nextInt();
			System.out.println("String :"+l+"to "+r+" is "+query(s, prefix, suffix, l, r, n));
		}
	}

}
