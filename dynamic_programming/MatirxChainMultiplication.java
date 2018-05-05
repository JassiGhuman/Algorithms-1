/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int matrix_chain(int a[]){
        int n = a.length;
        int dp[][]=new int[n][n];
        int l=1;
        while(l<n){
            for(int i=1;i<n-l;i++){
                int j = l+i;
                
                    dp[i][j]=Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        dp[i][j]=Math.min(dp[i][k]+dp[k+1][j]+a[i-1]*a[k]*a[j],dp[i][j]);
                }
            }
            l++;
        }
        System.out.println(dp[1][n-1]);
        return dp[1][n-1];
    }
	public static void main (String[] args) {
		//code
		Scanner scr =new Scanner(System.in);
		int t=scr.nextInt();
		for(int t_i=0;t_i<t;t_i++){
		    int n =scr.nextInt();
		    int a[]=new int [n];
		    for(int i=0;i<n;i++){
		        a[i]=scr.nextInt();
		    }
		    matrix_chain(a);
		}
	}
	
}
