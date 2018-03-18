package dynamic_programming;

public class Optimal_Strategy_Game {
	public static int optimal_strategy(int a[]) {
		int n=a.length;
		int sum[][]=new int [n][n];
		int difference=0;
		while(difference<n) {
			
			for(int i=0;i<n-difference;i++) {
				int j=i+difference;
					if(i==j)
						sum[i][j]=a[i];
					else if(j==i+1) {
						sum[i][j]=Math.max(a[i], a[j]);
					}
					else {
						sum[i][j]=Math.max(a[i]+Math.min (sum[i+2][j] , sum[i+1][j-1]) 
								, a[j]+Math.min(sum[i][j-2],sum[i+1][j-1]));
					}
			}
			difference++;
		}
		return sum[0][n-1];
	}
	public static void main(String[] args) {
		int a[]= { 8, 15, 3, 7 };
		System.out.println(optimal_strategy(a));
	}
}
