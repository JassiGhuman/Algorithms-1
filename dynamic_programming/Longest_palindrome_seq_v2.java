package dynamic_programming;
//O(n) space and o(n^2) time
public class Longest_palindrome_seq_v2 {
	public static int longest_palindrome_seq(String s) {
		int n=s.length();
		//int a[][]=new int[s.length()][s.length()];
		int array1[]=new int [n];
		for(int i=0;i<n;i++) {
			array1[i]=1;
		}
		int array2[]=new int [n-1];
		for(int i=0;i<n-1;i++) {
			if(s.charAt(i+1)==s.charAt(i)) {
				array2[i]=2;
			}
			else
				array2[i]=1;
		}
		int array3[]=new int [n-2];
		for(int j=2;j<n;j++) {
			array3=new int[n-j];
			for(int i=0;i<array3.length;i++) {
				if(s.charAt(i+j)==s.charAt(i)) {
					array3[i]=array1[i+1]+2;
				}
				else {
					array3[i]=Math.max(array2[i],array2[i+1]);
				}
			}
			array1=array2;
			array2=array3;
		}
		return array3[0];
		//		int difference=0;
//		while(difference<=n-1) {
//			for(int i=0;i<n-difference;i++) {
//				int j=i+difference;
//				if(i==j) {
//					a[i][i]=1;
//					continue;
//				}
//				if(s.charAt(i)==s.charAt(j)) {
//					a[i][j]=2+a[i+1][j-1];
//				}
//				else {
//					a[i][j]=Math.max(a[i][j-1],a[i+1][j]);
//				}
//			}
//			difference++;
//		}
//		return a[0][n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "geeks for geeks";
		System.out.println(longest_palindrome_seq(s) );
	}

}
