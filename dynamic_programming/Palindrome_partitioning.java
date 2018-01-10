package dynamic_programming;
//Min no of cuts in a string such that all substrings are palindromes. 				O(n^3)
public class Palindrome_partitioning {

	public static int palindrome_partitioning(String s) {
		int n=s.length();
		int a[][]=new int[s.length()][s.length()];
		boolean palin[][]=new boolean [n][n];
		int difference=0;
		while(difference<=n-1) {
			for(int i=0;i<n-difference;i++) {
				int j=i+difference;
				if(i==j) {
					a[i][i]=0;
					//palin[i][i]=true;
					continue;
				}
				if(s.charAt(i)==s.charAt(j) && a[i+1][j-1]==0) {
						a[i][j]=0;
				}
				else {
					//a[i][j]=Math.max(a[i][j-1],a[i+1][j]);
					a[i][j]=Integer.MAX_VALUE;
					
					for(int k=i;k<j;k++) {
						if(a[i][k]+a[k+1][j]+1<a[i][j]) {
							a[i][j]=a[i][k]+a[k+1][j]+1;
						}
					}
				}
			}
			difference++;
		}
		return a[0][n-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "ababbbabbababa";
		System.out.println(palindrome_partitioning(s));
	}

}
