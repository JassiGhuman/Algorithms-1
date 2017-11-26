package dynamic_programming;
//Minimum insertions to form a palindrome
public class MinInsertionsForPalindrome {
	public static int palindrome(String s) {
		int n=s.length();
		int a[][]=new int[n][n];
		int difference=0;
		
		while(difference<n) {
			
			for(int i=0;i<n-difference;i++) {
				int j=i+difference;
				if(i==j) {
					a[i][j]=0;
				}
				else if(s.charAt(i)==s.charAt(j)) {
					a[i][j]=a[i+1][j-1];
				}
				else {
					a[i][j]=1+Math.min(a[i][j-1],a[i+1][j]);
				}
			}
			difference++;
		}
		return a[0][n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aebcbda";
		System.out.println(palindrome(s));
	}

}
