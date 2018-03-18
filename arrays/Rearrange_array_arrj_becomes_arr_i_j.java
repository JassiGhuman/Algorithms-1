package arrays;
//A simple Java program to rearrange contents of arr[] 
//such that arr[j] becomes j if arr[i] is j
//O(n) time and O(1) space 
public class Rearrange_array_arrj_becomes_arr_i_j {
	public static void rearrange(int a[]){
		int n=a.length;
		for(int i=0;i<n;i++){
			int j=a[i]%n;
			a[j]=(a[j])+i*n;
		}
		for(int x:a){
			System.out.println(x/n);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 3, 0, 2};
		rearrange(arr);
	}

}
