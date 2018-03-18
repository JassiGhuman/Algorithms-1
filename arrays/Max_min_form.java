package arrays;

import java.util.ArrayList;

//Java program to rearrange an
//array in minimum maximum form
//O(n) time O(1) space complexity
public class Max_min_form {
	// Prints max at first position, min at second
    //position second max at third position, second
    //min at fourth position and so on.
	
	public static void rearrange(int a[]){
		// initialize index of first minimum and first
        // maximum element
		int n=a.length;
		int max_idx=n-1;
		int min_idx=0;
		int max=a[max_idx]+1;
		for(int i=0;i<n;i++){
			if(i%2==0){
				a[i]+=(a[max_idx]%max)*max;
				max_idx--;
			}
			else{
				a[i]+=(a[min_idx]%max)*max;
				min_idx++;
			}
		}
		//print result array
		for(int x:a){
			x/=max;
			System.out.print(x+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {1,2, 3, 4, 5, 6, 7, 8, 9};
		 rearrange(arr);
	}

}
