package dynamic_programming;

public class Cut_a_rod {
	public static int cut(int cost[]) {
		int n=cost.length;
		int cut[]=new int[n+1];
		cut[0]=0;
		for(int i=1;i<=n;i++) {
			int max=cost[i-1];
			for(int j=1;j<i;j++) {
				max=Math.max(max, cut[i-j]+cut[j]);
			}
			cut[i]=max;
		}
		for(int i=0;i<=n;i++) {
			System.out.println(cut[i]);
		}
		return cut[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(cut(arr));
	}

}
