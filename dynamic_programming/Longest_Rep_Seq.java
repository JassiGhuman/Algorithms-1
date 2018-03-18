package dynamic_programming;

import java.util.Arrays;

//Length of the longest substring without repeating characters
public class Longest_Rep_Seq {
	public static int longest_rep(char a[]) {
		int n=a.length;
		int m[][]=new int[n+1][n+1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0|| j==0) {
					m[i][j]=0;
					continue;
				}
				if(i!=j) {
					if(a[i-1]==a[j-1]) {
						m[i][j]=m[i-1][j-1]+1;
					}
					else {
						m[i][j]=Math.max(m[i][j-1],m[i-1][j]);
					}
				}
				else {
					m[i][j]=Math.max(m[i][j-1],m[i-1][j]);
				}
			}
			
		}
		int x[][]=new int [Integer.MAX_VALUE][Integer.MIN_VALUE];
		Arrays.fill(x, 0);
		return m[n][n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aabb";
		char[]c=s.toCharArray();
		System.out.println(longest_rep(c));
	}

}
