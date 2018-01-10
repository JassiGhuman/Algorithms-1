package dynamic_programming;

public class Plaindrome_partitioning_v2 {
	
	public static int palindrome_partitioning_v2(String s) {
	int n=s.length();
	int a[]=new int[s.length()];
	boolean palin[][]=new boolean [n][n];
	int difference=0;
	while(difference<=n-1) {
		for(int i=0;i<n-difference;i++) {
			int j=i+difference;
			if(i==j) {
				//a[i][i]=0;
				palin[i][i]=true;
				continue;
			}
			if(s.charAt(i)==s.charAt(j) && (difference==1 || palin[i+1][j-1])) {
					//a[i][j]=0;
				palin[i][j]=true;
			}
			else {
				//a[i][j]=Math.max(a[i][j-1],a[i+1][j]);
				palin[i][j]=false;
			}
		}
		difference++; 
	}
	//System.out.println(palin[0][n-1]);
	for(int i=0;i<n;i++) {
		if(palin[0][i]) {
			a[i]=0;
		}
		else {
			a[i]=Integer.MAX_VALUE;
			for(int j=0;j<i;j++) {
				if(palin[j+1][i])
				a[i]=Math.min(a[i],1+a[j]);
			}
		}
	}
	return a[n-1];
	}
	public static void main(String[] args) {
		String s= "aba";
		System.out.println(palindrome_partitioning_v2(s));
	}
}
