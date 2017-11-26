package dynamic_programming;

public class Cut_a_rod_v2 {
	
	public static int cut(int a[]) {
		int n=a.length;
		int T[][]=new int[n][n];
		int difference=1;
		while(difference<=n-1) {
			for(int i=0;i<n-difference;i++) {
				int j=i+difference;
				if(i==j-1) {
					T[i][i+1]=0;
					continue;
				}
				int min_cost=Integer.MAX_VALUE;
				for(int k=i+1;k<j;k++) {
					min_cost=Math.min(min_cost, T[i][k] + T[k][j]) ;
				}
				T[i][j]=a[j]-a[i]+min_cost;
			}
			difference++;
		}
		return T[0][n-1];
	}
	public static void find_all_cuts(int T[][],int n){
		int count=0;
		int i=0;
		int j=n-1;
//		while(count!=n-2) {
//			while(i<n-1 && j>0) {
//				
//			}
//		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {0,80,90,95,100};
		System.out.println(cut(a));
	}

}
