package arrays;

public class Left_array_rotation_v2 {
	public static void rotate(int a[],int d) {
		int n=a.length;
		d=d%n;
		//1.Reverse a[0] to a[d-1]
		reverse(a, 0, d-1);
		
		//2.Reverse a[d] to a[len-1]
		reverse(a, d, n-1);
		
		//3.Reverse the whole array
		reverse(a,0,n-1);
		
		//print rotated array
		for(int x:a) {
			System.out.println(x);
		}
		
	}
	public static void reverse(int a[],int start,int end) {
		while(start<end) {
			int temp=a[start];
			a[start]=a[end];
			a[end]=temp;
			
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1, 2, 3, 4, 5, 6, 7};
		rotate(a, 8);
	}

}
