package dynamic_programming;

public class Coin_change {
	
	public static int coin_change(int x[],int amount) {
		int a[][]=new int[amount+1][x.length+1];
		int n=x.length;
		for(int i=0;i<=amount;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					a[i][j]=0;
					continue;
				}
				
				if(x[j-1]>i) {
					a[i][j]=a[i][j-1];
				}
				else if(i-x[j-1]!=0 && a[i-x[j-1]][j]==0) {
					a[i][j]=a[i][j-1];
				}
				else
					if(a[i][j-1]>0) {
						a[i][j]=Math.min(a[i][j-1],1+a[i-x[j-1]][j]);
					}
					else
						a[i][j]=1+a[i-x[j-1]][j];
			}
		}
		   for(int i=0;i<=amount;i++)
	    	{for(int y=0;y<=n;y++) {
	    		System.out.print(a[i][y]);
	    		}
	    	System.out.println();
	    	}
	      //return K[n][W];

		return a[amount][n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[]= {1,7,10,5};
		System.out.println(coin_change(val, 15));
	}

}
