package dynamic_programming;
//Count All Palindromic Subsequence in a given String
public class Count_Palindromic_Substrings {
	public static int find__palindromic_count(String s) {
		int n=s.length();
		int dp[][]=new int[n][n];
		int l=0;
		while(l<n) {
			for(int i=0;i<n-l;i++) {
				int j=i+l;
				if(i==j) {
					dp[i][i]=1;
				}
				else if(s.charAt(i)!=s.charAt(j)) {
					dp[i][j]=dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1];
				}
				else {
					dp[i][j]=dp[i][j-1]+dp[i+1][j]+1;
				}
			}
			l++;
		}
		return dp[0][n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(find__palindromic_count("abaa") );
	}

}
