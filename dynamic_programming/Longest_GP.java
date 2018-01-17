package dynamic_programming;

import java.util.Arrays;

//Given a set of numbers, find the Length of the Longest Geometrix Progression (LLGP) in it
public class Longest_GP {
	public static int longest_gp(int a[]) {
		Arrays.sort(a);
		
		int n=a.length;
		int len[][]=new int[n][n];
		int max_gp=1;
		for(int i=0;i<n-1;i++) {
			if(a[n-1]%a[i]==0) {					//in case there is a GP of only 2 nos
				len[i][n-1]=2;
				max_gp=2;
			} else {
				len[i][n-1]=1;
			}
		}
		
		//System.out.println(max_gp);
		
		for(int j=n-2;j>0;j--) {
			int i=j-1;
			int k=j+1;
			while(i>=0 && k<=n-1) {
				//here we use Geometric mean by keeping j as fixed and finding appropriate ith and jth element 
				if(a[i]*a[k]<a[j]*a[j]) {	
					if(a[k]%a[j]==0) {
						len[j][k]=2;							//in case there is a GP of only 2 nos
						max_gp=Math.max(max_gp, len[j][k]);
					}
					k++;
				}
				
				else if(a[i]* a[k]>a[j]*a[j]) {
					
					if(a[j]%a[i]==0) {
						len[i][j]=	2;
						max_gp=Math.max(max_gp, len[i][j]);
					}
					else {
						len[i][j]=1;
					}
					i--;
					
				}
				else {
					//if it matches the equation then we increase the value of len[i][j] by 1 as we found another element in our GP
					len[i][j]=len[j][k]+1;
					max_gp=Math.max(max_gp, len[i][j]);
					k++;
					i--;
					
				}
			}
			//if by any chance we had to exit the loop early bcz of k > n-1 then we do this.
			while(i>=0) {
				if(a[j]%a[i]==0)							//in case there is a GP of only 2 nos
					len[i][j]=2;
				else
					len[i][j]=1;
				max_gp=Math.max(max_gp, len[i][j]);
				i--;
			}
		}
		return max_gp;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int set[] =  {9,14,18,30,60,120};
		 System.out.println(longest_gp(set));
	}

}
