package dynamic_programming;

public class Two_knapsacks {
	public static int two_knapsacks(int weight[],int profit[],int weight1,int weight2) {
		int n=weight.length;
		int result[][][]=new int[n+1][weight1+1][weight2+1];
		
			for(int j=0;j<=weight1;j++) {
				for(int k=0;k<=weight2;k++) {
					for(int i=0;i<=n;i++) {
						if(i==0) {
							result[i][j][k]=0;
							continue;
						}
						if(j>= weight[i-1] && k>=weight[i-1]) {
							result[i][j][k]=Math.max( result[i-1][j][k],profit[i-1]+ 
													Math.max(result[i-1][j-weight[i-1]][k], result[i-1][j][k-weight[i-1]]));
						}
						else if(j>= weight[i-1]) {
							result[i][j][k]=Math.max(result[i-1][j][k],profit[i-1]+result[i-1][j-weight[i-1]][k] );
						}
						else if( k>=weight[i-1]) {
							result[i][j][k]=Math.max(result[i-1][j][k],profit[i-1]+result[i-1][j][k-weight[i-1]] );
						}
						else
							result[i][j][k]=result[i-1][j][k];
				}
			}
		}
			return result[n][weight1][weight2];
	}
	public static void main(String[] args) {
		int [ ]weight= {2,3,4,8,7,13};
		int profit[]= {3,4,4,9,10,51};
		System.out.println(two_knapsacks(weight, profit, 12,10));
	}
}
