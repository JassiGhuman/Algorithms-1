package dynamic_programming;

public class Longest_palindrome_seq {

	public static int longest_palindrome_seq(String s) {
		int n=s.length();
		int a[][]=new int[s.length()][s.length()];
		int difference=0;
		while(difference<=n-1) {
			for(int i=0;i<n-difference;i++) {
				int j=i+difference;
				if(i==j) {
					a[i][i]=1;
					continue;
				}
				if(s.charAt(i)==s.charAt(j)) {
					a[i][j]=2+a[i+1][j-1];
				}
				else {
					a[i][j]=Math.max(a[i][j-1],a[i+1][j]);
				}
			}
			difference++;
		}
		longest_palindrome(a, 0, n-1, "", "", s);
		return a[0][n-1];
	}
	public static void longest_palindrome(int a[][],int r,int c,String left,String right,String s) {
		if(r>c) {
			System.out.println(left+right);
			return;
		}
		if(r==c) {
			System.out.println(left+s.charAt(r)+right);
			return;
		}
		if(s.charAt(r)==s.charAt(c) && a[r][c]==2+a[r+1][c-1]) {
//			left+=s.charAt(r);
//			right=s.charAt(r)+right;
			longest_palindrome(a, r+1, c-1, left+s.charAt(r), s.charAt(r)+right,s);
		} 
		 if(a[r][c]==a[r][c-1]) {
			longest_palindrome(a, r, c-1, left, right, s);
		}
		 if(a[r][c]==a[r+1][c]) {
			longest_palindrome(a, r+1, c, left, right, s);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "cabbaa";
		System.out.println(longest_palindrome_seq(s) );
	}

}
