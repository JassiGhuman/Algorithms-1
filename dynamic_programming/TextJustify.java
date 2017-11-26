package dynamic_programming;

import java.util.Arrays;

public class TextJustify {

	public static int text_justify(String words[],int width) {
		int n=words.length;
		int cost[][]=new int [n][n];
		
		int spaces[][] =new int [n][n];
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				if(j==i)
				{
					spaces[i][i] = (width-words[j].length());
					cost[i][i] = (spaces[i][i])*(spaces[i][i])*(spaces[i][i]);
				}
				else if(cost[i][j-1]!=Integer.MAX_VALUE && spaces[i][j-1] >= 1 + words[j].length() ) {
					spaces[i][j] =spaces[i][j-1]-(1+ words[j].length());
					cost[i][j] =  (spaces[i][j])*spaces[i][j]*spaces[i][j];
				}
				else {
					cost[i][j] = Integer.MAX_VALUE;
					}
			}
		}
		
		// * uncomment below if you want to see the whole matrix
//		  for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(cost[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
		int min_cost[]=new int[n];
		Arrays.fill(min_cost,Integer.MAX_VALUE);
		int index[]=new int [n];
		min_cost[n-1]=cost[n-1][n-1];
		index[n-1]=n;
		for(int i=n-2;i>=0;i--) {
			min_cost[i]=cost[i][n-1];
			index[i]=n;
			for(int j=n-2;j>=i;j--) {
				if(cost[i][j]!=Integer.MAX_VALUE && cost[i][j]+min_cost[j+1]<min_cost[i])
				{
					min_cost[i]=cost[i][j]+min_cost[j+1];
					index[i]=j+1;
				}
			}
		}
		
		//print the result
		
		int idx=0;
		int lineCount=1;
		while(idx!=n) {
			System.out.println( "Line "+(lineCount++)+":word "+(idx+1)+"to "+(index[idx]));
			idx=index[idx];
		}
		return min_cost[0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s= "Geeks for Geeks presents word wrap problem" ;
		String s="aaa " + 
				"bb cc " + 
				"ddddd";
		String words[]=s.split(" ");
		System.out.println(text_justify(words, 6));
	}

}
