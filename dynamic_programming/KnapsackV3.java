package dynamic_programming;

public class KnapsackV3 {
	//knapsack problem for atleast profit j and infinite weight limit...find smallest knapsack possible
	public static int knapsack(int wt[],int value[],int profit) {
		int n=wt.length;
		int a[][]=new int[profit+1][n+1];
		for(int i=0;i<=profit;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					a[i][j]=0;
					continue;
				}
				if(value[j-1]>=i && a[i][j-1]==0) {						
					a[i][j]=wt[j-1];
				}
				else if(i-value[j-1]>0 && a[i-value[j-1]][j-1]==0) {
					a[i][j]=a[i][j-1];
				}
				else {
					//if(a[i][j-1]>0) {
					if(i>=value[j-1] && a[i][j-1]!=0)
						a[i][j]=Math.min(a[i][j-1],wt[j-1]+a[i-value[j-1]][j-1]);
					else if(i>=value[j-1]) {
						a[i][j]=wt[j-1]+a[i-value[j-1]][j-1];
					}
					else
						a[i][j]=Math.min(wt[j-1],a[i][j-1]);
				}
			}
		}
		   for(int i=0;i<=profit;i++)
	    	{for(int y=0;y<=n;y++) {
	    		System.out.print(a[i][y]);
	    		}
	    	System.out.println();
	    	}

		return a[profit][n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int val[] = new int[]{6, 10, 12};
        int wt[] = new int[]{4, 3, 5};
        int  W = 50;
        int n = val.length;
        System.out.println(knapsack(wt,val,28));

	}

}
