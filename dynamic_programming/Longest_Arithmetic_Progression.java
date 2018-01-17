package dynamic_programming;

import java.util.Arrays;

//Given a set of numbers, find the Length of the Longest Arithmetic Progression (LLAP) in it.
public class Longest_Arithmetic_Progression {
	
	public static int longest_ap(int a[]) {
		//first sort the array in increasing order
		Arrays.sort(a);
		
		int n=a.length;
		int len[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			len[i][n-1]=2;
		}
		int max_ap=2;
		for(int j=n-2;j>0;j--) {
			int i=j-1;
			int k=j+1;
			while(i>=0 && k<=n-1) {
				//here we use Arithmetic mean by keeping j as fixed and finding appropriate ith and jth element 
				if(a[i]+a[k]<2*a[j]) {
					//len[i][j]=2;
					k++;
				}
				
				else if(a[i]+ a[k]>2*a[j]) {
					len[i][j]=2;
					i--;
					
				}
				else {
					//if it matches the equation then we increase the value of len[i][j] by 1 as we found another element in our AP
					len[i][j]=len[j][k]+1;
					max_ap=Math.max(max_ap, len[i][j]);
					k++;
					i--;
					
				}
			}
			//if by any chance we had to leave the loop early bcz of k > n-1 then we do this.
			while(i>=0) {
				len[i][j]=2;
				i--;
			}
		}
		return max_ap;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int set[] = {2, 3, 6, 9, 11};
		System.out.println(longest_ap(set));
	}

}
