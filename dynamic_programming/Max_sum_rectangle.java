package dynamic_programming;
//To find max sum of a rectangle in 2-D array'
public class Max_sum_rectangle {
	public static int max_sum_rectangle(int a[][],int r,int c) {
		int n=r;
		//x`System.out.println(n);
		int sum[][]=new int[r][c];
		for(int i=0;i<r;i++) {
			sum[i][0]=a[i][0];
			for(int j=1;j<c;j++) {
				sum[i][j]=a[i][j]+sum[i][j-1];
			}
		}
		int g_sum=0;
		for(int i=0;i<c;i++) {
			for(int j=i;j<c;j++) {
				int max=0;
				for(int k=0;k<r;k++) {
					int l_sum=0;
					if(i==0) {
						l_sum=sum[k][j];
					}
					else {
						l_sum=sum[k][j]-sum[k][i-1];
					}
					if(max+l_sum<0) {
						max=0;
					}
					else {
						max+=l_sum;
					}
					g_sum=Math.max(g_sum, max);
				}	
			}
		}
		return g_sum;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]=new int[][] {
            {1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6}
            };
      System.out.println(max_sum_rectangle(a,4,5));      
	}

}
