package dynamic_programming;

public class Highway_Billboard_Problem {
	public static int max_revenue(int x[],int profit[],int t){
		
		int n=x[x.length-1]+1;
		int revenue[]=new int [n];
		int idx=0;
		revenue[0]=0;
		for(int i=1;i<n;i++){
			if(x[idx]!=i){
				revenue[i]=revenue[i-1];
			}
			else{
				int prev=profit[idx];
				if(i>t){
					prev+=revenue[i-t-1];
				}
				revenue[i]=Math.max(revenue[i-1] , prev);
				idx++;
			}
		}
		//int dp[][]=new int[n][n];
		return revenue[n-1];
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[] = {6, 7, 12, 13, 14};
	    int revenue[] = {5, 6, 5, 3, 1};
	    System.out.println(max_revenue(x,revenue,5));
	}

}
