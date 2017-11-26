package dynamic_programming;

public class KnapSack {

	static int k[][];
	static int count=0;
	static int max(int a, int b) { return (a > b)? a : b; }
	static int knapsack(int w,int []wt,int v[],int n) {

		if(n==0|| w==0)
			return 0;
		if(k[w][n]!=0) {
			System.out.println("hehe");
			return k[w][n];
		}
		if(wt[n-1]>w) {
			int a = knapsack(w,wt,v,n-1);
			k[w][n]=a;
			return a; 
		 }
		else {
			int a=max(knapsack(w,wt,v,n-1),v[n-1]+knapsack(w-wt[n-1],wt,v,n-1));
			k[w][n]=a;
			return a;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = {10, 20, 30};
	    int wt[] = {1,1,1};
	    int  W = 50;
	    int n = val.length;
	    k=new int [W+1][n+1];
	  	    System.out.println(knapsack(W, wt, val, n));
	  	  for(int i=0;i<W+1;i++)
		    	{for(int j=0;j<n+1;j++) {
		    		System.out.print(k[i][j]+"  ");}
	  	  	System.out.println();
		    	}
	}
}
