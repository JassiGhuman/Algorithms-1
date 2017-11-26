package dynamic_programming;

public class Max_increasing_sum {

	public static int max_increasing_sum(int a[]) {
		int result[]=a.clone();
		for(int i=1;i<a.length;i++) {
			for(int j=0;j<i;j++) {
				if(a[i]>a[j] && result[j]+a[i]>result[i]) {
					result[i]=result[j]+a[i];
				}
			}
		}
		int max=a[0];
		for(int i=1;i<a.length;i++) {
			System.out.println(result[i]);
			if(result[i]>max)
				max=result[i];
		}
		
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
		  System.out.println(max_increasing_sum(arr));
	}

}
