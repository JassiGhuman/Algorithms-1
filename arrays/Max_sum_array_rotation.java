package arrays;
//Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed
public class Max_sum_array_rotation {
	public static int max_sum(int a[]){
		int r1=0;
		int n=a.length;
		int sum=0;
		for(int i=0;i<n;i++)
		{
			r1+=i*a[i];
			sum+=a[i];
		}
		int max=r1;
		for(int i=0;i<n-1;i++){
			r1=r1-sum+a[i]*n;
			max=Math.max(max, r1);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,20,2,10};
		System.out.println(max_sum(arr) );
	}

}
