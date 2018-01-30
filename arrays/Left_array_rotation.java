package arrays;	
//Program for array rotation
public class Left_array_rotation {
	
	 /*Function to left rotate arr[] of size n by d*/
	public static void rotate(int a[],int d) {
		int n=a.length;
		int no_of_sets=gcd(a.length,d);
		int j,k,temp;
		for(int i=0;i<no_of_sets;i++) {
			temp=a[i];
			j=i;
			while(true) {
				k=j+d;
				if(k>=n) {
					k-=n;
				}
				if(k==i) {
					break;
				}
				a[j]=a[k];
				j=k;
			}
			a[j]=temp;
		}
		
		//print array
		for(int x:a) {
			System.out.println(x);
		}
		
	}
	public static int gcd(int a,int b) {
		if(a%b==0)
			return b;
		return gcd(b,a%b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1, 2, 3, 4, 5, 6, 7};
		rotate(a, 7);
	}

}
