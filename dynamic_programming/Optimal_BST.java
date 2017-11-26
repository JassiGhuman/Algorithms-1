package dynamic_programming;

public class Optimal_BST {

	public static int optimal_bst(int a[]) {
		int n=a.length;
		int count[][]=new int[n][n];
		int difference=0;
		while(difference<=n-1) {
			for(int i=0;i<n-difference;i++) {
				int j=i+difference;
				if(i==j) {
					count[i][i]=a[i];
				}
				else{
					int key_sum=0;								//Sum of all frequencies from i to j
					int index=i;
					for(;index<=j;index++) {
						key_sum+=a[index];
					}
					count[i][j]=Integer.MAX_VALUE;
					for(index=i;index<=j;index++) {
						int a1=0;
						if(index>i) {
							a1=count[i][index-1];
						}
						int b1=0;
						if(index<j) {
							b1=count[index+1][j];
						}
						count[i][j]=Math.min (a1+b1+key_sum,count[i][j]);
					}
				}
			}
			difference++;
		}
		return count[0][n-1];

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int freq[]= {34, 30, 50, 5};
		System.out.println(optimal_bst(freq));
	}

}
